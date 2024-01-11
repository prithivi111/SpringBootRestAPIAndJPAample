package com.zorba.book.ControllerServiceRepositoryMainApplication.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	public final String UPLOAD_DIR = "C:\\Users\\s011271sur"
			+ "\\eclipse-workspace\\SpringBootRestAPIAndJPA\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean flag = false;
		try {		
			//Read
			InputStream inputStream = multipartFile.getInputStream();
			byte data[] = new byte[inputStream.available()];
			inputStream.read(data);
			
			//write
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			fos.write(data);
			
			fos.flush();
			fos.close();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
