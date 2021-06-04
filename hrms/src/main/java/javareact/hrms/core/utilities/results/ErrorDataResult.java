package javareact.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data, String message) {
		super(false,message,data);
	}
	
	public ErrorDataResult(T data, boolean success) {
		super(data,false);
	}
	
	public ErrorDataResult(T data) {
		super(data,false);
	}
	
	public ErrorDataResult(String message) {
		super(false,message,null);
	}
	
	public ErrorDataResult() {
		super(null,false);
	}
}
