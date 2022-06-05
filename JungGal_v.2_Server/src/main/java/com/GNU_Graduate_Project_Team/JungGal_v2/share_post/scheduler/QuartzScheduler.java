package com.GNU_Graduate_Project_Team.JungGal_v2.share_post.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.model.SharePostVO;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.repository.ISharePostMapper;
import com.GNU_Graduate_Project_Team.JungGal_v2.share_post.service.ISharePostService;

@Service("ScheduleJob")
public class QuartzScheduler implements ScheduleService {

	@Autowired
	private ISharePostMapper mapper;
	
	@Autowired
	private ISharePostService service;
	
	private ArrayList<SharePostVO> sharePostList;
	private ArrayList<SharePostVO> passedPost;
	
	@Override
	public void passedTimeDeletePost() {

		System.out.println("delete 로직 schedule 실행");
		
		sharePostList = (ArrayList<SharePostVO>) mapper.getAllSharePost();
		passedPost = new ArrayList<>();
		
		long currentTime = System.currentTimeMillis();
		long shareTime;
		
		for(SharePostVO sharePost : sharePostList)
		{
			shareTime = sharePost.getShare_time().getTime();
			
			if((shareTime - currentTime)<=0)
			{
				passedPost.add(sharePost);
			}
		}
		
		for(SharePostVO sharePost : passedPost)
		{
			service.deleteSharePost(sharePost);
		}
	}

}
