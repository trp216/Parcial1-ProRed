package model;

public class Status {
	
	private String type = "Status";
	
	private String msg;
	
	public Status() {}

	public Status(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
