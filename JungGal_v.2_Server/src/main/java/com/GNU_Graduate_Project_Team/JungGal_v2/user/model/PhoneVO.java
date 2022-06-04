package com.GNU_Graduate_Project_Team.JungGal_v2.user.model;

public class PhoneVO {

	private String phone_number;
	private String auth_number;
	private Boolean success_flag;

	public PhoneVO() {
	
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAuth_number() {
		return auth_number;
	}

	public void setAuth_number(String auth_number) {
		this.auth_number = auth_number;
	}

	public Boolean getSuccess_flag() {
		return success_flag;
	}

	public void setSuccess_flag(Boolean success_flag) {
		this.success_flag = success_flag;
	}
	
}
