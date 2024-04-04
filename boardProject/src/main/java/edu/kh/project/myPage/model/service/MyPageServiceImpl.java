package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor // final로 작성한거 DI 해주는 어노테이션 (@Autowired 안 써도 되게)
@Slf4j
public class MyPageServiceImpl implements MyPageService{

	// @RequiredArgsConstructor 를 이용했을 때 자동 완성 되는 구문
	//	@Autowired
	//	public MyPageServiceImpl(MyPageMapper mapper) {
	//		this.mapper = mapper;
	//	}
	private final BCryptPasswordEncoder bcrypt;
	private final MyPageMapper mapper;
	
	@Override
	public int updateInfo(Member inputMember, String[] memberAddress) {
		
		// 입력된 주소가 있을 경우 
		// memberAddress를 A^^^B^^^C 형태로 가공
		
		// 주소 입력 X -> inputmember.getMemberAddress() -> ",," 
		if( inputMember.getMemberAddress().equals(",,") ) {
			
			// 주소에 null 대입
			inputMember.setMemberAddress(null); 
		} else { // memberAddress를 A^^^B^^^C 형태로 가공
			
			String address = String.join("^^^", memberAddress);
			
			// 주소에 가공된 데이터 대입
			inputMember.setMemberAddress(address);
			
		}
		
		
		// SQL 수행 후 결과 반환
		return mapper.updateInfo(inputMember);
	}
	
	
	@Override
	public int changePw(Member loginMember, String currentPw, String newPw) {
		
		
		
		String currPw = mapper.currPw(loginMember);
		
		
		
		
		
		
		if (!bcrypt.matches(currentPw, currPw)) { // 현재 비번 틀린 경우
			
			return 0;
		} else { // 현재 비번 맞은 경우
			// 비밀번호를 암호화하여 inputMember에 세팅
			String encPw = bcrypt.encode(newPw);
			
			loginMember.setMemberPw(encPw);
			
			return mapper.changePw(loginMember);
		}
		
		
		
		
		
	}

	@Override
	public int secession(Member loginMember, String currentPw) {

		String currPw = mapper.currPw(loginMember);

		if (!bcrypt.matches(currentPw, currPw)) { // 현재 비번 틀린 경우

			return 0;
		} else { // 현재 비번 맞은 경우
			
			

			

			return mapper.secession(loginMember);
		}
	}
	
	// 파일 업로드 테스트1
	@Override
	public String fileUpload1(MultipartFile uploadFile) throws IllegalStateException, IOException {
		
		// MultipartFile이 제공하는 메서드
		// - getSize() : 파일 크기
		// - isEmpty() : 업로드한 파일이 있을 경우 true
		// - getOriginalFileName() : 원본 파일명
		// - transferTo(경로) : 
		// 	 메모리 또는 임시 저장 경로에 업로드된 파일을 
		// 	 원하는 경로에 전송(서버 어떤 폴더에 저장할지 지정)
		
		if (uploadFile.isEmpty()) { // 업로드한 파일이 없을 경우
			
			return null;
		}
		
		// 업로드한 파일이 있을 경우
		uploadFile.transferTo(
		new File("C:\\uploadFiles\\test\\" + uploadFile.getOriginalFilename()));
		
		// 웹에서 해당 파일에 접근할 수 있는 경로를 반환
		
		// 서버 : C:\\uploadFiles\\test\\a.jpg
		// 웹 접근 주소 : /mypage/file/a.jpg
		return "/myPage/file/" + uploadFile.getOriginalFilename();
	}

}
