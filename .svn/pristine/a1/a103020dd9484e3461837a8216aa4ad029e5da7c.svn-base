package com.lenovo.newThink.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Properties {

	private static Map<String,String> config=new HashMap<String, String>();

	static{
		init_config();
		
		//by hrk 2010-9-7
		new Thread(){
			public void run(){
				while(true){
					try{						
						Thread.currentThread().sleep(600000L);//10 minutes ---test 20s
					}catch(Exception e){
						e.printStackTrace();
					}
					init_config();
					
					Config.load();
				}
			}
		}.start();
	}
	
	private static void init_config(){
		java.util.Properties props=new java.util.Properties();
		try{
			InputStream ins=Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			if (ins!=null){
				props.load(ins);
				ins.close();
				for (Entry<Object, Object> ent:props.entrySet()){
					config.put((String)ent.getKey(), (String)ent.getValue());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static String get(String key){
		
		return config.get(key);
	}
}
