package edu.kh.jdbc.member.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.member.dto.Member;

// DAO(Data Access Object) : 데이터가 저장되어있는 DB, 파일 등에 접근하는 객체
//							 -> DB에 접근할 수 있다 == SQL을 수행하고 결과를 반환 받아올 수 있다

// Java에서 DB에 접근하고 결과를 반환받기 위한 프로그래밍 API를 제공함
// == JDBC(Connection, Statement, PrepareStatement, ResultSet)
public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param memberId
	 * @return result
	 */
	public int duplicateCheck(Connection conn, String memberId) throws Exception {
		// 1. 결과 저장용 변수
		int result = 0;
		
		try {
			// 2. SQL 작성
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND SECESSION_FL = 'N'";
			
			// 3. PreparedStatement 객체 생성(Connection, sql 필요)
			pstmt = conn.prepareStatement(sql);
			
			// 4. 위치홀더에 알맞은 값 세팅
			pstmt.setString(1, memberId);
			
			// 5. SQL 수행 결과 반환 받기
			rs = pstmt.executeQuery(); // SELECT 수행 결과 ResultSet을 반환 받음
			
			// 6. 조회 결과를 한 행씩 접근하여 원하는 컬럼 값 얻어오기
			if(rs.next()) {
				result = rs.getInt(1); // 1은 컬럼 순서를 나타냄
			}
			
		} finally { // try - finally 구문(catch는 throws에 의해서 생략)
			// 7. 사용한 JDBC 자원 반환 (주의! conn 제외)
			close(rs);
			close(pstmt);
		}
		// 8. SQL 수행 결과 반환
		return result;
	}

	
	
	/** 회원 가입 DAO
	 * @param conn
	 * @param signUpMember
	 * @return result
	 */
	public int signUp(Connection conn, Member signUpMember) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, signUpMember.getMemberId());
			pstmt.setString(2, signUpMember.getMemberPw());
			pstmt.setString(3, signUpMember.getMemberName());
			pstmt.setString(4, signUpMember.getMemberGender() + "");
							// char + "" --> String
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 로그인
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return loginMember
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception {
		
		Member loginMember = null;
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			int memberNo = rs.getInt("MEMBER_NO");
			String memberId = rs.getString("MEMBER_ID");
			String memberPw = rs.getString("MEMBER_PW");
			String memberName = rs.getString("MEMBER_NM");
			char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
			Date enrollDate = rs.getDate("ENROLL_DATE");
			char secessionFl = rs.getString("SECESSION_FL").charAt(0);
			
			loginMember = new Member(memberNo, memberId, memberPw, 
					memberName, memberGender, enrollDate, secessionFl);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}



	/** 회원 목록 조회
	 * @param conn
	 * @return memList
	 */
	public List<Member> selectAll(Connection conn) throws Exception{
		
		List<Member> memberList = new ArrayList<>();
		
		try {
			// 1. SQL 작성
			String sql = prop.getProperty("selectAll");
			
			// 2. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 3. SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 4. ResultSet을 한 행씩 접근하여 조회된 컬럼 값을 얻어와
			//	  Member 객체에 저장
			while(rs.next()) {
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				
				Member member = new Member(memberId, memberName, enrollDate);
				
				// 5. 생성된 Member 객체를 List에 추가
				memberList.add(member);
			}

		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}



	/** 내 정보 수정
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int updateMyInfo(Connection conn, String memberName, char memberGender, 
							Member loginMember) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMyInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender + "");
			pstmt.setInt(3, loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}



	/** 비밀번호 변경
	 * @param conn
	 * @param updatePw
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(Connection conn, int memberNo, String currentPw, String updatePw) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePw);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, currentPw);
			
			result = pstmt.executeUpdate();
		
		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 회원 탈퇴
	 * @param conn
	 * @param memberNo
	 * @param currentPw
	 * @return result
	 */
	public int secession(Connection conn, int memberNo, String currentPw) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("secession");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, currentPw);
			
			result = pstmt.executeUpdate();
		
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
}
