package javareact.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(true,message,data);
	}
	
	public SuccessDataResult(T data, boolean success) {
		super(data,true);
	}
	
	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	public SuccessDataResult(String message) {
		super(true,message,null);
	}
	
	public SuccessDataResult() {
		super(null,true);
	}
	
	



	

	

	

}
