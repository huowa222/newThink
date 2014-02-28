package com.lenovo.newThink.vo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * 安全服务错误信息实体类
 * @author jiang chunzhi
 *
 */
public class ErrorSecurity {
	//TODO: 静态化常见错误，以便提高性能
	
	private static DatatypeFactory dtFactory= null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	//错误码
	private String code;
	
	//可显示的错误信息
	private String message;
	
	//错误详细信息
	private String detail;
	
	//错误源
	private String source;
	
	//错误描述相关URL
	private String url;
	
	//时间信息
	private String timestamp;

	public ErrorSecurity(){}

	public ErrorSecurity(String code){
		this.code = code;
	}
	
	public ErrorSecurity(String code,String message,String url){
		this.code = code;
		this.message = message;
		this.url = url;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/*
	 * 生成实体类本身对象的XML信息并返回
	 */
	public String encodeToXml() {
		//创建文档对象
		Document doc = DocumentHelper.createDocument();
		//设置编码
		doc.setXMLEncoding("UTF-8");
		//设置节点
		Element error = DocumentHelper.createElement("Error");
		doc.setRootElement(error);
		error.addElement("Code").addText(this.code);
		
		if( this.timestamp==null ){
			this.timestamp = newTimestamp(); 
		}
		error.addElement("Timestamp").addText(this.timestamp+"");
		error.addElement("Message").addText(this.message+"");
		error.addElement("Detail").addText(this.detail+"");	
		error.addElement("Source").addText(this.source+"");
		error.addElement("URL").addText(this.url+"");
		String xml = doc.asXML();
		return xml;
	}
	
	private String newTimestamp(){
		if( dtFactory==null ){
			try{
				dtFactory = DatatypeFactory.newInstance();
			}catch( Exception ee){
				//log.debug(ee);
			}
		}
		
		GregorianCalendar gc =new GregorianCalendar();
		return getTimestamp(gc);
	}
	
	private static String getTimestamp(GregorianCalendar gc){
		int offset = gc.getTimeZone().getRawOffset();
		offset = (int)(offset/3600000 );
		String tz=getTZ(offset);
		String ss = sdf.format(gc.getTime());
		return ss + tz;
	}
	
	public static String getTZ(int offset){
		if(offset==0){
			return "Z";
		}
		String tz=null;
		if(offset>0){
			if( offset>9 ){
				tz="+"+offset;
			}else{
				tz="+0"+offset;
			}
		}else{
			if( offset<-9 ){
				tz=""+offset;
			}else{
				tz="-0"+(-1*offset);
			}
		}
		return tz+":00";
	}
	

}





