package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 */
	public Member login(Member mem) throws Exception{
		// Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 수행
		Member loginMember = dao.login(mem, conn);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return loginMember;
	}

	/** 회원가입 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {
		
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		int result = dao.signUp(mem, conn);
		
		if(result != 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 내정보수정 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(mem, conn);
		
		if(result != 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.changePw(currentPw, newPw, memberNo, conn);
		
		if(result != 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int secession(String memberPw, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.secession(memberPw, memberNo, conn);
		
		if(result != 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 이메일 중복 검사
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.emailDupCheck(memberEmail, conn);
		
		close(conn);
		
		return result;
	}

	/** 닉네임 중복 검사
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNickname) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.nicknameDupCheck(memberNickname, conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 정보 조회
	 * @param inputEmail
	 * @return member
	 * @throws Exception
	 */
	public Member selectOne(String inputEmail) throws Exception{
		Connection conn = getConnection();
		
		Member member = dao.selectOne(inputEmail, conn);
		
		close(conn);
		
		return member;
	}

	/** 회원 목록 전체 조회 ajax
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAll(conn);
		
		close(conn);
		
		return memberList;
	}
}
