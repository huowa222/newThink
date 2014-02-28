package com.lenovo.newThink.util;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lenovo.newThink.util.UploadFileUtil;
import com.lenovo.newThink.config.Config;
import java.util.concurrent.atomic.AtomicLong;

public class UploadFileUtil {
	
	private static AtomicLong unm = new AtomicLong();
	
	public static String saveUploadFile(HttpServletRequest request,
			String fileName) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile picfile = multipartRequest.getFile(fileName);
        String picUrl =null;
		if (picfile != null && !picfile.isEmpty()) {
			try {
				byte[] img = picfile.getBytes();
				String name = picfile.getOriginalFilename();
				String filePath = getImagePath(name);
				picUrl = UploadFileUtil.saveFile(img, filePath);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return picUrl.replaceAll(Config.IMGUPLOADDIR, "");//要相对地址
	}

	public static String saveFile(byte[] file, String savePath)
			throws IOException {
		
		if (file != null) {
			File fl = new File(savePath);
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(fl)));
			out.write(file);
			out.flush();
			out.close();
		}
		return savePath;
	}

	public static String getImagePath(String filename) {
		
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());
		
		StringBuffer sb = new StringBuffer();
		sb.append(Config.IMGUPLOADDIR);
		sb.append(now.substring(0, 4)).append("&");
		sb.append(now.substring(5, 7)).append("&");
		sb.append(now.substring(8, 10)).append("&");
		sb.append(Long.toHexString(unm.incrementAndGet()) + "-" + Long.toHexString(System.currentTimeMillis())+"-");	
		sb.append(filename);
		return sb.toString();
	}
}
