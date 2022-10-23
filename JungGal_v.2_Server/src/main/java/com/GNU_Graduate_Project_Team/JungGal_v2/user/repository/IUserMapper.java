package com.GNU_Graduate_Project_Team.JungGal_v2.user.repository;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface IUserMapper {
	
	//ȸ�� ���� ���
	void user_regist(UserVO user);
	
	//ȸ������ ��ȸ �� �α��� ���
	UserVO selectOne(String account);
	
	//id �ߺ� Ȯ��
	Integer checkId(String id);
	
	//Apply �˶� ���� �ʱ�ȭ
	void apply_AlarmInit(String id);
	
	//Apply �˶� ���� update
	void apply_AlarmUpdate(String id);
	
	//request �˶� ���� �ʱ�ȭ
	void request_AlarmInit(String id);
	
	//request �˶� ���� update
	void request_update_alarm(String id);
	
	//response �˶� ���� update
	void response_update_alarm(String id);
	
	//response �˶� ���� �ʱ�ȭ
	void response_alarm_init(String id);
		
	//ȸ�� ���� ���
	void user_profile_update(UserVO user);
}
