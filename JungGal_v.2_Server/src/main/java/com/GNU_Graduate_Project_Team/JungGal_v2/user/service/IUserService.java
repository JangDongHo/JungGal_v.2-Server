package com.GNU_Graduate_Project_Team.JungGal_v2.user.service;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.PhoneVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface IUserService {

	//ȸ�� ���� ���
	void user_regist(UserVO user);
	
	//ȸ������ ��ȸ �� �α��� ���
	UserVO selectOne(UserVO checkuser);
	
	//id �ߺ� Ȯ��
	Integer checkId(String id);
	
	//����� �޴��� ����
	void phone_auth(String phone_number);
	
	//�޴��� ������ȣ Ȯ��
	PhoneVO phone_auth_pass(PhoneVO phone_info);
	
	//�˶� ���� ��ȸ ���
	UserVO selectAlarmCnt(String id);
	
	//request �˶� ���� �ʱ�ȭ ���
	int request_AlarmInit(String id);
	
	//request �˶� ���� update
	void request_update_alarm(String id);
	
	//response �˶� ���� update
	void response_update_alarm(String id);
	
	//response �˶� ���� �ʱ�ȭ
	void response_alarm_init(String id);

	//User Name Select
	UserVO selectUserName(String id);
	
}
