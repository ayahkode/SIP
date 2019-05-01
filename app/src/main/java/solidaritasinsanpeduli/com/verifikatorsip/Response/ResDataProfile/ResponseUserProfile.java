package solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataProfile;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseUserProfile implements Serializable {

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