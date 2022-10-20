package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.service;

import java.util.List;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface ISharePostService {

	//���� ���� �Խù� ���ε�
	void share_post_upload(SharePostVO sharepost);
		
	//��Ŀ ���� �޾ƿ���
	List<MarkerVO> getPostList(String point);
	
	//���� ���� �Խù� Select
	SharePostVO getSharePost(MarkerVO marker);
		
	//���� ���� �Խù� �ۼ��� Select
	UserVO getSharePostWiter(UserVO user);
	
	//���� ���� �Խù� ����
	SharePostVO share_post_edit(SharePostVO sharepost);
		
	//���� ���� �Խù� ����
	void deleteSharePost(SharePostVO sharepost);
	
	//���� ���� �Խù� �������� �ο� + 1
	void sharedPeopleUpdate(Integer share_post_id);
	
	//�Խù� ��ǥ Select
	Point selectGeoPoint(Integer share_post_id);
	
}
