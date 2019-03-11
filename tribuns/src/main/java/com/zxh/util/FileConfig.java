package com.zxh.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:zxhconfig.properties")
@ConfigurationProperties
public class FileConfig {
	private String imgSavePath;
	private String txtSavePath;
	
	public String getImgSavePath() {
		return imgSavePath;
	}
	public void setImgSavePath(String imgSavePath) {
		this.imgSavePath = imgSavePath;
	}
	public String getTxtSavePath() {
		return txtSavePath;
	}
	public void setTxtSavePath(String txtSavePath) {
		this.txtSavePath = txtSavePath;
	}
	
	
}
