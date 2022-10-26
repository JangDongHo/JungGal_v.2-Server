package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface ISharePostMapper {

	//반찬 나눔 게시물 업로드
	void share_post_upload(SharePostVO sharepost);
	
	//마커 정보 받아오기
	List<MarkerVO> getPostList(String point);
	
	//모든 게시물 Select
	List<SharePostVO> getAllSharePost();
	
	//반찬 나눔 게시물 Select
	SharePostVO getSharePost(Integer share_post_id);
	
	//반찬 나눔 게시물 작성자 Select
	UserVO getSharePostWiter(UserVO user);
	
	//반찬 나눔 게시물 수정
	
	//반찬 나눔 게시물 삭제
	void deleteSharePost(Integer share_post_id);
	
	//반찬 나눔 게시물 나눔해준 인원 + 1
	void sharedPeopleUpdate(Integer share_post_id);
	
	//게시물 좌표 Select
	Point selectGeoPoint(Integer share_post_id);
	
	//게시물 검색 기능
	List<SharePostVO> searchPost(@Param("keyword") String keyword, @Param("point") String point);
	
	
	
}
