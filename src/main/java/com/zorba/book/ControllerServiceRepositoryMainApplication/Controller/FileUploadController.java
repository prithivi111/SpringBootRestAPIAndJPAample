package com.zorba.book.ControllerServiceRepositoryMainApplication.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(){
		return ResponseEntity.ok("Working");
	}

}
