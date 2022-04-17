package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {	// 원하는 beans properties를 찾아오는 역할을 수행한다.
	//﻿HandlerMapping : 사용자의 요청에 의해 알맞은 Controller를 찾아서 맵핑(mapping?: 하나의 값을 다른 값으로 대응 시키는 것.)﻿
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping(String propLoc) {
		
		Properties prop = new Properties();
		mappings = new HashMap<>();
		
		try {
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
	
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {

				String className = prop.getProperty(key.toString());
				System.out.println(key + " : " + className);
				
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Controller getController(String uri) {
		return mappings.get(uri);
	}

}