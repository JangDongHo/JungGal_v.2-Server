package com.GNU_Graduate_Project_Team.JungGal_v2.user.repository;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface IUserMapper {
	
	//회원 가입 기능
	void user_regist(UserVO user);
	
	//회원정보 조회 및 로그인 기능
	UserVO selectOne(String account);
	
	//id 중복 확인
	Integer checkId(String id);
	
	//Apply 알람 갯수 초기화
	void apply_AlarmInit(String id);
	
	//Apply 알람 갯수 update
	void apply_AlarmUpdate(String id);
	
	//request 알람 갯수 초기화
	void request_AlarmInit(String id);
	
	//request 알람 갯수 update
	void request_update_alarm(String id);
	
	//response 알람 갯수 update
	void response_update_alarm(String id);
	
	//response 알람 갯수 초기화
	void response_alarm_init(String id);
		
	//회원 가입 기능
	void user_profile_update(UserVO user);
}
