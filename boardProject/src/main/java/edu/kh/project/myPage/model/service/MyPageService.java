package edu.kh.project.myPage.model.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int updateInfo(Member inputMember, String[] memberAddress);

	/** 비번 변경
	 * @param loginMember
	 * @param currentPw
	 * @param newPw
	 * @return
	 */
	int changePw(Member loginMember, String currentPw, String newPw);

	/** 회원 탈퇴
	 * @param loginMember
	 * @param currentPw
	 * @return
	 */
	int secession(Member loginMember, String currentPw);

	String fileUpload1(MultipartFile uploadFile) throws IllegalStateException, IOException ;

}
