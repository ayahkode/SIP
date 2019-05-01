package solidaritasinsanpeduli.com.verifikatorsip.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.Adapter.PermohonanAdapter;
import solidaritasinsanpeduli.com.verifikatorsip.Adapter.VerifikasiListAdapter;
import solidaritasinsanpeduli.com.verifikatorsip.Model.PermohonanModel;
import solidaritasinsanpeduli.com.verifikatorsip.Model.VerifikasiModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataPermohonan.ResponsePermohonan;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataVerifikasi.ResponseVerifikasi;

import static android.content.ContentValues.TAG;

public class FragmentReportVerifikasi extends Fragment {

    @BindView(R.id.rv_verifikasi)
    RecyclerView recyclerViewVerifikasi;
    @BindView(R.id.progress_verifikasi)
    ProgressBar progressBarVerifikasi;
    @BindView(R.id.view_verifikasi)
    View viewVerifikasi;

    private List<VerifikasiModel> verifikasiModelList;
    private VerifikasiListAdapter verifikasiListAdapter;
    private VerifikasiModel verifikasiModel;
    public FragmentReportVerifikasi() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static FragmentReportVerifikasi newInstance() {
        FragmentReportVerifikasi fragment = new FragmentReportVerifikasi();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_verifikasi, container, false);
        ButterKnife.bind(this, view);
        AndroidNetworking.initialize(this.getActivity().getApplicationContext());

        getDataVerifikasi(1);
        return view;
    }

    public void getDataVerifikasi(int idKota) {
        verifikasiModelList = new ArrayList<>();
        AndroidNetworking.initialize(getContext());
        AndroidNetworking.get("https://algoritmakopi.com/sip_api/public/getVerifikasi/"+idKota)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseVerifikasi.class, new ParsedRequestListener<ResponseVerifikasi>() {
                    @Override
                    public void onResponse(ResponseVerifikasi responseVerifikasi) {
                        if (responseVerifikasi.getResult().size() > 0) {
                            progressBarVerifikasi.setVisibility(View.GONE);
                            viewVerifikasi.setVisibility(View.VISIBLE);
                            for (int i = 0; i < responseVerifikasi.getResult().size(); i++) {

                                verifikasiModel = new VerifikasiModel(responseVerifikasi.getResult().get(i).getUsia(),
                                        responseVerifikasi.getResult().get(i).getTempatTanggalLahir(),
                                        responseVerifikasi.getResult().get(i).getJumlahAnak(),
                                        responseVerifikasi.getResult().get(i).getNoHp(),
                                        responseVerifikasi.getResult().get(i).getStatusTempatTinggal(),
                                        responseVerifikasi.getResult().get(i).getIdKota(),
                                        responseVerifikasi.getResult().get(i).getUpaya(),
                                        responseVerifikasi.getResult().get(i).getUsulVerifikator(),
                                        responseVerifikasi.getResult().get(i).getAlamatTempatTinggal(),
                                        responseVerifikasi.getResult().get(i).getKategoriId(),
                                        responseVerifikasi.getResult().get(i).getRekomendasi(),
                                        responseVerifikasi.getResult().get(i).getId(),
                                        responseVerifikasi.getResult().get(i).getCatatanTambahan(),
                                        responseVerifikasi.getResult().get(i).getIdPemohon(),
                                        responseVerifikasi.getResult().get(i).getJenisKelamin(),
                                        responseVerifikasi.getResult().get(i).getStatusPerkawinan(),
                                        responseVerifikasi.getResult().get(i).getBantuanLain(),
                                        responseVerifikasi.getResult().get(i).getPersetujuanFoto(),
                                        responseVerifikasi.getResult().get(i).getKontakOrangTerdekat(),
                                        responseVerifikasi.getResult().get(i).getStatusVerifikasi(),
                                        responseVerifikasi.getResult().get(i).getBiayaSewa(),
                                        responseVerifikasi.getResult().get(i).getTrackRecord(),
                                        responseVerifikasi.getResult().get(i).getLamaTinggalSekarang(),
                                        responseVerifikasi.getResult().get(i).getNama(),
                                        responseVerifikasi.getResult().get(i).getPekerjaan(),
                                        responseVerifikasi.getResult().get(i).getPendapatanPerbulan(),
                                        responseVerifikasi.getResult().get(i).getPengamatanVisual(),
                                        responseVerifikasi.getResult().get(i).getMasalah());
                                verifikasiModelList.add(verifikasiModel);
                            }
                            LinearLayoutManager layoutManager
                                    = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            recyclerViewVerifikasi.setAdapter(new VerifikasiListAdapter(verifikasiModelList, R.layout.card_list_verifikasi, getContext()));
                            recyclerViewVerifikasi.setLayoutManager(layoutManager);

                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "onError: " + anError.toString());
                    }
                });
    }
}
