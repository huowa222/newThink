package com.lenovo.newThink.controller;

import javax.servlet.http.HttpServletResponse;
import com.lenovo.lps.log.Log;
import com.lenovo.newThink.vo.ErrorSecurity;

public abstract class NewThinkController{
	
	protected Log log = Log.getInstance(this.getClass() );
	
	public void sendError(String errCode,int httpCode,HttpServletResponse response ) {
		if(errCode!=null && errCode.length()>0 ){
			sendError(  response,httpCode,new ErrorSecurity(errCode) );
		}else{
			sendError(  response,httpCode,null );
		}
	}
	
	public void sendError(HttpServletResponse response,int httpCode,ErrorSecurity err ) {
		response.reset();
		
		response.setStatus( httpCode );
		
		// 输出XML格式错误信息
		if(err != null ){
			try{
				response.setContentType("text/xml; charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().write( err.encodeToXml() );
			}catch(Exception ee ){
				log.error(ee);
			}
			
		}else{
			// 设置输出信息的格式及字符集
			response.setContentType("text/plain; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
		}
	}
}
