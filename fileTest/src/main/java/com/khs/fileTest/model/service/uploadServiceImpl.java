package com.khs.fileTest.model.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.khs.fileTest.upDown.model.mapper.upDownMapper;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class uploadServiceImpl implements uploadService{

	private final upDownMapper mapper;
	
	@Override
	public String uploadFile1(MultipartFile uploadFile) throws IllegalStateException, IOException {
		
		if(uploadFile.isEmpty()) {
			return null;
		}
		
		// 업로드한 파일이 있을 경우
		uploadFile.transferTo(new File("C:\\uploadFiles\\test\\" + uploadFile.getOriginalFilename()));
		
		
		// 이미지 화면에 띄우기
		String fileName = uploadFile.getOriginalFilename();
		String tempDir = System.getProperty("C:\\uploadFiles\\temp");
		File tempFile = new File(tempDir, fileName);
		uploadFile.transferTo(tempFile);
		
		String imageUrl = "/uploads/" + fileName;

		// 웹에서 해당 파일에 접근할 수 있는 경로를 반환

		// 서버 : C:\\uploadFiles\\test\\a.jpg
		// 웹 접근 주소 : /mypage/file/a.jpg
		return imageUrl;
	}
	
}
