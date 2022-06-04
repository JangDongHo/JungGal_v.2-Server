package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model;

public class MarkerVO {

	private Integer share_post_id;
	private Integer share_post_icon;
	private String share_post_name;
	private String Latitude;
	private String Longitude;
	
	public MarkerVO() {
	
	}

	public Integer getShare_post_id() {
		return share_post_id;
	}

	public void setShare_post_id(Integer share_post_id) {
		this.share_post_id = share_post_id;
	}
	
	public Integer getShare_post_icon() {
		return share_post_icon;
	}

	public void setShare_post_icon(Integer share_post_icon) {
		this.share_post_icon = share_post_icon;
	}

	public String getShare_post_name() {
		return share_post_name;
	}

	public void setShare_post_name(String share_post_name) {
		this.share_post_name = share_post_name;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	
	
}
