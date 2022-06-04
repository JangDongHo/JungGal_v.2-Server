package com.GNU_Graduate_Project_Team.JungGal_v2.user.phonerepository;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.PhoneVO;

public interface IUserPhoneAuthMapper {

	//휴대폰 인증 번호 TMP 저장
	void phone_auth(PhoneVO phone_info);

	//휴대폰 인증번호 select
	String phone_auth_pass(PhoneVO phone_info);
	
}
