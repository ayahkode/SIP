package solidaritasinsanpeduli.com.verifikatorsip.Model;

import com.google.gson.annotations.SerializedName;

public class VerifikasiModel {
    private String usia;
    private String tempatTanggalLahir;
    private String jumlahAnak;
    private String noHp;
    private String statusTempatTinggal;
    private String idKota;
    private String upaya;
    private String usulVerifikator;
    private String alamatTempatTinggal;
    private String kategoriId;
    private String rekomendasi;
    private String id;
    private String catatanTambahan;
    private String idPemohon;
    private String jenisKelamin;
    private String statusPerkawinan;
    private String bantuanLain;
    private String persetujuanFoto;
    private String kontakOrangTerdekat;
    private String statusVerifikasi;
    private String biayaSewa;
    private String trackRecord;
    private String lamaTinggalSekarang;
    private String nama;
    private String pekerjaan;
    private String pendapatanPerbulan;
    private String pengamatanVisual;
    private String masalah;


    public VerifikasiModel(String usia, String tempatTanggalLahir, String jumlahAnak, String noHp, String statusTempatTinggal,
                           String idKota, String upaya, String usulVerifikator, String alamatTempatTinggal, String kategoriId,
                           String rekomendasi, String id, String catatanTambahan, String idPemohon, String jenisKelamin,
                           String statusPerkawinan, String bantuanLain, String persetujuanFoto, String kontakOrangTerdekat,
                           String statusVerifikasi, String biayaSewa, String trackRecord, String lamaTinggalSekarang,
                           String nama, String pekerjaan, String pendapatanPerbulan, String pengamatanVisual, String masalah) {
        this.usia = usia;
        this.tempatTanggalLahir = tempatTanggalLahir;
        this.jumlahAnak = jumlahAnak;
        this.noHp = noHp;
        this.statusTempatTinggal = statusTempatTinggal;
        this.idKota = idKota;
        this.upaya = upaya;
        this.usulVerifikator = usulVerifikator;
        this.alamatTempatTinggal = alamatTempatTinggal;
        this.kategoriId = kategoriId;
        this.rekomendasi = rekomendasi;
        this.id = id;
        this.catatanTambahan = catatanTambahan;
        this.idPemohon = idPemohon;
        this.jenisKelamin = jenisKelamin;
        this.statusPerkawinan = statusPerkawinan;
        this.bantuanLain = bantuanLain;
        this.persetujuanFoto = persetujuanFoto;
        this.kontakOrangTerdekat = kontakOrangTerdekat;
        this.statusVerifikasi = statusVerifikasi;
        this.biayaSewa = biayaSewa;
        this.trackRecord = trackRecord;
        this.lamaTinggalSekarang = lamaTinggalSekarang;
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.pendapatanPerbulan = pendapatanPerbulan;
        this.pengamatanVisual = pengamatanVisual;
        this.masalah = masalah;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getTempatTanggalLahir() {
        return tempatTanggalLahir;
    }

    public void setTempatTanggalLahir(String tempatTanggalLahir) {
        this.tempatTanggalLahir = tempatTanggalLahir;
    }

    public String getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(String jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getStatusTempatTinggal() {
        return statusTempatTinggal;
    }

    public void setStatusTempatTinggal(String statusTempatTinggal) {
        this.statusTempatTinggal = statusTempatTinggal;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }

    public String getUpaya() {
        return upaya;
    }

    public void setUpaya(String upaya) {
        this.upaya = upaya;
    }

    public String getUsulVerifikator() {
        return usulVerifikator;
    }

    public void setUsulVerifikator(String usulVerifikator) {
        this.usulVerifikator = usulVerifikator;
    }

    public String getAlamatTempatTinggal() {
        return alamatTempatTinggal;
    }

    public void setAlamatTempatTinggal(String alamatTempatTinggal) {
        this.alamatTempatTinggal = alamatTempatTinggal;
    }

    public String getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(String kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(String rekomendasi) {
        this.rekomendasi = rekomendasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatatanTambahan() {
        return catatanTambahan;
    }

    public void setCatatanTambahan(String catatanTambahan) {
        this.catatanTambahan = catatanTambahan;
    }

    public String getIdPemohon() {
        return idPemohon;
    }

    public void setIdPemohon(String idPemohon) {
        this.idPemohon = idPemohon;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getBantuanLain() {
        return bantuanLain;
    }

    public void setBantuanLain(String bantuanLain) {
        this.bantuanLain = bantuanLain;
    }

    public String getPersetujuanFoto() {
        return persetujuanFoto;
    }

    public void setPersetujuanFoto(String persetujuanFoto) {
        this.persetujuanFoto = persetujuanFoto;
    }

    public String getKontakOrangTerdekat() {
        return kontakOrangTerdekat;
    }

    public void setKontakOrangTerdekat(String kontakOrangTerdekat) {
        this.kontakOrangTerdekat = kontakOrangTerdekat;
    }

    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(String statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    public String getBiayaSewa() {
        return biayaSewa;
    }

    public void setBiayaSewa(String biayaSewa) {
        this.biayaSewa = biayaSewa;
    }

    public String getTrackRecord() {
        return trackRecord;
    }

    public void setTrackRecord(String trackRecord) {
        this.trackRecord = trackRecord;
    }

    public String getLamaTinggalSekarang() {
        return lamaTinggalSekarang;
    }

    public void setLamaTinggalSekarang(String lamaTinggalSekarang) {
        this.lamaTinggalSekarang = lamaTinggalSekarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendapatanPerbulan() {
        return pendapatanPerbulan;
    }

    public void setPendapatanPerbulan(String pendapatanPerbulan) {
        this.pendapatanPerbulan = pendapatanPerbulan;
    }

    public String getPengamatanVisual() {
        return pengamatanVisual;
    }

    public void setPengamatanVisual(String pengamatanVisual) {
        this.pengamatanVisual = pengamatanVisual;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }
}
