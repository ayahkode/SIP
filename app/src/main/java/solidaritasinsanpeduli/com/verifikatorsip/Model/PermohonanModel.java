package solidaritasinsanpeduli.com.verifikatorsip.Model;

import com.google.gson.annotations.SerializedName;

public class PermohonanModel {

	private String kategoriPermohonan;
	private String namaPelapor;
	private String usiaPemohon;
	private String alamatPemohon;
	private String telpPelapor;
	private String alasanPengajuan;
	private String id;
	private String alamatPelapor;
	private String ntelpPemohon;
	private String namaPemohon;
	private String status;
	private String tanggal;

	public PermohonanModel(String kategoriPermohonan, String namaPelapor, String usiaPemohon, String alamatPemohon,
						   String telpPelapor, String alasanPengajuan, String id, String alamatPelapor, String ntelpPemohon,
						   String namaPemohon, String status, String tanggal) {
		this.kategoriPermohonan = kategoriPermohonan;
		this.namaPelapor = namaPelapor;
		this.usiaPemohon = usiaPemohon;
		this.alamatPemohon = alamatPemohon;
		this.telpPelapor = telpPelapor;
		this.alasanPengajuan = alasanPengajuan;
		this.id = id;
		this.alamatPelapor = alamatPelapor;
		this.ntelpPemohon = ntelpPemohon;
		this.namaPemohon = namaPemohon;
		this.status = status;
		this.tanggal = tanggal;
	}

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