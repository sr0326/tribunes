package com.zxh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zxh.util.FileConfig;
import com.zxh.util.FileUtils;

@Controller
@RequestMapping("file")
public class FileUploadController {
	@Resource
	private FileConfig config;
	@RequestMapping("fileupload")
	@ResponseBody
	public Map<String,Object>  imageupload(@RequestParam(value = "editormd-image-file", required = true)MultipartFile file){
		String path = config.getImgSavePath();
		File files=new File(path);
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			String upload = FileUtils.upload(file,files);
			map.put("url", "img/"+upload);
			map.put("message", "");
			map.put("success",1 );
			return map;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("url", "");
			map.put("message", "");
			map.put("success",0);
			return map;
		}
		
	}
}
