package com.zxh.util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.zxh.entity.UserInfo;

public class ShiroMD5Util {
    //添加user的密码加密方法
    public static String  SysMd5(UserInfo xxx) {
        String hashAlgorithmName = "MD5";//加密方式  
        
        Object crdentials =xxx.getUsepwd();//密码原值  
        
        //ByteSource salt = ByteSource.Util.bytes(xxx.getPhone());//以电话作为盐值  
        
        int hashIterations = 1000;//加密1024次  
        
        SimpleHash hash = new SimpleHash(hashAlgorithmName,crdentials,null,hashIterations);
        
        return hash.toString();
    }  
}