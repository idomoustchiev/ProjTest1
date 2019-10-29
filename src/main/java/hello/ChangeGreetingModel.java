package hello;

import java.util.Date;

public class ChangeGreetingModel {
	private Date date;
	private String statement;
	 
	public Date getDate() {
		return date;
	}
	public String getStatement() {
		return statement;
	}
	
	@Override
	public String toString() {
		return "ChangeGreetingModel [date=" + date + ", statement=" + statement + "]";
	}
}
