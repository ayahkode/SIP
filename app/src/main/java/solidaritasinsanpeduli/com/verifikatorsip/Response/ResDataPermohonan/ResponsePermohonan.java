package solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataPermohonan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponsePermohonan{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("error")
	private boolean error;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}
}