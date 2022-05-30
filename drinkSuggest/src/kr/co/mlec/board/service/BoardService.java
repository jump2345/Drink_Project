package kr.co.mlec.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;

public class BoardService {

	private BoardDAO boardDao;

	public BoardService() {
		boardDao = new BoardDAO();
	}

	/**
	 * 
	 * 게시글 조회서비스
	 */
	public List<BoardVO> selectAllBoard(PagingVO page) {

		List<BoardVO> list = boardDao.selectAllboard(page);
		return list;
	}

	/**
	 * 게시물 등록 서비스
	 */
	public void insertBoard(BoardVO board, List<BoardFileVO> fileList) {
		// 게시물 번호(seq_tbl_board_no) 추출
		int boardNo = boardDao.selectBoardNo();// num tilte write 다 들어있어서 boardNo 가져옴
		int maxGroupNo = boardDao.selectMaxGroupNo();
		
		// tbl_board 저장
		board.setComNo(boardNo);
		board.setGroupNo(maxGroupNo);
		
		System.out.println("service 게시물등록 그룹넘버 : " + maxGroupNo);
		
		boardDao.insertBoard(board);

		// tbl_board_file 저장
		for (BoardFileVO fileVO : fileList) {
			fileVO.setComNo(boardNo);
			boardDao.insertFile(fileVO);
		}
	}

	/**
	 * 게시판 상세 서비스 1. 파라미터로 날라온 번호에 해당 게시물 조회 2. 파라미터에 해당하는 첨부파일 조회
	 */
	public Map<String, Object> detailBoard(int no) {
		// 1.
		BoardVO board = boardDao.selectBoardByNo(no);
		boardDao.updateCnt(no);
		
		// 2.
		List<BoardFileVO> fileList = boardDao.selectFileByNo(no);

		Map<String, Object> data = new HashMap<>();
		data.put("board", board);
		data.put("fileList", fileList);

		return data;
	}

	public Object[] detailBoard2(int no) {
		// 1.
		BoardVO board = boardDao.selectBoardByNo(no);
		// 2.
		List<BoardFileVO> fileList = boardDao.selectFileByNo(no);

		Object[] arr = { board, fileList };

		return arr;
	}

	public BoardVO selectBoard(int no) {
		BoardVO board = boardDao.selectBoardByNo(no);
		return board;
	}

	/*
	 * 게시글 수정
	 * 
	 */

	public void updateBoard(BoardVO board) {

		boardDao.updateBoard(board);

	}

	/*
	 * 게시글 삭제
	 * 
	 */

	public void deleteBoard(int no) {

		boardDao.deleteBoard(no);
	}
	
	
	
	/**
	 * 답글 등록 서비스
	 */
	public void insertReplyBoard(BoardVO board, List<BoardFileVO> fileList) {
		//게시물 번호(seq_tbl_board_no) 추출
		

		int boardNo = boardDao.selectBoardNo();// num tilte write 다 들어있어서 boardNo 가져옴
		int groupNo = boardDao.selectMaxGroupNo();
		int reNo = boardDao.selectMaxReNo(board.getGroupNo());
		
		if(reNo > 0) {
			
		BoardVO groupVo = boardDao.selectgroupNo(board.getComNo());
		board.setGroupNo(groupVo.getGroupNo());
		board.setReNo(groupVo.getReNo());
		board.setReLevel(groupVo.getReLevel());

		} 
		
		//tbl_board 저장
		boardDao.insertBoardReplyUpdate(board);
		boardDao.insertBoardReply(board);
		
		//tbl_board_file 저장
		for(BoardFileVO fileVO : fileList) {
			fileVO.setComNo(boardNo);
			boardDao.insertFile(fileVO);
			boardDao.insertFile(fileVO);
		}
	}


	
	
	public BoardVO selectgroupNo(int groupNo) {
		BoardVO board = boardDao.selectgroupNo(groupNo);
		return board;
	}

	/*
	 *  maxGroupNo 추출하기
	 * 
	 */
	
	public int maxGroupNo() {
		
		int maxGroupNo = boardDao.selectMaxGroupNo();
		
		return maxGroupNo;
		
	}
	



/**
 * 게시글 검색
 * 
 */



public List<BoardVO> BoardSearchByTitle(String comTitle) {
	List<BoardVO> list1 = boardDao.BoardSearchByTitle(comTitle);
	return list1;
}



public List<BoardVO> BoardSearchByContent(String comContent) {
	List<BoardVO> list2 = boardDao.BoardSearchByContent(comContent);
	return list2;
}

public List<BoardVO> BoardSearchById(String id) {
	List<BoardVO> list3 = boardDao.BoardSearchById(id);
	return list3;
}


/*
 * 관리자용 게시글 삭제
 * 
 */

public void adminDeleteBoard (int[] no) {
	System.out.println("관리자delete 서비스 : " + no);
	
	boardDao.adminDeleteBoard(no);
}

}

