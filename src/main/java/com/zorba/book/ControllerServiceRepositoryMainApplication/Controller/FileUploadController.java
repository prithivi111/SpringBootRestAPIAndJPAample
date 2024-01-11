package com.zorba.book.ControllerServiceRepositoryMainApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zorba.book.ControllerServiceRepositoryMainApplication.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	//Here MultipartFile is a class that handles the file/image coming from the URL
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file){
		
		//Just trying to get the details of the file in my console
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
	
		try {
			//validation pani garna sakchau file ko:
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			
			//file image/jpeg ko validation pani dina sakchau
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEF content type are allowed");
			}
			
			//Mathi ko 2 validation success bhayera yo method ma reach huncha
			//aba UI/Postman bata ayeko image kunai na kunai thau ma upload garna parcha ni haina?
			//So hami static->image ko folder ma post garam
			
			boolean flag = fileUploadHelper.uploadFile(file);  //call the method in the FileUploadHelper Class
				if(flag == true) {
					// return ResponseEntity.ok("File is successfully uploaded");
				//Yo ali lamo cha ra maile bujhina..
				//Yesle postman ko UI ma URL dincha
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some issue is there");
	}

}
