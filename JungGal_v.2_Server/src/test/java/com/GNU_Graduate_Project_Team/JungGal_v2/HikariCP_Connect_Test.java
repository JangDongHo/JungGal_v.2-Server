package com.GNU_Graduate_Project_Team.JungGal_v2;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class HikariCP_Connect_Test {

	@Autowired
	private HikariDataSource ds;
		
	@Test
	public void test()
	{
		ds.toString();
		try {
			Connection conn = ds.getConnection();
			System.out.println(conn.toString());
			System.out.println("connect 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	
	public void connectTest()
	{
		Connection conn = null;
		
		try {
			
			conn = ds.getConnection();
			System.out.println("DB 커넥션 성공");
			System.out.println("conn : " + conn);
			
		} catch (Exception e) {
			System.out.println("실패1");
			e.printStackTrace();
		}finally
		{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	 */
}
