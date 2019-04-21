package solidaritasinsanpeduli.com.verifikatorsip.View;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.Response.Response;

import static android.content.ContentValues.TAG;

public class LembarVerifikasiActivity extends AppCompatActivity {

    TextView txtVerifikasiNama, txtVerifikasiTTL, txtVerifikasiUsia, txtVerifikasiJenisKelamin,
            txtVerifikasiStatusPernikahan, txtVerifikasiPekerjaan, txtVerifikasiJumlahAnak,
            txtVerifikasiHP, txtVerifikasiAlamat, txtVerifikasiStatusTempat, txtVerifikasiBiayaSewa,
            txtVerifikasiBantuanLain, txtVerifikasiKontakOrangTerdekat, txtVerifikasiMasalahYangDihadapi,
            txtVerifikasiUpaya, txtVerifikasiRekomendasiVerifikator, txtVerifikasiPengamatanVisual,
            txtVerifikasiTrackRecord, txtVerifikasiPersetujuanFoto, txtVerifikasiUsulVerifikator,
            txtVerifikasiCatatanTambahan, txtVerifikasPendapatanBulanan;
    Button btnKirim;
    String idKategory = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_next_verifikasi_layout);
        btnKirim = (Button) findViewById(R.id.btn_view_input_verifikasi_kirim);
        txtVerifikasiNama = (TextView) findViewById(R.id.txt_verifikasi_nama);
        txtVerifikasiTTL = (TextView) findViewById(R.id.txt_verifikasi_ttl);
        txtVerifikasiUsia = (TextView) findViewById(R.id.txt_verifikasi_usia);
        txtVerifikasiJenisKelamin = (TextView) findViewById(R.id.txt_verifikasi_jeniskelamin);
        txtVerifikasiStatusPernikahan = (TextView) findViewById(R.id.txt_verifikasi_statuspernikahan);
        txtVerifikasiPekerjaan = (TextView) findViewById(R.id.txt_verifikasi_pekerjaan);
        txtVerifikasiJumlahAnak = (TextView) findViewById(R.id.txt_verifikasi_jumlahanak);
        txtVerifikasiHP = (TextView) findViewById(R.id.txt_verifikasi_nohp);
        txtVerifikasiAlamat = (TextView) findViewById(R.id.txt_verifikasi_alamat);
        txtVerifikasiStatusTempat = (TextView) findViewById(R.id.txt_verifikasi_status_tempat_tinggal);
        txtVerifikasiBiayaSewa = (TextView) findViewById(R.id.txt_verifikasi_biaya_kontrakansewa);
        txtVerifikasiBantuanLain = (TextView) findViewById(R.id.txt_verifikasi_bantuan_lain);
        txtVerifikasiKontakOrangTerdekat = (TextView) findViewById(R.id.txt_verifikasi_kontak_orang_terdekat);
        txtVerifikasiMasalahYangDihadapi = (TextView) findViewById(R.id.txt_verifikasi_masalah_yang_dihadapi);
        txtVerifikasiUpaya = (TextView) findViewById(R.id.txt_verifikasi_upaya_yangdilakukan);
        txtVerifikasiRekomendasiVerifikator = (TextView) findViewById(R.id.txt_verifikasi_rekomendasi_keprogram_sip);
        txtVerifikasiPengamatanVisual = (TextView) findViewById(R.id.txt_verifikasi_pengamatan_visual_rumah);
        txtVerifikasiTrackRecord = (TextView) findViewById(R.id.txt_verifikasi_track_record);
        txtVerifikasiPersetujuanFoto = (TextView) findViewById(R.id.txt_verifikasi_persetuju_publikasi_foto);
        txtVerifikasiUsulVerifikator = (TextView) findViewById(R.id.txt_verifikasi_usul_verifikator);
        txtVerifikasiCatatanTambahan = (TextView) findViewById(R.id.txt_verifikasi_catatan_tambahan);
        txtVerifikasPendapatanBulanan = (TextView) findViewById(R.id.txt_verifikasi_pendapatan_bulanan);

        Intent intent = getIntent();
        final String idPermohonan = intent.getStringExtra("idPermohonan");
        final String namaKategory = intent.getStringExtra("idKategory");

        if (namaKategory.equals("KESEHATAN")){
            idKategory = "1";
            btnKirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewInputVerifikasi(idKategory,idPermohonan);

                }
            });
        } else if (namaKategory.equals("PENDIDIKAN")){
            idKategory = "2";
            btnKirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewInputVerifikasi(idKategory,idPermohonan);

                }
            });
        } else if (namaKategory.equals("KEBUTUHAN SEHARI-HARI\n")){
            idKategory = "3";
            btnKirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewInputVerifikasi(idKategory,idPermohonan);

                }
            });
        }


    }


    public void viewInputVerifikasi(final String idCategory, final String idPemohon) {
        Log.d(TAG, "viewInputVerifikasi: " + idCategory + ","+idPemohon);
                AndroidNetworking.initialize(getApplicationContext());
                AndroidNetworking.post("http://algoritmakopi.com/sip_api/public/postDataVerifikasi" +
                        "")
                        .addBodyParameter("kategori_id", idCategory)
                        .addBodyParameter("id_pemohon",idPemohon )
                        .addBodyParameter("nama", txtVerifikasiNama.getText().toString())
                        .addBodyParameter("tempat_tanggal_lahir", txtVerifikasiTTL.getText().toString())
                        .addBodyParameter("usia", txtVerifikasiUsia.getText().toString())
                        .addBodyParameter("jenis_kelamin", txtVerifikasiJenisKelamin.getText().toString())
                        .addBodyParameter("status_perkawinan", txtVerifikasiStatusPernikahan.getText().toString())
                        .addBodyParameter("pekerjaan", txtVerifikasiPekerjaan.getText().toString())
                        .addBodyParameter("jumlah_anak", txtVerifikasiJumlahAnak.getText().toString())
                        .addBodyParameter("no_hp", txtVerifikasiHP.getText().toString())
                        .addBodyParameter("alamat_tempat_tinggal", txtVerifikasiAlamat.getText().toString())
                        .addBodyParameter("lama_tinggal_sekarang", "-")
                        .addBodyParameter("status_tempat_tinggal", "-")
                        .addBodyParameter("biaya_sewa", txtVerifikasiBiayaSewa.getText().toString())
                        .addBodyParameter("pendapatan_perbulan", txtVerifikasPendapatanBulanan.getText().toString())
                        .addBodyParameter("bantuan_lain", txtVerifikasiBantuanLain.getText().toString())
                        .addBodyParameter("kontak_orang_terdekat", txtVerifikasiKontakOrangTerdekat.getText().toString())
                        .addBodyParameter("masalah", txtVerifikasiMasalahYangDihadapi.getText().toString())
                        .addBodyParameter("upaya", txtVerifikasiUpaya.getText().toString())
                        .addBodyParameter("rekomendasi", txtVerifikasiRekomendasiVerifikator.getText().toString())
                        .addBodyParameter("pengamatan_visual", txtVerifikasiPengamatanVisual.getText().toString())
                        .addBodyParameter("track_record", txtVerifikasiTrackRecord.getText().toString())
                        .addBodyParameter("persetujuan_foto", txtVerifikasiPersetujuanFoto.getText().toString())
                        .addBodyParameter("catatan_tambahan", txtVerifikasiCatatanTambahan.getText().toString())
                        .addBodyParameter("usul_verifikator", txtVerifikasiUsulVerifikator.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsObject(Response.class, new ParsedRequestListener<Response>() {
                            @Override
                            public void onResponse(Response response) {
                                Log.d(TAG, "onResponse: " + response.getResult());
                                        txtVerifikasiNama.setText("");
                                        txtVerifikasiTTL.setText("");
                                        txtVerifikasiUsia.setText("");
                                        txtVerifikasiJenisKelamin.setText("");
                                        txtVerifikasiStatusPernikahan.setText("");
                                        txtVerifikasiPekerjaan.setText("");
                                        txtVerifikasiJumlahAnak.setText("");
                                        txtVerifikasiHP.setText("");
                                        txtVerifikasiAlamat.setText("");
                                        txtVerifikasiBiayaSewa.setText("");
                                        txtVerifikasPendapatanBulanan.setText("");
                                        txtVerifikasiBantuanLain.setText("");
                                        txtVerifikasiKontakOrangTerdekat.setText("");
                                        txtVerifikasiMasalahYangDihadapi.setText("");
                                        txtVerifikasiUpaya.setText("");
                                        txtVerifikasiRekomendasiVerifikator.setText("");
                                        txtVerifikasiPengamatanVisual.setText("");
                                        txtVerifikasiTrackRecord.setText("");
                                        txtVerifikasiPersetujuanFoto.setText("");
                                        txtVerifikasiCatatanTambahan.setText("");
                                        txtVerifikasiUsulVerifikator.setText("");
                            }

                            @Override
                            public void onError(ANError anError) {
                                // handle errorLog.d(TAG, "onError: " + anError.toString());
                            }
                        });
    }
}
