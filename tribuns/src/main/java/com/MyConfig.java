package com;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zxh.util.FileConfig;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
	@Resource
	FileConfig config;
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+config.getImgSavePath());
        registry.addResourceHandler("/txt/**").addResourceLocations("file:"+config.getTxtSavePath());
        super.addResourceHandlers(registry);
    }
}