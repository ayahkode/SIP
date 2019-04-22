package solidaritasinsanpeduli.com.verifikatorsip.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.Adapter.PermohonanAdapter;
import solidaritasinsanpeduli.com.verifikatorsip.Model.PermohonanModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataPermohonan.ResponsePermohonan;
import solidaritasinsanpeduli.com.verifikatorsip.Response.Response;

import static android.content.ContentValues.TAG;

public class DetailPermohonanActivity extends AppCompatActivity {

    private TextView txtContohLayout;

    @BindView(R.id.progress_detail_permohonan)
    View progressBarPermohonan;
    @BindView(R.id.view_detail_permohonan)
    View viewPermohonan;


    @BindView(R.id.txt_nama_detail_pelapor)
    TextView txtNamaDetailPelopor;
    @BindView(R.id.txt_telp_detail_pelapor)
    TextView txtTelpDetailPelopor;
    @BindView(R.id.txt_alamat_detail_pelapor)
    TextView txtAlamatDetailPelopor;


    @BindView(R.id.txt_nama_detail_pemohon)
    TextView txtNamaDetailPemohon;
    @BindView(R.id.txt_telp_detail_pemohon)
    TextView txtTelpDetailPemohon;
    @BindView(R.id.txt_alamat_detail_pemohon)
    TextView txtAlamatDetailPemohon;
    @BindView(R.id.txt_usia_detail_pemohon)
    TextView txtUsiaDetailPemohon;
    @BindView(R.id.txt_kategori_detail_pemohon)
    TextView txtKategoriDetailPemohon;
    @BindView(R.id.txt_alasan_pengajuan_detail_pemohon)
    TextView txtAlasanPengajuanDetailPemohon;
    @BindView(R.id.view_verifikasi_pemohon)
    View viewVerifikasiPermohonan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_permohonan);

        ButterKnife.bind(this);
        AndroidNetworking.initialize(this.getApplicationContext());

        Intent intent = getIntent();
        final String idPermohonan = intent.getStringExtra("idPermohonan");
        final String namaKategory = intent.getStringExtra("idKategory");

        getDataPermohonan(idPermohonan);
    }

    public void getDataPermohonan(String idPermohonan) {
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get("https://algoritmakopi.com/sip_api/public/getDataPermohonanByIdPermohonan/"+idPermohonan)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponsePermohonan.class, new ParsedRequestListener<ResponsePermohonan>() {
                    @Override
                    public void onResponse(final ResponsePermohonan responsePermohonan) {
                        if (responsePermohonan.getResult().size() > 0) {
                            progressBarPermohonan.setVisibility(View.GONE);
                            viewPermohonan.setVisibility(View.VISIBLE);

                            txtNamaDetailPelopor.setText("Nama : " + responsePermohonan.getResult().get(0).getNamaPelapor());
                            txtTelpDetailPelopor.setText("Telp : " + responsePermohonan.getResult().get(0).getTelpPelapor());
                            txtAlamatDetailPelopor.setText("Alamat : " + responsePermohonan.getResult().get(0).getAlamatPelapor());


                            txtNamaDetailPemohon.setText("Nama : " + responsePermohonan.getResult().get(0).getNamaPelapor());
                            txtTelpDetailPemohon.setText("Telp : " + responsePermohonan.getResult().get(0).getTelpPelapor());
                            txtAlamatDetailPemohon.setText("Alamat : " + responsePermohonan.getResult().get(0).getAlamatPelapor());
                            txtUsiaDetailPemohon.setText("Nama : " + responsePermohonan.getResult().get(0).getUsiaPemohon());
                            txtKategoriDetailPemohon.setText("Telp : " + responsePermohonan.getResult().get(0).getKategoriPermohonan());
                            txtAlasanPengajuanDetailPemohon.setText("Alasan : " + responsePermohonan.getResult().get(0).getAlasanPengajuan());

                            viewVerifikasiPermohonan.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getApplicationContext(), LembarVerifikasiActivity.class);
                                    intent.putExtra("idPermohonan", responsePermohonan.getResult().get(0).getId());
                                    intent.putExtra("idKategory", responsePermohonan.getResult().get(0).getKategoriPermohonan());
                                    startActivity(intent);
                                }
                            });
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
