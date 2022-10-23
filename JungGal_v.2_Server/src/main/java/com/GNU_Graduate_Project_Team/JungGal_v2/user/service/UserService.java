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

		//����� directory �����
		String user_profile_path = "D:\\JungGal\\JungGal_User_Profile\\" + user.getId();
		String user_share_folder_path = "D:\\JungGal\\JungGal_Share_Post\\" + user.getId();
		File Folder1 = new File(user_profile_path);
		File Folder2 = new File(user_share_folder_path);
		
		try {
			Folder1.mkdir();
			Folder2.mkdir();
			System.out.println("�������� ����");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������� ����");
		}
		
		//����� Profile����
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
			System.out.println("������ ������");			
		}
		
		
		//ȸ�� ��й�ȣ�� ��ȣȭ ���ڵ�
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//��й�ȣ ��ȣȭ�Ͽ� �ٽ� user ��ü�� ����
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
	
	@Override
	public UserVO selectAlarmCnt(String id) {
		
		return mapper.selectOne(id);
	}
	
	@Override
	public int request_AlarmInit(String id) {
		try {
			mapper.request_AlarmInit(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public void request_update_alarm(String id) {
		System.out.println("request_update_alarm ���� ȣ��");
		mapper.request_update_alarm(id);		
	}
	
	@Override
	public void response_update_alarm(String id) {
		System.out.println("response_update_alarm ���� ȣ��");
		mapper.response_update_alarm(id);
	}
	
	@Override
	public void response_alarm_init(String id) {
		System.out.println("response_alarm_init ���� ȣ��");
		mapper.response_alarm_init(id);
		
	}
	
	@Override
	public UserVO selectUserName(String id) {
		System.out.println("selectUserName ���� ȣ��");
		return mapper.selectOne(id);
	}
	
	@Override
	public UserVO selectUserData(String id) {
		System.out.println("selectUserData ���� ȣ��");
		return mapper.selectOne(id);
	}
	
	@Override
	public void user_profile_update(UserVO user) {
		System.out.println("updateUserProfile ���� ȣ��");
		
		MultipartFile user_profile;
		
		//����� Profile����
		if (user.getProfile_change_flag() != null && user.getProfile_change_flag()==true && user.getProfile_flag()==true )
		{
			user_profile = user.getProfile();
			
			String[] arr = user_profile.getContentType().split("/");
			String profile_file_name = user.getId()+"_profile." + arr[1];
			
			try {
				user_profile.transferTo(new File("D:\\JungGal\\JungGal_User_Profile\\"+user.getId()+"\\" +profile_file_name));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		
		}
		
		
		mapper.user_profile_update(user);
		
	}
}
