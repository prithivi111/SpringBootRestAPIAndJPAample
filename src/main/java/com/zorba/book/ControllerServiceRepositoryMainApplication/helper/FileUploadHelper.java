package com.zorba.book.ControllerServiceRepositoryMainApplication.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//public final String UPLOAD_DIR = "C:\\Users\\s011271sur"
	//		+ "\\eclipse-workspace\\SpringBootRestAPIAndJPA\\src\\main\\resources\\static\\image";
	
	//Instead of mentioning the path as static, we can have the classpath defined in a dynamic way, and there is class 
	//named "ClassPathResource", which helps in making the resource object.
	
	//public final String UPLOAD_DIR = new ClassPathResource("static/image/");
		//mathi ko ClassPathResource("static/image/") le 'Image' folder samma ko path dincha ra tesma .getFile().getAbsolutePath()
	    //add garyo bhane tyo bhitra ko file pani dincha. So, lets write in this way!
	
	public final String UPLOAD_DIR= new ClassPathResource("/static/image").getFile().getAbsolutePath();
	
	//Mathi ko line le IO exception dine bhayekole hamile tyo exception lai handle garna parcha ra tesko lagi
	//euta the default constructor banaunu parcha.
	
	public FileUploadHelper() throws IOException{
		
	}
	 
	
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
