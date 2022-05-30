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
			//InputStream is = new FileInputStream("D:\\Lecture\\web-workspace\\Mission-Web-MVC\\bean.properties");
			InputStream is = new FileInputStream(propLoc);
			//inputStream은 데이터를 읽어와
			// FileInputStream파일을 읽어올 때 사용한다.
			prop.load(is);
	
			Set<Object> keys = prop.keySet();	//keySet: key의 값만 출력
			for(Object key : keys) {
				//향상된 for문을 이용해서 하나씩 출력시킴.
				//key값은 Oject라 문자열로 만들어 줘야 한다. 
				String className = prop.getProperty(key.toString());
				System.out.println(key + " : " + className);
				
				Class<?> clz = Class.forName(className);
				//클래스의 정보를 얻기위한 클래스 
				//forName():물리적인 클래스 파일명을 인자로 넣어주면 이에 해당하는 클래스를 반환해줍니다.
				mappings.put(key.toString(), (Controller)clz.newInstance());
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
/*	
	public static void main(String[] args) throws Exception {
		
		
//		java.util.Random r = new java.util.Random();
//		int random = r.nextInt(100);
//		System.out.println("추출된 난수 : " + random);
		
		
		
//		Class<?> clz = Class.forName("java.util.Random");
//		java.util.Random obj = (java.util.Random)clz.newInstance();
//		int random = obj.nextInt(100);
//		System.out.println("추출된 난수 : " + random);
		
		
		// BoardListController obj = new BoardListController();
		Class<?> clz = Class.forName("kr.co.mlec.controller.BoardListController");
		BoardListController obj = (BoardListController)clz.newInstance();
		System.out.println(obj.handleRequest(null, null));
	}
*/
}