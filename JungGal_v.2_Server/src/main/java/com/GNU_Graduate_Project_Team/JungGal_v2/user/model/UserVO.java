package com.GNU_Graduate_Project_Team.JungGal_v2.user.model;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {

	/*
	 -- ����� ���̺� ����
	 	CREATE TABLE USER(
			id varchar(20) primary key,
		    pw varchar(20) not null,
		    name varchar(30) not null,
		    phone_number varchar(50) not null,
		    profile longblob ,
		    introduce varchar(120),
		    share_point float,
		    seller_auth boolean default false
		);
	 
	 */
	
	private String id;
	private String pw;
	private String name;
	private String phone_number;
	private String introduce;
	private Double share_point;
	private Boolean seller_auth;
	private Boolean profile_flag;
	private MultipartFile profile;
	private int responseAlarmCnt;
	private int requestAlarmCnt;
	
	
	// SharePost���� �ۼ��� �̹��� ������ ��� ( BASE 64 ���� ��� )
	String imagedata;
	
	public UserVO() {
	
	}
	
	public UserVO(String id)
	{
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Double getShare_point() {
		return share_point;
	}
	public void setShare_point(Double share_point) {
		this.share_point = share_point;
	}
	public Boolean getSeller_auth() {
		return seller_auth;
	}
	public void setSeller_auth(Boolean seller_auth) {
		this.seller_auth = seller_auth;
	}
		public Boolean getProfile_flag() {
		return profile_flag;
	}

	public void setProfile_flag(Boolean profile_flag) {
		this.profile_flag = profile_flag;
	}
	public MultipartFile getProfile() {
		return profile;
	}
	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	public String getImagedata() {
		return imagedata;
	}

	public void setImagedata(String imagedata) {
		this.imagedata = imagedata;
	}

	public int getResponseAlarmCnt() {
		return responseAlarmCnt;
	}

	public void setResponseAlarmCnt(int responseAlarmCnt) {
		this.responseAlarmCnt = responseAlarmCnt;
	}

	public int getRequestAlarmCnt() {
		return requestAlarmCnt;
	}

	public void setRequestAlarmCnt(int requestAlarmCnt) {
		this.requestAlarmCnt = requestAlarmCnt;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone_number=" + phone_number + ", introduce="
				+ introduce + ", share_point=" + share_point + ", seller_auth=" + seller_auth + ", profile_flag="
				+ profile_flag + ", profile=" + profile + "]";
	}
	
	
	
	
					
}
