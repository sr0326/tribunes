package com.zxh.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.BlogDao;
import com.zxh.entity.Blog;
import com.zxh.util.FileConfig;
import com.zxh.util.FileUtils;
import com.zxh.util.RandomUtil;

@Service
public class BlogService {
	@Autowired
	BlogDao blogdao;
	
	public Integer addBlog(String savepath,Blog blog){
		String  id = RandomUtil.generateNumber(8);
		String filename=id+"_"+blog.getUserId();
		String pushfile = FileUtils.createFile(savepath,filename, blog.getBlogContent());
		blog.setBlogContent(pushfile);
		System.out.println(id);
		blog.setBlogId(Integer.parseInt(id));
		System.out.println(blog);
		return blogdao.addBlog(blog);
	}
}
