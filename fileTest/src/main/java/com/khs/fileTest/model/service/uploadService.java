package com.khs.fileTest.model.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface uploadService {

	String uploadFile1(MultipartFile uploadFile) throws IllegalStateException, IOException;

	
	
	
}
