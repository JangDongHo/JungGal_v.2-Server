package com.GNU_Graduate_Project_Team.JungGal_v2.user.service;



import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.MessageService;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.PhoneVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.phonerepository.IUserPhoneAuthMapper;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private IUserPhoneAuthMapper phone_mapper;
	
	@Override
	public void user_regist(UserVO user) {
		
		MultipartFile user_profile;

		//사용자 directory 만들기
		String user_profile_path = "D:\\JungGal\\JungGal_User_Profile\\" + user.getId();
		String user_share_folder_path = "D:\\JungGal\\JungGal_Share_Post\\" + user.getId();
		File Folder1 = new File(user_profile_path);
		File Folder2 = new File(user_share_folder_path);
		
		try {
			Folder1.mkdir();
			Folder2.mkdir();
			System.out.println("폴더생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("폴더생성 실패");
		}
		
		//사용자 Profile저장
		if (user.getProfile_flag() != null)
		{
			user_profile = user.getProfile();
			
			String[] arr = user_profile.getContentType().split("/");
			String profile_file_name = user.getId()+"_profile." + arr[1];
			
			try {
				user_profile.transferTo(new File("D:\\JungGal\\JungGal_User_Profile\\"+user.getId()+"\\" +profile_file_name));
				user.setProfile_flag(true);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		
		}
		else
		{
			user.setProfile_flag(false);
			System.out.println("프로필 미존재");			
		}
		
		
		//회원 비밀번호를 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//비밀번호 암호화하여 다시 user 객체에 저장
		String securePw = encoder.encode(user.getPw());
		user.setPw(securePw);
		
		mapper.user_regist(user);
	}

	
	@Override
	public UserVO selectOne(UserVO checkuser) {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		UserVO user = mapper.selectOne(checkuser.getId().toString());
		UserVO fail_login = new UserVO();
		
		if(user!=null)
		{
			if(encoder.matches(checkuser.getPw(), user.getPw()))
			{
				return user;
			}
			else
			{ 	
				fail_login.setId("null");
				return fail_login;
			}
		}
		else
		{
			fail_login.setId("null");
			return fail_login;
		}
	
	}
	
	@Override
	public Integer checkId(String id) {
		return mapper.checkId(id);
	}
	
	@Override
	public void phone_auth(String phone_number) {
		
		System.out.println("연구실 세미나 : 휴대폰 문자 발송 Service 호출 !!");
		
		MessageService messageService = new MessageService();
		
		Integer auth_num= (int) (Math.random() * 10000);
		String auth_string = auth_num.toString();
		while(auth_string.length()<4)
		{
			auth_num= (int) (Math.random() * 10000);
			auth_string = auth_num.toString();
		}
		
		PhoneVO phone_info = new PhoneVO();
		phone_info.setPhone_number(phone_number);
		phone_info.setAuth_number(auth_string);
		
		phone_mapper.phone_auth(phone_info);
		
		messageService.sendMessage(phone_number, auth_string);
	}
	
	@Override
	public PhoneVO phone_auth_pass(PhoneVO phone_info) {
		
		String user_auth = phone_info.getAuth_number();
		String db_auth = phone_mapper.phone_auth_pass(phone_info);
		
		if(db_auth.equals(user_auth))
		{
			phone_info.setSuccess_flag(true);
		}
		else
		{
			phone_info.setSuccess_flag(false);
		}
		
		return phone_info;
	}
}
