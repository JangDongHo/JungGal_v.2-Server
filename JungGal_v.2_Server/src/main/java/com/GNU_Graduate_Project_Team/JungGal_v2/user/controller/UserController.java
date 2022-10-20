package com.GNU_Graduate_Project_Team.JungGal_v2.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.GNU_Graduate_Project_Team.JungGal_v2.FCM.model.AlarmVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.PhoneVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	/*
	 ***** Json 형식으로 통신 *****
	 *
	 *
	@PostMapping("/register")
	public UserVO register( UserVO user)
	{
		Integer flag = 0;
		
		System.out.println("/user/ POST 요청 발생!");
		System.out.println("param : " + user);
		
		
		flag = service.checkId(user.getId());
		
		if(flag==0)
		{
			service.user_regist(user);
		}
		else
		{
			user.setId("null");
		}
		
		
		return user;
		
	}
	 */
	
	
	// multipart/form-data 형식으로 통신
	@PostMapping("/register")
	public UserVO register( UserVO user)
	{
		Integer flag = 0;
		
		System.out.println("/user/register POST 요청 발생!");
		System.out.println("param : " + user);
		
		//가입된 ID인지 Checking 
		flag = service.checkId(user.getId());
		
		
		if(flag==0)
		{
			service.user_regist(user);
		}
		else
		{
			user.setId("null");
		}
				
		return new UserVO(user.getId());
		
	}
	
	@PostMapping("/login")
	public UserVO login(@RequestBody UserVO checkuser)
	{
		System.out.println("/user/lgoinCheck 요청! : POST");
		System.out.println("Parameter : " + checkuser);
		
		UserVO user = service.selectOne(checkuser);
		
		return user;
		
	}
	
	@PostMapping("/auth")
	public PhoneVO phone_auth(@RequestBody PhoneVO phone_info)
	{
		
		System.out.println("/user/phone_auth 요청! : POST");
		System.out.println("Parameter : " + phone_info.getPhone_number());
		
		service.phone_auth(phone_info.getPhone_number());
		
		return phone_info;
	}
	
	@PostMapping("/authPass")
	public PhoneVO phone_auth_pass(@RequestBody PhoneVO phone_info)
	{
		System.out.println("/user/phone_auth_pass 요청! : POST");
		System.out.println("Parameter : " + phone_info.getAuth_number());
		
		return service.phone_auth_pass(phone_info);
		
	}
	
	//알람 갯수 조회
	@PostMapping("/alarmCntSelect")
	public UserVO selectAlarm(@RequestBody UserVO user)
	{
		System.out.println("/user/alarmCntSelect 요청! : POST");
		
		return service.selectAlarmCnt(user.getId());
		
	}
	
	//request 알람 갯수 초기화
	@PostMapping("/requestAlarmInit")
	public UserVO initAlarm(@RequestBody UserVO user)
	{
		System.out.println("/user/initAlarm 요청! : POST");
		service.request_AlarmInit(user.getId());

		return user;
	}
	
	//response 알람 갯수 초기화
	@PostMapping("/responseAlarmInit")
	public UserVO responseAlarmInit(@RequestBody UserVO user)
	{
		System.out.println("/user/responseAlarmInit 요청! : POST");
		service.response_alarm_init(user.getId());

		return user;
	}
	
	
}
