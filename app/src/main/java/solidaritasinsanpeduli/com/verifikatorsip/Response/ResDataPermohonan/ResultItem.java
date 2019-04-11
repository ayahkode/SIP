package solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataPermohonan;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("kategori_permohonan")
	private String kategoriPermohonan;

	@SerializedName("nama_pelapor")
	private String namaPelapor;

	@SerializedName("usia_pemohon")
	private String usiaPemohon;

	@SerializedName("alamat_pemohon")
	private String alamatPemohon;

	@SerializedName("telp_pelapor")
	private String telpPelapor;

	@SerializedName("alasan_pengajuan")
	private String alasanPengajuan;

	@SerializedName("id")
	private String id;

	@SerializedName("alamat_pelapor")
	private String alamatPelapor;

	@SerializedName("ntelp_pemohon")
	private String ntelpPemohon;

	@SerializedName("nama_pemohon")
	private String namaPemohon;

	@SerializedName("status")
	private String status;
	@SerializedName("tanggal")
	private String tanggal;

	public void setKategoriPermohonan(String kategoriPermohonan){
		this.kategoriPermohonan = kategoriPermohonan;
	}

	public String getKategoriPermohonan(){
		return kategoriPermohonan;
	}

	public void setNamaPelapor(String namaPelapor){
		this.namaPelapor = namaPelapor;
	}

	public String getNamaPelapor(){
		return namaPelapor;
	}

	public void setUsiaPemohon(String usiaPemohon){
		this.usiaPemohon = usiaPemohon;
	}

	public String getUsiaPemohon(){
		return usiaPemohon;
	}

	public void setAlamatPemohon(String alamatPemohon){
		this.alamatPemohon = alamatPemohon;
	}

	public String getAlamatPemohon(){
		return alamatPemohon;
	}

	public void setTelpPelapor(String telpPelapor){
		this.telpPelapor = telpPelapor;
	}

	public String getTelpPelapor(){
		return telpPelapor;
	}

	public void setAlasanPengajuan(String alasanPengajuan){
		this.alasanPengajuan = alasanPengajuan;
	}

	public String getAlasanPengajuan(){
		return alasanPengajuan;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAlamatPelapor(String alamatPelapor){
		this.alamatPelapor = alamatPelapor;
	}

	public String getAlamatPelapor(){
		return alamatPelapor;
	}

	public void setNtelpPemohon(String ntelpPemohon){
		this.ntelpPemohon = ntelpPemohon;
	}

	public String getNtelpPemohon(){
		return ntelpPemohon;
	}

	public void setNamaPemohon(String namaPemohon){
		this.namaPemohon = namaPemohon;
	}

	public String getNamaPemohon(){
		return namaPemohon;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
}