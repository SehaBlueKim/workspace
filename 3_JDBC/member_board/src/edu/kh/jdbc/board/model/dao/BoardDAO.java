package edu.kh.jdbc.board.model.dao;

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
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Reply;
import edu.kh.jdbc.member.dto.Member;

import static edu.kh.jdbc.common.JDBCTemplate.*;


/**
 * @author user1
 *
 */
public class BoardDAO {

	Properties prop;

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		prop = new Properties();

		// xml 파일 읽어오기
		try {
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/** 게시글 목록 조회
	 * @param conn
	 * @return boardList
	 */
	public List<Board> selectAll(Connection conn) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectAll");

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while(rs.next()){
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				String memberName = rs.getString("MEMBER_NM");
				int replyCount = rs.getInt("REPLY_COUNT");

				Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);

				boardList.add(board);
			}

		} finally {
			close(rs);
			close(stmt);
		}
		return boardList;
	}



	/** 게시글 상세 조회
	 * @param boardNo
	 * @param conn
	 * @return board
	 */
	public Board selectOne(int boardNo, Connection conn) throws Exception {

		Board board = null;

		try {
			// 1) SQL 작성
			String sql = prop.getProperty("selectOne");

			// 2) PreparedStatement
			pstmt = conn.prepareStatement(sql);

			// 3) ? 위치 홀더에 알맞은 값 세팅
			pstmt.setInt(1, boardNo);

			// 4) SQL 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();

			// 5) 조회된 한 행이 있을 경우 조회된 컬럼 값 얻어오기
			if(rs.next()) {
				// int boardNo = rs.getInt("BOARD_NO");
				// -> 입력 받은 boardNo 와 조회된 BOARD_NO는 같으므로
				// 굳이 DB 조회 결과에서 얻어오지 않아도 된다.

				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				int memberNo = rs.getInt("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NM");

				// 6) Board 객체 생성하여 컬럼 값 세팅
				board = new Board();
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setBoardContent(boardContent);
				board.setCreateDate(createDate);
				board.setReadCount(readCount);
				board.setMemberNo(memberNo);
				board.setMemberName(memberName);
			}

		} finally {
			// 7) 사용한 자원 반환
			close(rs);
			close(pstmt);
		}
		// 8) 결과 반환
		return board; // null 또는 주소값 반환
	}



	/** 특정 게시글 댓글 목록 조회
	 * @param boardNo
	 * @param conn
	 * @return replyList
	 */
	public List<Reply> selectReplyList(int boardNo, Connection conn) throws Exception {

		List<Reply> replyList = new ArrayList<>();

		try {
			String sql = prop.getProperty("selectReplyList");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int replyNo = rs.getInt("REPLY_NO");
				String replyContent = rs.getString("REPLY_CONTENT");
				Date createDate = rs.getDate("CREATE_DATE");
				int memberNo = rs.getInt("MEMBER_NO");
				// int boardNo = rs.getInt("BOARD_NO"); -> 매개변수로 받은거 이용할거임
				String memberName = rs.getString("MEMBER_NM");

				Reply reply = new Reply(replyNo, replyContent, createDate, memberNo, boardNo, memberName);

				replyList.add(reply);
			}

		} finally {
			close(rs);
			close(pstmt);
		}
		return replyList;
	}



	public int increaseReadCount(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("increaseReadCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 게시글 삭제
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {
			String sql = prop.getProperty("deleteBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 게시글 수정
	 * @param conn
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, Board board) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("updateBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 댓글 작성
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("insertReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	//	/** 댓글 수정
	//	 * @param conn
	//	 * @param board
	//	 * @param reply
	//	 * @return result
	//	 * @throws Exception
	//	 */
	//	public int updateReply(Connection conn, Board board, Reply reply) throws Exception {
	//		
	//		int result = 0;
	//		
	//		try {
	//			String sql = prop.getProperty("updateReply");
	//			
	//			pstmt = conn.prepareStatement(sql);
	//			
	//			pstmt.setString(1, reply.getReplyContent());
	//			pstmt.setInt(2, reply.getReplyNo());
	//			pstmt.setInt(3, reply.getMemberNo());
	//			
	//			result = pstmt.executeUpdate();
	//			
	//		} finally {
	//			close(pstmt);
	//		}
	//		return result;
	//	}
	//
	//
	//
	//	/** 댓글 삭제
	//	 * @param conn
	//	 * @param loginMember
	//	 * @param board
	//	 * @param deleteNo
	//	 * @return result
	//	 * @throws Exception
	//	 */
	//	public int deleteReply(Connection conn, Member loginMember, Board board, int deleteNo) throws Exception {
	//
	//		int result = 0;
	//		
	//		try {
	//			String sql = prop.getProperty("deleteReply");
	//			
	//			pstmt = conn.prepareStatement(sql);
	//			
	//			pstmt.setInt(1, deleteNo);
	//			pstmt.setInt(2, loginMember.getMemberNo());
	//			
	//			result = pstmt.executeUpdate();
	//			
	//		} finally {
	//			close(pstmt);
	//		}
	//		return result;
	//	}



	/** 댓글 수정 선생님 코드
	 * @param conn
	 * @param replyNo
	 * @return
	 */
	public int updateReply(Connection conn, Reply reply) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("updateReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplyNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 댓글 삭제 선생님 코드
	 * @param conn
	 * @param replyNo
	 * @return
	 */
	public int deleteReply(Connection conn, int replyNo) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("deleteReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, replyNo);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}



	/** 게시글 삽입
	 * @param conn
	 * @param board
	 * @return result
	 */
	public int insertBoard(Connection conn, Board board) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("insertBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {
			close(conn);
		}
		return result;
	}



	/** 게시글 검색
	 * @param conn
	 * @param menuNum
	 * @param keyword
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchBoard(Connection conn, int menuNum, String keyword) throws Exception {

		List<Board> boardList = new ArrayList<>();

		try {
			if(menuNum == 1 || menuNum == 2 || menuNum == 4) {
				String sql = prop.getProperty("searchBoard" + menuNum);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				rs = pstmt.executeQuery();

				while(rs.next()) {
					int boardNo = rs.getInt("BOARD_NO");
					String boardTitle = rs.getString("BOARD_TITLE");
					Date createDate = rs.getDate("CREATE_DATE");
					int readCount = rs.getInt("READ_COUNT");
					String memberName = rs.getString("MEMBER_NM");
					int replyCount = rs.getInt("REPLY_COUNT");

					Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);

					boardList.add(board);
				}
			} else if (menuNum == 3) {
				String sql = prop.getProperty("searchBoard" + menuNum);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setString(2, "%" + keyword + "%");
				rs = pstmt.executeQuery();

				while(rs.next()) {
					int boardNo = rs.getInt("BOARD_NO");
					String boardTitle = rs.getString("BOARD_TITLE");
					Date createDate = rs.getDate("CREATE_DATE");
					int readCount = rs.getInt("READ_COUNT");
					String memberName = rs.getString("MEMBER_NM");
					int replyCount = rs.getInt("REPLY_COUNT");

					Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);

					boardList.add(board);
				}
			} else {
				System.out.println("메뉴에 있는 번호만 선택해주세요.");
			}

		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	
	
	
	/** 게시글 검색 선생님 코드
	 * @param conn
	 * @param menuNum
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<Board> searchBoard2(Connection conn, int menuNum, String keyword) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			// SQL 작성 (menuNum에 따라서 SQL 조합)
			String sql = prop.getProperty("searchBoard1Teacher")
						+ prop.getProperty("condition" + menuNum)
						+ prop.getProperty("searchBoard2Teacher");

			pstmt = conn.prepareStatement(sql);
			
			// 위치 홀더에 알맞은 값 세팅
			// (주의!) 제목 + 내용을 검색하는 조건(3번)은 위치홀더가 2개다!
			
			pstmt.setString(1, keyword);
			if(menuNum == 3) pstmt.setString(2, keyword);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				String memberName = rs.getString("MEMBER_NM");
				int replyCount = rs.getInt("REPLY_COUNT");

				Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);

				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
}