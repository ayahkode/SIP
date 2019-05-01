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
        final String alamatPelapor = intent.getStringExtra("alamatPelapor");
        final String alamatPemohon = intent.getStringExtra("alamatPemohon");
        final String alasanPengajuan = intent.getStringExtra("alasanPengajuan");
        final String NamaPelapor = intent.getStringExtra("NamaPelapor");
        final String namaPemohon = intent.getStringExtra("namaPemohon");
        final String telpPemohon = intent.getStringExtra("telpPemohon");
        final String telpPelapor = intent.getStringExtra("telpPelapor");
        final String status = intent.getStringExtra("status");
        final String usiaPemohon = intent.getStringExtra("usiaPemohon");
        final String tanggal = intent.getStringExtra("tanggal");

        txtNamaDetailPelopor.setText("Nama : " + NamaPelapor);
        txtTelpDetailPelopor.setText("Telp : " + telpPelapor);
        txtAlamatDetailPelopor.setText("Alamat : " + alamatPelapor);


        txtNamaDetailPemohon.setText("Nama : " + namaPemohon);
        txtTelpDetailPemohon.setText("Telp : " + telpPemohon);
        txtAlamatDetailPemohon.setText("Alamat : " + alamatPemohon);
        txtUsiaDetailPemohon.setText("Usia : " + usiaPemohon);
        txtKategoriDetailPemohon.setText("Kategory : " + namaKategory);
        txtAlasanPengajuanDetailPemohon.setText("Alasan : " + alasanPengajuan);

        viewVerifikasiPermohonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LembarVerifikasiActivity.class);
                intent.putExtra("idPermohonan", idPermohonan);
                intent.putExtra("idKategory", namaKategory);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate: " + idPermohonan);
    }


}
