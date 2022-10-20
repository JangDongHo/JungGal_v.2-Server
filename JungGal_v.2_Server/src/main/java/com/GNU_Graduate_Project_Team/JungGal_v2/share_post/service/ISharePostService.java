package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.service;

import java.util.List;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface ISharePostService {

	//반찬 나눔 게시물 업로드
	void share_post_upload(SharePostVO sharepost);
		
	//마커 정보 받아오기
	List<MarkerVO> getPostList(String point);
	
	//반찬 나눔 게시물 Select
	SharePostVO getSharePost(MarkerVO marker);
		
	//반찬 나눔 게시물 작성자 Select
	UserVO getSharePostWiter(UserVO user);
	
	//반찬 나눔 게시물 수정
	SharePostVO share_post_edit(SharePostVO sharepost);
		
	//반찬 나눔 게시물 삭제
	void deleteSharePost(SharePostVO sharepost);
	
	//반찬 나눔 게시물 나눔해준 인원 + 1
	void sharedPeopleUpdate(Integer share_post_id);
	
	//게시물 좌표 Select
	Point selectGeoPoint(Integer share_post_id);
	
}
