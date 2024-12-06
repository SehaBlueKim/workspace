package edu.kh.jdbc.board.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Reply;
import edu.kh.jdbc.member.dto.Member;

import static edu.kh.jdbc.common.JDBCTemplate.*;
// import static : static 필드/메소드 호출 시 클래스명 생략 가능
// * : 모든

public class BoardService {

	private BoardDAO dao = new BoardDAO();



	/** 게시글 목록 조회
	 * @return boardList
	 */
	public List<Board> selectAll() throws Exception {
		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. DAO 메소드 호출 후 결과 반환 받기
		List<Board> boardList = dao.selectAll(conn);

		// 3. Connection 반환
		close(conn);

		// 4. DAO 수행 결과 다시 View로 반환
		return boardList;
	}



	/** 게시글 상세 조회
	 * @param boardNo
	 * @return board
	 */
	public Board selectOne(int boardNo) throws Exception {

		// 1) Connection 생성
		Connection conn = getConnection();

		// 2) 특정 게시글 상세 조회 DAO 메소드 호출 후 결과 반환 받기
		Board board = dao.selectOne(boardNo, conn);

		if(board != null) {	// 게시글 상세 조회 내용이 있을 경우에만
			// 3-1) 특정 게시글 댓글 목록 조회 DAO 메소드 호출 후 결과 반환 받기
			List<Reply> replyList = dao.selectReplyList(boardNo, conn);

			// Board 객체의 replyList 필드에 조회한 댓글 목록을 세팅
			board.setReplyList(replyList);

			// 3-2) 게시글 조회수 증가 DAO 메소드 호출 후 결과 반환 받기
			int result = dao.increaseReadCount(conn, boardNo);

			// 트랜잭션 제어 처리 + 조회수 동기화
			if(result > 0) {
				commit(conn);

				// DB -> READ_COUNT 업데이트
				// -> 업데이트 전에 게시글 정보를 조회함
				// -> 조회된 게시글 조회수가 DB 조회수 보다 1 낮게 나옴
				// -> 조회된 게시글의 조회수를 +1 시켜서 DB랑 동기화 시켜줘야 함
				board.setReadCount(board.getReadCount()+result);

			} else {
				rollback(conn);
			}
		}	
		// 4) Connection 반환
		close(conn);

		// 5) DAO 수행 결과 View로 반환
		return board; // 게시글 상세 조회 + 댓글 목록
	}



	public int deleteBoard(int boardNo) throws Exception {

		Connection conn = getConnection();

		int result = dao.deleteBoard(conn, boardNo);

		if (result > 0) commit(conn);
		else			rollback(conn);

		close(conn);

		return result;
	}



	/** 게시글 수정
	 * @param boardNo
	 * @param boardTitle
	 * @param boardContent
	 * @return result
	 */
	public int updateBoard(Board board) throws Exception{
		Connection conn = getConnection();

		int result = dao.updateBoard(conn, board);

		if (result > 0) commit(conn);
		else			rollback(conn);

		close(conn);

		return result;
	}



	/** 댓글 작성
	 * @param reply
	 * @return result 
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		Connection conn = getConnection();

		int result = dao.insertReply(conn, reply);

		if (result > 0) commit(conn);
		else			rollback(conn);

		close(conn);

		return result;
	}



//	/** 댓글 수정
//	 * @param loginMember
//	 * @param board
//	 * @param reply
//	 * @return result
//	 * @throws Exception
//	 */
//	public int updateReply(Member loginMember, Board board, Reply reply) throws Exception{
//		Connection conn = getConnection();
//
//		int result = dao.updateReply(conn, board, reply);
//
//		if (result > 0) {
//
//			for(Reply r : board.getReplyList()) {
//				if(r.getReplyNo() == reply.getReplyNo() 
//						&& r.getMemberNo() == loginMember.getMemberNo()) {
//					commit(conn);
//				} else {
//					rollback(conn);
//				}
//			}
//		}
//		close(conn);
//
//		return result;
//	}
	


//	/** 댓글 삭제
//	 * @param loginMember
//	 * @param board
//	 * @param deleteNo
//	 * @return result
//	 * @throws Exception
//	 */
//	public int deleteReply(Member loginMember, Board board, int deleteNo) throws Exception {
//		Connection conn = getConnection();
//
//		int result = dao.deleteReply(conn, loginMember, board, deleteNo);
//		
//		if (result > 0) {
//
//			for(Reply r : board.getReplyList()) {
//				if(r.getReplyNo() == deleteNo 
//						&& r.getMemberNo() == loginMember.getMemberNo()) {
//					commit(conn);
//				} else {
//					rollback(conn);
//				}
//			}
//		}
//		close(conn);
//
//		return result;
//	}


	
	/** 댓글 수정 선생님 코드
	 * @param reply
	 * @return result
	 */
	public int updateReply(Reply reply) throws Exception {
		Connection conn = getConnection();

		int result = dao.updateReply(conn, reply);

		if (result > 0) commit(conn);
		else			rollback(conn);

		close(conn);

		return result;
	}



	/** 댓글 삭제 선생님 코드
	 * @param replyNo
	 * @return
	 */
	public int deleteReply(int replyNo) throws Exception {
		Connection conn = getConnection();

		int result = dao.deleteReply(conn, replyNo);

		if (result > 0) commit(conn);
		else			rollback(conn);

		close(conn);

		return result;
	}



	/** 게시글 삽입
	 * @param board
	 * @return result
	 */
	public int insertBoard(Board board) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, board);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}



	/** 게시글 검색
	 * @param menuNum
	 * @param keyword
	 * @return boardList
	 */
	public List<Board> searchBoard(int menuNum, String keyword) throws Exception {
		Connection conn = getConnection();
		
		List<Board> boardList = dao.searchBoard2(conn, menuNum, keyword);
		
		close(conn);
		
		return boardList;
	}



}
