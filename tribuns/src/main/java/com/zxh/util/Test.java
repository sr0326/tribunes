package com.zxh.util;


import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		JSONObject check = CheckTextUtil.check("");
		System.out.println(check);
		Object object = check.get("result");
		System.out.println(object);
		JSONObject object1=JSONObject.fromObject(object);
		Object i = object1.get("spam");
		System.out.println("result=====>"+i);
	}
}
