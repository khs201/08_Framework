package edu.kh.project.myPage.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정
	 * @param inputMember
	 * @return result
	 */
	int updateInfo(Member inputMember);

	/** 현재 비번 조회
	 * @param loginMember
	 * @return
	 */
	String currPw(Member loginMember);

	/** 비번 변경
	 * @param loginMember
	 * @return
	 */
	int changePw(Member loginMember);

	/** 회원 탈퇴
	 * @param loginMember
	 * @return
	 */
	int secession(Member loginMember);

}
