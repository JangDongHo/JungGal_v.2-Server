package com.GNU_Graduate_Project_Team.JungGal_v2.user.repository;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

public interface IUserMapper {
	
	//회원 가입 기능
	void user_regist(UserVO user);
	
	//회원정보 조회 및 로그인 기능
	UserVO selectOne(String account);
	
	//id 중복 확인
	Integer checkId(String id);
}
