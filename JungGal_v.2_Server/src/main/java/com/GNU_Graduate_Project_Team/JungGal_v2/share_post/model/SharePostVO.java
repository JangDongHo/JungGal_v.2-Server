package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SharePostVO {

	private Integer share_post_id;
	private String user_id;
	private String share_post_name;
	private Integer share_post_img_cnt;
	private String share_post_region;
	private String share_post_point;
	private Integer share_post_icon;
	private Integer share_people;
	private String share_story;
	private Integer shared_people;
	private Double latitude;
	private Double longitude;
	private String keyword;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="Asia/Seoul") 
	private Timestamp share_time;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp post_time;
	
	// 시간 계산 편리를 위해
	private Integer share_time_int;
		
	//반찬 나눔 이미지
	private ArrayList<MultipartFile> files;
	
	//파일 번호를 받기위함
	private Integer imgNumber;
	
	//검색 기능을 위함 좌표
	private Point point;
	
	
	//return을 위해 생성자 생성
	public SharePostVO() {
 
	}
	
	public SharePostVO(Integer share_post_id) {
		super();
		this.share_post_id = share_post_id;
	}

	
	public Integer getShare_post_id() {
		return share_post_id;
	}

	public void setShare_post_id(Integer share_post_id) {
		this.share_post_id = share_post_id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public ArrayList<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<MultipartFile> files) {
		this.files = files;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getShare_post_name() {
		return share_post_name;
	}
	public void setShare_post_name(String share_post_name) {
		this.share_post_name = share_post_name;
	}
	public Integer getShare_post_img_cnt() {
		return share_post_img_cnt;
	}
	public void setShare_post_img_cnt(Integer share_post_img_cnt) {
		this.share_post_img_cnt = share_post_img_cnt;
	}
	public String getShare_post_region() {
		return share_post_region;
	}
	public void setShare_post_region(String share_post_region) {
		this.share_post_region = share_post_region;
	}
	public String getShare_post_point() {
		return share_post_point;
	}
	public void setShare_post_point(String share_post_point) {
		this.share_post_point = share_post_point;
	}
	public Integer getShare_post_icon() {
		return share_post_icon;
	}
	public void setShare_post_icon(Integer share_post_icon) {
		this.share_post_icon = share_post_icon;
	}
	public Integer getShare_people() {
		return share_people;
	}
	public void setShare_people(Integer share_people) {
		this.share_people = share_people;
	}
	public Timestamp getShare_time() {
		return share_time;
	}
	public void setShare_time(Timestamp share_time) {
		this.share_time = share_time;
	}
	public String getShare_story() {
		return share_story;
	}
	public void setShare_story(String share_story) {
		this.share_story = share_story;
	}
	public Timestamp getPost_time() {
		return post_time;
	}
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	public Integer getShared_people() {
		return shared_people;
	}
	public void setShared_people(Integer shared_people) {
		this.shared_people = shared_people;
	}
	public Integer getShare_time_int() {
		return share_time_int;
	}
	public void setShare_time_int(Integer share_time_int) {
		this.share_time_int = share_time_int;
	}
	public Integer getImgNumber() {
		return imgNumber;
	}

	public void setImgNumber(Integer imgNumber) {
		this.imgNumber = imgNumber;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "SharePostVO [share_post_id=" + share_post_id + ", user_id=" + user_id + ", share_post_name="
				+ share_post_name + ", share_post_img_cnt=" + share_post_img_cnt + ", share_post_region="
				+ share_post_region + ", share_post_point=" + share_post_point + ", share_post_icon=" + share_post_icon
				+ ", share_people=" + share_people + ", share_time=" + share_time + ", share_story=" + share_story
				+ ", post_time=" + post_time + ", shared_people=" + shared_people + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", share_time_int=" + share_time_int + ", files=" + files + "]";
	}


	
	
	
}
