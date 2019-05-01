package solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataProfile;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultItem implements Serializable {

	@SerializedName("password")
	private String password;

	@SerializedName("id_kota")
	private String idKota;

	@SerializedName("kota")
	private String kota;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_hak_akses")
	private String idHakAkses;

	@SerializedName("hak_akses")
	private String hakAkses;

	@SerializedName("id")
	private String id;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setKota(String kota){
		this.kota = kota;
	}

	public String getKota(){
		return kota;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setHakAkses(String hakAkses){
		this.hakAkses = hakAkses;
	}

	public String getHakAkses(){
		return hakAkses;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}