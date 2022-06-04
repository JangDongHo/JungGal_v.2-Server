package com.GNU_Graduate_Project_Team.JungGal_v2.user.service;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.PhoneVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface IUserService {

	//회원 가입 기능
	void user_regist(UserVO user);
	
	//회원정보 조회 및 로그인 기능
	UserVO selectOne(UserVO checkuser);
	
	//id 중복 확인
	Integer checkId(String id);
	
	//사용자 휴대폰 인증
	void phone_auth(String phone_number);
	
	//휴대폰 인증번호 확인
	PhoneVO phone_auth_pass(PhoneVO phone_info);
	
}
