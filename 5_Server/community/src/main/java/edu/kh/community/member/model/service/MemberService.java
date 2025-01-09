package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;

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

}
