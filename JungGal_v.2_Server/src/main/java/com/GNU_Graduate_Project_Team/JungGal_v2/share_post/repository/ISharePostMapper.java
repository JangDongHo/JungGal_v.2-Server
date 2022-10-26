package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface ISharePostMapper {

	//���� ���� �Խù� ���ε�
	void share_post_upload(SharePostVO sharepost);
	
	//��Ŀ ���� �޾ƿ���
	List<MarkerVO> getPostList(String point);
	
	//��� �Խù� Select
	List<SharePostVO> getAllSharePost();
	
	//���� ���� �Խù� Select
	SharePostVO getSharePost(Integer share_post_id);
	
	//���� ���� �Խù� �ۼ��� Select
	UserVO getSharePostWiter(UserVO user);
	
	//���� ���� �Խù� ����
	
	//���� ���� �Խù� ����
	void deleteSharePost(Integer share_post_id);
	
	//���� ���� �Խù� �������� �ο� + 1
	void sharedPeopleUpdate(Integer share_post_id);
	
	//�Խù� ��ǥ Select
	Point selectGeoPoint(Integer share_post_id);
	
	//�Խù� �˻� ���
	List<SharePostVO> searchPost(@Param("keyword") String keyword, @Param("point") String point);
	
	
	
}
