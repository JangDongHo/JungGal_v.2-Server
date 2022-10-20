package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.MarkerVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.Point;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostImageVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.service.ISharePostService;
import com.GNU_Graduate_Project_Team.JungGal_v2.user.model.UserVO;

@RestController
@RequestMapping("share_post/")
public class SharePostController {

	@Autowired
	private ISharePostService service;
	
	/** 나눔 게시물 업로드 **/
	@PostMapping("/upload")
	public SharePostVO share_post_upload(SharePostVO post)
	{
		
		SharePostVO returnVO = new SharePostVO();
		
		System.out.println("/share_post/upload POST 요청 발생!");
		System.out.println("param : " + post.getShare_post_name());
		
		try {
			service.share_post_upload(post);
			returnVO.setShare_post_id(post.getShare_post_id());
			System.out.println(post.getShare_post_id());
		} catch (Exception e) {
			
		}
		
		return returnVO;
		
	}
	
	/** 나눔 게시물 마커 리스트 send **/
	@PostMapping("/marklist")
	public List<MarkerVO> sharePostMarker(@RequestBody Point point)
	{
		System.out.println("/share_post/sharePostMarker POST 요청 발생!");
		System.out.println("param : " + point);
		
		return service.getPostList(point.getPoint());
	}
	
	/** 나눔 게시물 내용 Select **/
	@PostMapping("/selectPost")
	public SharePostVO sharePostSelect(@RequestBody MarkerVO marker)
	{
		System.out.println("/share_post/sharePostSelect POST 요청 발생!");
		System.out.println("param : " + marker.getShare_post_id().toString());
		SharePostVO tmp = new SharePostVO();
		try {
			tmp = service.getSharePost(marker);
			tmp.setShare_post_point(null);
			System.out.println(tmp);
		} catch (Exception e) {
			tmp = new SharePostVO();
			tmp.setShare_post_id(null);
		}	

		return tmp;
	}
	
	/** 나눔 게시물 이미지 출력 **/
	@PostMapping("/display")
	public SharePostImageVO getFile(@RequestBody SharePostVO post) throws IOException
	{
		SharePostImageVO imageVO = new SharePostImageVO();
		
		System.out.println("/share_post/display ["+post.getShare_post_id() +"번] 요청 발생!");
		String fileurl = "D:\\JungGal\\JungGal_Share_Post\\"+post.getUser_id()+"\\"+post.getShare_post_id()+"_"+post.getShare_post_name()+"-"+post.getImgNumber()+".jpeg";
		
		File file = new File(fileurl);
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[(int)file.length()];
		fileInputStream.read(bytes);
		imageVO.setImagedata(new String(Base64.encodeBase64(bytes), "UTF-8"));
		
		/* 웹으로 이미지 뿌릴 때 코드
		 
		HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_JPEG);
		
		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(IOUtils.toByteArray(new FileInputStream(new File(fileurl))), header, HttpStatus.CREATED);
		
		 */
		
		return imageVO;
		
	}
	
	/** 게시물 작성자 정보 Select **/
	@PostMapping("/selectUser")
	public UserVO selectUse(@RequestBody UserVO user)
	{
		System.out.println("/share_post/selectUser POST 요청 발생!");
		return service.getSharePostWiter(user);
		
	}
	
	/** 나눔 게시물 삭제 로직 **/
	@PostMapping("deletePost")
	public SharePostVO deletPost(@RequestBody SharePostVO sharepost)
	{
		System.out.println("/share_post/deletePost POST 요청 발생!");
		
		
		service.deleteSharePost(sharepost);
		
		return sharepost;
	}
	
	/** 게시물 좌표 Select **/
	@PostMapping("selectGeoPoint")
	public Point selectGeoPoint(@RequestBody SharePostVO sharepost)
	{
		System.out.println("/share_post/selectGeoPoint POST 요청 발생!");

		return service.selectGeoPoint(sharepost.getShare_post_id());
	}
	
}
