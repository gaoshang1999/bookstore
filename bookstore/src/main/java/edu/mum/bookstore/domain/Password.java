package edu.mum.bookstore.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Password {

	@NotEmpty
	private String old_password;
	
	@NotEmpty
	private String new_password;
	
	@NotEmpty
	private String confirm_password;
	
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	public boolean isMath() {
		return new_password.equals(confirm_password);
	}
	
}
