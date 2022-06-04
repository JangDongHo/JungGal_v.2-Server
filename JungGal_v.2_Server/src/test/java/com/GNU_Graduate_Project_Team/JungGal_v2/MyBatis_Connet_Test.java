package com.GNU_Graduate_Project_Team.JungGal_v2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class MyBatis_Connet_Test {

	@Autowired
	private IUserMapper mapper;
	
	//mapper get test
	@Test
	public void getMapper()
	{
		
	}
	
	//회원등록 test
	@Test
	public void registTest()
	{
		UserVO user = new UserVO();
		user.setId("rhdwhddnr");
		user.setPw("1377");
		user.setName("Gong");
		user.setPhone_number("010-1111-1111");
		user.setIntroduce("hello");
		user.setShare_point(4.1);
		user.setSeller_auth(false);
		mapper.user_regist(user);
		System.out.println("회원 가입 성공");
		
	}
	
}
