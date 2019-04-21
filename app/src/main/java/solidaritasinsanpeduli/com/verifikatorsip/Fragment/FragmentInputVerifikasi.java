package solidaritasinsanpeduli.com.verifikatorsip.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.Adapter.PermohonanAdapter;
import solidaritasinsanpeduli.com.verifikatorsip.Model.PermohonanModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataPermohonan.ResponsePermohonan;
import solidaritasinsanpeduli.com.verifikatorsip.Response.Response;

import static android.content.ContentValues.TAG;

public class FragmentInputVerifikasi extends Fragment {

    @BindView(R.id.fab_input_permohonan)
    FloatingActionButton fabInputDataPermohonan;
    @BindView(R.id.rv_permohonan)
    RecyclerView recyclerViewPermohonan;


    //data permohonan
    Button btnViewKirimPermohonan;
    EditText txtNamaPemohon;
    EditText txtUsiaPemohon;
    EditText txtAlamatPemohon;
    EditText txtTelpPemohon;
    EditText txtMasalahPemohon;
    EditText txtNamaPelapor;
    EditText txtAlamatPelapor;
    EditText txtTelpPelapor;
    Spinner spinKategoryBantuan;


    @BindView(R.id.progress_permohonan)
    View progressBarPermohonan;
    @BindView(R.id.view_permohonan)
    View viewPermohonan;

    private List<PermohonanModel> permohonanModelList;
    private PermohonanAdapter permohonanAdapter;
    private PermohonanModel permohonanModel;
    public BottomSheetDialog dialog;

    public FragmentInputVerifikasi() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static FragmentInputVerifikasi newInstance() {
        FragmentInputVerifikasi fragment = new FragmentInputVerifikasi();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_permohonan, container, false);
        ButterKnife.bind(this, view);
        AndroidNetworking.initialize(this.getActivity().getApplicationContext());

        getDataPermohonan(1);
        fabInputDataPermohonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "FloatingBotton", Toast.LENGTH_SHORT).show();
                Log.v("CLICKED", "Floating Botton");
                viewInputPermohonan();
            }
        });

        return view;
    }

    public void viewInputPermohonan() {
        View viewCreateProductFragment = getLayoutInflater().inflate(R.layout.create_data_permohonan_layout, null);

        btnViewKirimPermohonan = (Button) viewCreateProductFragment.findViewById(R.id.btn_view_kirim_permohonan);
        txtNamaPemohon = (EditText) viewCreateProductFragment.findViewById(R.id.txt_nama_pemohon);
        txtUsiaPemohon = (EditText) viewCreateProductFragment.findViewById(R.id.txt_usia_pemohon);
        txtAlamatPemohon = (EditText) viewCreateProductFragment.findViewById(R.id.txt_alasan_permohonan);
        txtTelpPemohon = (EditText) viewCreateProductFragment.findViewById(R.id.txt_telp_pemohon);
        txtMasalahPemohon = (EditText) viewCreateProductFragment.findViewById(R.id.txt_alasan_permohonan);
        txtNamaPelapor = (EditText) viewCreateProductFragment.findViewById(R.id.txt_nama_pelapor);
        txtAlamatPelapor = (EditText) viewCreateProductFragment.findViewById(R.id.txt_alamat_pelapor);
        txtTelpPelapor = (EditText) viewCreateProductFragment.findViewById(R.id.txt_telp_pelapor);
        spinKategoryBantuan = (Spinner) viewCreateProductFragment.findViewById(R.id.spin_kategory_bantuan);


        btnViewKirimPermohonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewNextInputVerifikator();
                AndroidNetworking.initialize(getContext());
                AndroidNetworking.post("http://algoritmakopi.com/sip_api/public/postDataPelaporan")
                        .addBodyParameter("nama_pelapor", txtNamaPelapor.getText().toString())
                        .addBodyParameter("alamat_pelapor", txtAlamatPelapor.getText().toString())
                        .addBodyParameter("telp_pelapor", txtTelpPelapor.getText().toString())
                        .addBodyParameter("nama_pemohon", txtNamaPemohon.getText().toString())
                        .addBodyParameter("usia_pemohon", txtUsiaPemohon.getText().toString())
                        .addBodyParameter("alamat_pemohon", txtAlamatPemohon.getText().toString())
                        .addBodyParameter("telp_pemohon", txtTelpPemohon.getText().toString())
                        .addBodyParameter("alasan_pengajuan", txtMasalahPemohon.getText().toString())
                        .addBodyParameter("kategori_permohonan", "1")
                        .addBodyParameter("status", "0")
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsObject(Response.class, new ParsedRequestListener<Response>() {
                            @Override
                            public void onResponse(Response response) {
                                Log.d(TAG, "onResponse: " + response.getResult());
                                if (response.getResult().equals("1")) {
                                    getDataPermohonan(1);
                                    dialog.dismiss();
                                    Toast.makeText(getContext(), response.getStatus(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), response.getStatus(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                // handle errorLog.d(TAG, "onError: " + anError.toString());
                            }
                        });
            }
        });
        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(viewCreateProductFragment);
        dialog.show();
    }

    public void viewNextInputVerifikator() {
        View viewCreateProductFragment = getLayoutInflater().inflate(R.layout.create_next_verifikasi_layout, null);

        AndroidNetworking.initialize(viewCreateProductFragment.getContext().getApplicationContext());

        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(viewCreateProductFragment);
        dialog.show();
    }

    public void getDataPermohonan(int idKota) {
        permohonanModelList = new ArrayList<>();
        AndroidNetworking.initialize(getContext());
        AndroidNetworking.get("https://algoritmakopi.com/sip_api/public/getDataPermohonan/"+idKota)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponsePermohonan.class, new ParsedRequestListener<ResponsePermohonan>() {
                    @Override
                    public void onResponse(ResponsePermohonan responsePermohonan) {
                        if (responsePermohonan.getResult().size() > 0) {
                            progressBarPermohonan.setVisibility(View.GONE);
                            viewPermohonan.setVisibility(View.VISIBLE);
                            for (int i = 0; i < responsePermohonan.getResult().size(); i++) {

                                permohonanModel = new PermohonanModel(responsePermohonan.getResult().get(i).getKategoriPermohonan(),
                                        responsePermohonan.getResult().get(i).getNamaPelapor(),
                                        responsePermohonan.getResult().get(i).getUsiaPemohon(),
                                        responsePermohonan.getResult().get(i).getAlamatPemohon(),
                                        responsePermohonan.getResult().get(i).getTelpPelapor(),
                                        responsePermohonan.getResult().get(i).getAlasanPengajuan(),
                                        responsePermohonan.getResult().get(i).getId(),
                                        responsePermohonan.getResult().get(i).getAlamatPelapor(),
                                        responsePermohonan.getResult().get(i).getNtelpPemohon(),
                                        responsePermohonan.getResult().get(i).getNamaPemohon(),
                                        responsePermohonan.getResult().get(i).getStatus(),
                                        responsePermohonan.getResult().get(i).getTanggal());
                                permohonanModelList.add(permohonanModel);
                            }
                            LinearLayoutManager layoutManager
                                    = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            recyclerViewPermohonan.setAdapter(new PermohonanAdapter(permohonanModelList, R.layout.card_list_pemohon, getContext()));
                            recyclerViewPermohonan.setLayoutManager(layoutManager);

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
