package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.maven.shared.utils.io.IOUtil;
import org.apache.struts.mock.MockMultipartRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.repository.ISharePostMapper;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

import edu.emory.mathcs.backport.java.util.Collections;


@Service
public class SharePostService implements ISharePostService {

	@Autowired
	private ISharePostMapper mapper;
	
	
	/** ���� �Խù� ���ε� **/
	@Override
	public void share_post_upload(SharePostVO sharepost) {
		
		/** �̹��� �޾ƿ��� **/
		ArrayList<MultipartFile> share_img;
		share_img = sharepost.getFiles();
		
		/** TimeStamp �����ϱ� **/
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		cal.add(Calendar.HOUR, sharepost.getShare_time_int());
		timestamp = new Timestamp(cal.getTime().getTime());
		sharepost.setShare_time(timestamp);
		
		
		
		/** ��ǥ Point ���ڿ�ȭ **/
		String share_point = "point(" + sharepost.getShare_post_point() + ")";
		sharepost.setShare_post_point(share_point);
		
		mapper.share_post_upload(sharepost);
		
		/** ���� �Խù� post id **/
		Integer post_id = sharepost.getShare_post_id();
		
		
		/** �̹��� ���� ���� ���� **/
		int count=1;
		
		for(MultipartFile f:share_img)
		{
			
			String share_post_file_name = post_id+"_"+sharepost.getShare_post_name() +"-" + count+ ".jpeg";
			
			try {
				f.transferTo(new File("D:\\JungGal\\JungGal_Share_Post\\"+sharepost.getUser_id()+"\\" + share_post_file_name));
			} catch (Exception e) {
				 e.printStackTrace();
			}
			
			count ++;
		}
		
	}

	
	@Override
	public List<MarkerVO> getPostList(String point) {
		
		String share_point = "point(" + point + ")";
		
		return mapper.getPostList(share_point);
	}

	/** ���� �Խù� Select **/
	@Override
	public SharePostVO getSharePost(MarkerVO marker) {
		
		System.out.println("���� �Խù� Select ���� ��û");
		return mapper.getSharePost(marker.getShare_post_id());
	}
	
	/** ���� ���� �Խù� �ۼ��� Select **/
	@Override
	public UserVO getSharePostWiter(UserVO user) {
		
		UserVO tmp = mapper.getSharePostWiter(user);
		
		if(tmp.getProfile_flag()==true)
		{		
			String userImgfileurl="D:\\JungGal\\JungGal_User_Profile\\"+tmp.getId()+"\\"+tmp.getId()+"_profile.jpg";
			
			File file = new File(userImgfileurl);
			FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(file);
				byte[] bytes = new byte[(int)file.length()];
				fileInputStream.read(bytes);
				tmp.setImagedata(new String(Base64.encodeBase64(bytes), "UTF-8"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return tmp;
	}
	
	/** ���� �Խù� ���� **/
	@Override
	public SharePostVO share_post_edit(SharePostVO sharepost) {

		return null;
	}
	
	//���� ���� �Խù� ����
	@Override
	public void deleteSharePost(SharePostVO share_post) {
		
		mapper.deleteSharePost(share_post.getShare_post_id());
		
		
		for(int i = 1; i<=share_post.getShare_post_img_cnt(); i++)
		{
			String fileurl="D:\\JungGal\\JungGal_Share_Post\\"+share_post.getUser_id()+"\\"+share_post.getShare_post_id()+"_"+share_post.getShare_post_name()+"-";
			fileurl+=i+".jpeg";
			File file = new File(fileurl);
			
			System.out.println(fileurl);
			
			
			if( file.exists() ){
	    		
				for(int j=0; j<100; j++)
				{
					if(file.delete()){
		    			System.out.println("���ϻ��� ����");
		    			break;
		    		}else{
		    			System.out.println("���ϻ��� ����");
		    			try {
		                    Thread.sleep(1000);
		                } catch(InterruptedException e) {
		                    e.printStackTrace();
		                }
		    		}
				}
				
	    	}else{
	    		System.out.println("������ �������� �ʽ��ϴ�.");
	    	}
		}

	}
	
	@Override
	public void sharedPeopleUpdate(Integer share_post_id) {
		System.out.println("share_post ���� �ο� + 1 ���� ȣ��");
		mapper.sharedPeopleUpdate(share_post_id);
	}
	
	@Override
	public Point selectGeoPoint(Integer share_post_id) {
		System.out.println("selectGeoPoint ���� ȣ��");
		return mapper.selectGeoPoint(share_post_id);
	}
	
	@Override
	public List<SharePostVO> searchPost(SharePostVO sharePost, Point point) {
		System.out.println("searchPost ���� ȣ��");
		String share_point = "point(" + point.getLongitude()+" "+point.getLatitude()+ ")";
		String keyword = "%"+sharePost.getKeyword()+"%";
		
		return mapper.searchPost(keyword, share_point);
	}

}
