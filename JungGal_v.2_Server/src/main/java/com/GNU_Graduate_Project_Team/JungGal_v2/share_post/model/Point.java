package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model;

public class Point {
	private String point;
	private String Longitude;
	private String Latitude;
	
	public Point() {
	
	}
	
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	
	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	@Override
	public String toString() {
		return "Point [point=" + point + "]";
	}

}
