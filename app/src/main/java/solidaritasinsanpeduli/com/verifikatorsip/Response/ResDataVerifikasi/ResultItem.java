package solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataVerifikasi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultItem implements Serializable {

	@SerializedName("usia")
	private String usia;

	@SerializedName("tempat_tanggal_lahir")
	private String tempatTanggalLahir;

	@SerializedName("jumlah_anak")
	private String jumlahAnak;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("status_tempat_tinggal")
	private String statusTempatTinggal;

	@SerializedName("id_kota")
	private String idKota;

	@SerializedName("upaya")
	private String upaya;

	@SerializedName("usul_verifikator")
	private String usulVerifikator;

	@SerializedName("alamat_tempat_tinggal")
	private String alamatTempatTinggal;

	@SerializedName("kategori_id")
	private String kategoriId;

	@SerializedName("rekomendasi")
	private String rekomendasi;

	@SerializedName("id")
	private String id;

	@SerializedName("catatan_tambahan")
	private String catatanTambahan;

	@SerializedName("id_pemohon")
	private String idPemohon;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("status_perkawinan")
	private String statusPerkawinan;

	@SerializedName("bantuan_lain")
	private String bantuanLain;

	@SerializedName("persetujuan_foto")
	private String persetujuanFoto;

	@SerializedName("kontak_orang_terdekat")
	private String kontakOrangTerdekat;

	@SerializedName("status_verifikasi")
	private String statusVerifikasi;

	@SerializedName("biaya_sewa")
	private String biayaSewa;

	@SerializedName("track_record")
	private String trackRecord;

	@SerializedName("lama_tinggal_sekarang")
	private String lamaTinggalSekarang;

	@SerializedName("nama")
	private String nama;

	@SerializedName("pekerjaan")
	private String pekerjaan;

	@SerializedName("pendapatan_perbulan")
	private String pendapatanPerbulan;

	@SerializedName("pengamatan_visual")
	private String pengamatanVisual;

	@SerializedName("masalah")
	private String masalah;

	public void setUsia(String usia){
		this.usia = usia;
	}

	public String getUsia(){
		return usia;
	}

	public void setTempatTanggalLahir(String tempatTanggalLahir){
		this.tempatTanggalLahir = tempatTanggalLahir;
	}

	public String getTempatTanggalLahir(){
		return tempatTanggalLahir;
	}

	public void setJumlahAnak(String jumlahAnak){
		this.jumlahAnak = jumlahAnak;
	}

	public String getJumlahAnak(){
		return jumlahAnak;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setStatusTempatTinggal(String statusTempatTinggal){
		this.statusTempatTinggal = statusTempatTinggal;
	}

	public String getStatusTempatTinggal(){
		return statusTempatTinggal;
	}

	public void setIdKota(String idKota){
		this.idKota = idKota;
	}

	public String getIdKota(){
		return idKota;
	}

	public void setUpaya(String upaya){
		this.upaya = upaya;
	}

	public String getUpaya(){
		return upaya;
	}

	public void setUsulVerifikator(String usulVerifikator){
		this.usulVerifikator = usulVerifikator;
	}

	public String getUsulVerifikator(){
		return usulVerifikator;
	}

	public void setAlamatTempatTinggal(String alamatTempatTinggal){
		this.alamatTempatTinggal = alamatTempatTinggal;
	}

	public String getAlamatTempatTinggal(){
		return alamatTempatTinggal;
	}

	public void setKategoriId(String kategoriId){
		this.kategoriId = kategoriId;
	}

	public String getKategoriId(){
		return kategoriId;
	}

	public void setRekomendasi(String rekomendasi){
		this.rekomendasi = rekomendasi;
	}

	public String getRekomendasi(){
		return rekomendasi;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCatatanTambahan(String catatanTambahan){
		this.catatanTambahan = catatanTambahan;
	}

	public String getCatatanTambahan(){
		return catatanTambahan;
	}

	public void setIdPemohon(String idPemohon){
		this.idPemohon = idPemohon;
	}

	public String getIdPemohon(){
		return idPemohon;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setStatusPerkawinan(String statusPerkawinan){
		this.statusPerkawinan = statusPerkawinan;
	}

	public String getStatusPerkawinan(){
		return statusPerkawinan;
	}

	public void setBantuanLain(String bantuanLain){
		this.bantuanLain = bantuanLain;
	}

	public String getBantuanLain(){
		return bantuanLain;
	}

	public void setPersetujuanFoto(String persetujuanFoto){
		this.persetujuanFoto = persetujuanFoto;
	}

	public String getPersetujuanFoto(){
		return persetujuanFoto;
	}

	public void setKontakOrangTerdekat(String kontakOrangTerdekat){
		this.kontakOrangTerdekat = kontakOrangTerdekat;
	}

	public String getKontakOrangTerdekat(){
		return kontakOrangTerdekat;
	}

	public void setStatusVerifikasi(String statusVerifikasi){
		this.statusVerifikasi = statusVerifikasi;
	}

	public String getStatusVerifikasi(){
		return statusVerifikasi;
	}

	public void setBiayaSewa(String biayaSewa){
		this.biayaSewa = biayaSewa;
	}

	public String getBiayaSewa(){
		return biayaSewa;
	}

	public void setTrackRecord(String trackRecord){
		this.trackRecord = trackRecord;
	}

	public String getTrackRecord(){
		return trackRecord;
	}

	public void setLamaTinggalSekarang(String lamaTinggalSekarang){
		this.lamaTinggalSekarang = lamaTinggalSekarang;
	}

	public String getLamaTinggalSekarang(){
		return lamaTinggalSekarang;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setPekerjaan(String pekerjaan){
		this.pekerjaan = pekerjaan;
	}

	public String getPekerjaan(){
		return pekerjaan;
	}

	public void setPendapatanPerbulan(String pendapatanPerbulan){
		this.pendapatanPerbulan = pendapatanPerbulan;
	}

	public String getPendapatanPerbulan(){
		return pendapatanPerbulan;
	}

	public void setPengamatanVisual(String pengamatanVisual){
		this.pengamatanVisual = pengamatanVisual;
	}

	public String getPengamatanVisual(){
		return pengamatanVisual;
	}

	public void setMasalah(String masalah){
		this.masalah = masalah;
	}

	public String getMasalah(){
		return masalah;
	}
}