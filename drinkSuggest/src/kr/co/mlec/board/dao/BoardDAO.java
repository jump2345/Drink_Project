package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.util.connectionFactory;

/**
 * 게시판 유(tbl_board) CRUD
 * 
 * 
 * MVC
 * 
 * @author user
 */
public class BoardDAO {
	/**
	 * 전체 게시글 조회
	 * 페이징 
	 */
	public List<BoardVO> selectAllboard(PagingVO paging) {

	
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
	try {

			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from (select  rownum rnum, b.*from(select comNo, id, comTitle, comContent, viewCnt, regDate, comLikeCnt  ");
			sql.append("  from comment_tb order by groupNo desc, reNo asc, reLevel asc ) b ) ");
			sql.append("  where rnum >= ? and rnum <= ?");
			
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);

			ResultSet rs = pstmt.executeQuery();    

			while (rs.next()) {
				int comNo = rs.getInt("comNo");
				String id = rs.getString("id");
				String comTitle = rs.getString("comTitle");
				String comContent = rs.getString("comContent");
				int viewCnt = rs.getInt("viewCnt");
				String regDate = rs.getString("regDate");
				int comLikeCnt = rs.getInt("comLikeCnt");
				BoardVO board = new BoardVO(comNo, id, comTitle, comContent, viewCnt, regDate, comLikeCnt);
				

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	
	// 페이징 - 전체 페이지 
	public int getAllCount() {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   
		   int count = 0;
		   
		   try {
		      conn = new connectionFactory().getConnection();
		      StringBuilder sql = new StringBuilder();
		      sql.append("SELECT COUNT(*) as count FROM comment_tb ");

		      pstmt = conn.prepareStatement(sql.toString());
		      ResultSet rs = pstmt.executeQuery();

		      if (rs.next()) {
		         count = rs.getInt("count");
		      }

		   } catch (Exception e) {
		      e.printStackTrace();
		   } finally {
		      JDBCClose.close(pstmt, conn);
		   }

		   return count;
		}
	
	/**
	 * 게시물 번호 추출(seq_tbl_board_no)
	 * 
	 */
	public int selectBoardNo() {
		String sql = "select seq_com_no.nextval from dual "; // dual: 가상의 테이블
		// 한줄로 끝나서 스트링 빌더 안씀
		int boardNo = 0;

		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				boardNo = rs.getInt(1); // 첫번째 컬럼에 있는 것을 가져온
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardNo;
	}

	/**
	 * 새글등록
	 */
	public void insertBoard(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
			
			
			try {
				conn = new connectionFactory().getConnection(); // private 으로 묶어서 올려버린다.
				StringBuilder sql = new StringBuilder();
				sql.append("insert into comment_tb( comNo, comTitle, id, comContent, groupNo) ");
				//sql.append("  values( ?, ?, ?, ?) ");
				//sql.append(" values(seq_com_no.nextval, ?,?, ?, ?) ");
				sql.append(" values(?, ?,?, ?, ?) ");

				pstmt = conn.prepareStatement(sql.toString());

			
				pstmt.setInt(1, board.getComNo());
				pstmt.setString(2, board.getComTitle());
				pstmt.setString(3,  board.getId());
				pstmt.setString(4, board.getComContent());
				pstmt.setInt(5, board.getGroupNo());


			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	
	


	/*
	 * 새글등록할 때 그룹넘버만 업데이트하기
	 * 
	 */
	public void insertGroupNo(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

			try {
				conn = new connectionFactory().getConnection(); // private 으로 묶어서 올려버린다.
				StringBuilder sql = new StringBuilder();
				sql.append("update comment_tb ");
				sql.append(" set groupNo = max(groupNo)+1  ");
				sql.append(" where comNo = ?  ");

				pstmt = conn.prepareStatement(sql.toString());

				pstmt.setInt(1, board.getComNo());
				
				pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	
	
	 /**
	    * 게시판 번호에 대한 조회
	    * 
	    * @param boardNo
	    * @return
	    */
	   public BoardVO selectBoardByNo(int boardNo) {

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      BoardVO board = null;

	      try {
	         conn = new connectionFactory().getConnection();
	         StringBuilder sql = new StringBuilder();
	         sql.append("select comNo, comTitle, id, comContent, viewCnt, comLikeCnt ");
	         sql.append("    , to_char(regDate, 'yyyy-mm-dd') regDate ");
	         sql.append("   from comment_tb ");
	         sql.append(" where comNo =?");

	         pstmt = conn.prepareStatement(sql.toString());

	         pstmt.setInt(1, boardNo);
	         ResultSet rs = pstmt.executeQuery();

	         if (rs.next()) {
	            int comNo = rs.getInt("comNo");
	            String comTitle = rs.getString("comTitle");
	            String id = rs.getString("id");
	            String comContent = rs.getString("comContent");
	            int viewCnt = rs.getInt("viewCnt");
	            String comRegDate = rs.getString("regDate");
	            int comLikeCnt = rs.getInt("comLikeCnt");

	            board = new BoardVO(comNo, id, comTitle, comContent, comLikeCnt, comRegDate, viewCnt); // 상세조회된 애들을 board로 묶는다.
	         }
	         // rs.next();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCClose.close(pstmt, conn);
	      }
	      return board;
	   }

	/**
	 * 게시물 수정(제목, 작성자, 내용)
	 */
	public void updateBoard(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append("update comment_tb ");
			sql.append("	set comTitle = ?, comContent = ? ");
			sql.append(" where comNo = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getComTitle());
			pstmt.setString(2, board.getComContent());
			pstmt.setInt(3, board.getComNo());
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

	}

	/**
	 * 게시글 삭제
	 */
	public void deleteBoard(int no) {

		String sql = "delete from comment_tb where comNo =? ";

		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 조회수 올리기
	 */
	public void updateCnt(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("update comment_tb ");
		sql.append("	set viewCnt = (viewCnt+1) ");
		sql.append(" where comNo = ? ");
		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) 
		{pstmt.setInt(1, no);
		pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 좋아요
	 * 
	 *
	 */

	// 좋아요 업데이트
	public void updateLike(int lno) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update comment_tb " );
		sql.append("	set comLikeCnt = (comLikeCnt +1) " );
		sql.append(" where comNo = ? " );
		
		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, lno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 좋아요 개수 찾기
	public int selectLike(int lno) {
		
		int like=0;
		String sql = "select comLikeCnt from comment_tb where comNo=?";
		
		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, lno);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				like = rs.getInt("comLikeCnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return like;
	}
		

	

	///////////////////////////////////////////////////////////////////
	// 첨부파일 CRUD //
	///////////////////////////////////////////////////////////////////
	

	public void insertFile(BoardFileVO fileVO) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into comment_tb_file(no, comNo, file_ori_name ");
		sql.append("         ,file_save_name, file_size) values(seq_comment_tb_file_no.nextval, ?, ?, ?, ?) ");

		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, fileVO.getComNo());
			pstmt.setString(2, fileVO.getFileOriName());
			pstmt.setString(3, fileVO.getFileSaveName());
			pstmt.setInt(4, fileVO.getFileSize());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<BoardFileVO> selectFileByNo(int boardNo) {

		List<BoardFileVO> fileList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, comNo, file_ori_name, file_save_name, file_size ");
		sql.append(" from comment_tb_file ");
		sql.append("where comNo = ? ");

		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardFileVO fileVO = new BoardFileVO();

				fileVO.setNo(rs.getInt("comNo"));
				fileVO.setFileOriName(rs.getString("file_ori_name"));
				fileVO.setFileSaveName(rs.getString("file_save_name"));
				fileVO.setFileSize(rs.getInt("file_size"));

				fileList.add(fileVO);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return fileList;
	}


	/**
	 * 답글등록
	 */
	public void  insertBoardReply(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		
//		int groupNo = 0;
//		int reNo = 1;
//		int reLevel = 1;
//		
		try {
			conn = new connectionFactory().getConnection(); // private 으로 묶어서 올려버린다.

			//groupNo = ;
			
			
			
			StringBuilder sql = new StringBuilder();			
			sql.append("insert into comment_tb(comNo, comTitle, id, comContent,  ");
			sql.append("	comLikeCnt, groupNo, reNo, reLevel ) ");
			sql.append(" values(seq_com_no.nextval, ?, ?, ?, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getComTitle());
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getComContent());
			pstmt.setInt(4, board.getComLikeCnt());
			pstmt.setInt(5, board.getGroupNo());
			pstmt.setInt(6, board.getReNo() + 1);
			pstmt.setInt(7, board.getReLevel() + 1);

			//
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	

	/*
	 * 그룹 번호를 찾아오기 (부모 글을 찾아 답글 달기) 

	 */
	
	public BoardVO selectgroupNo(int comNo, int reNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO board = null;

		try {
			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append( "select  groupNo, reNo, reLevel from comment_tb ");
			sql.append( "  where comNo = ? and reNo = ? " );

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, comNo);
			pstmt.setInt(2, reNo);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int groupNo = rs.getInt("groupNo");
				int reNo2 = rs.getInt("reNo");
				int reLevel = rs.getInt("reLevel");

				board = new BoardVO(groupNo, reNo2, reLevel);
			}
			// rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return board;
	}


	/*
	 * 
	 * 현재 그룹넘버 가장 마지막 숫자 추출해서 1 더하기
	 * 새글 등록에 쓸 것...
	 * 
	 */
	public int selectMaxGroupNo() {

		int maxGroupNo = 0;

		String sql = "  select max(groupNo)+1 from comment_tb ";


		try (Connection conn = new connectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {	
					maxGroupNo = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxGroupNo;
	}

	public int selectCurrentGroupNo(int comNo) {

		int maxGroupNo = 0;

		String sql = "  select max(groupNo) from comment_tb where comNo = ?";


		try (Connection conn = new connectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, comNo);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				maxGroupNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxGroupNo;
	}

	
	/*
	 * 
	 * 현재 reNo 가장 마지막 숫자 추출해서 1 더하기
	 * 새글 등록에 쓸 것...
	 * 
	 */
	public int selectMaxReNo(int groupNo, int comNo) {

		int maxReNo = 0;

		String sql = "  select max(reNo) from comment_tb where groupNo = ? and comNo = ? ";


		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, groupNo);
			pstmt.setInt(2, comNo);

			ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {	
					maxReNo = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxReNo;
	}
	




/**
 * 
 * 게시판 검색기능. 
 * 
 * 
 * 
 */



//1. board title로 검색

public ArrayList<BoardVO> BoardSearchByTitle (String comTitle) {
	
	
	
	
	// if(searchType.equals("comTitle")) { searchType = ""; }
	 
	
	ArrayList<BoardVO> boardsearch = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
	
		
		conn = new connectionFactory().getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, comTitle, comContent, comLikeCnt, regDate, viewCnt ");
		sql.append(" from comment_tb ");
		sql.append(" where instr(comTitle, ?)>0 ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, comTitle);
	
		ResultSet rs = pstmt.executeQuery();
		boardsearch = new ArrayList<BoardVO>();
		
		while (rs.next()) {
			
			String id_ = rs.getString("id");
			String comTitle_ = rs.getString("comTitle");
			String comContent_ = rs.getString("comContent");
			int comLikeCnt_ = rs.getInt("comLikeCnt");
			String regDate_ = rs.getString("regDate");
			int viewCnt_ = rs.getInt("viewCnt");
			
			
			
		BoardVO titlesearch = new BoardVO(id_, comTitle_, comContent_, viewCnt_, regDate_, comLikeCnt_ 
							);
		System.out.println(titlesearch);
		boardsearch.add(titlesearch);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return boardsearch;
	
	
}





//2. board content로 검색

public ArrayList<BoardVO> BoardSearchByContent (String comContent) {
	
	/*
	 * if(searchType.equals("글내용검색")) { searchType = ""; }
	 */
	
	ArrayList<BoardVO> boardsearch = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = new connectionFactory().getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, comTitle, comContent, comLikeCnt, regDate, viewCnt ");
		sql.append(" from comment_tb ");
		sql.append(" where instr(comContent, ?)>0 ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, comContent);
	
		ResultSet rs = pstmt.executeQuery();
		boardsearch = new ArrayList<BoardVO>();
		
		while (rs.next()) {
			
			String id_ = rs.getString("id");
			String comTitle_ = rs.getString("comTitle");
			String comContent_ = rs.getString("comContent");
			int comLikeCnt_ = rs.getInt("comLikeCnt");
			String regDate_ = rs.getString("regDate");
			int viewCnt_ = rs.getInt("viewCnt");
			
			
			BoardVO contentsearch = new BoardVO(id_, comTitle_, comContent_, viewCnt_, regDate_, comLikeCnt_ 
					);	
		
		System.out.println(contentsearch);
		boardsearch.add(contentsearch);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return boardsearch;
	
	
}




//3. id로 검색

public ArrayList<BoardVO> BoardSearchById (String id) {
	
	/*
	 * if(searchType.equals("글쓴이검색")) { searchType = ""; }
	 */
	
	
	ArrayList<BoardVO> boardsearch = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = new connectionFactory().getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, comTitle, comContent, comLikeCnt, regDate, viewCnt ");
		sql.append(" from comment_tb ");
		sql.append(" where instr(id, ?)>0 ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, id);
	
		ResultSet rs = pstmt.executeQuery();
		boardsearch = new ArrayList<BoardVO>();
		
		while (rs.next()) {
			
			String id_ = rs.getString("id");
			String comTitle_ = rs.getString("comTitle");
			String comContent_ = rs.getString("comContent");
			int comLikeCnt_ = rs.getInt("comLikeCnt");
			String regDate_ = rs.getString("regDate");
			int viewCnt_ = rs.getInt("viewCnt");
			
			
			BoardVO idsearch = new BoardVO(id_, comTitle_, comContent_, viewCnt_, regDate_, comLikeCnt_ 
					);
		
		System.out.println(idsearch);
		boardsearch.add(idsearch);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return boardsearch;
	
	
}

/**
 * 관리자용
 * 게시글 삭제
 */

public int adminDeleteBoard(int[] no) {

	int result = 0;
	String params = "";
	for(int i =0; i<no.length; i++) {
		params += no[i];
		if(i<no.length-1)
			params += ", ";		
	}
	
	
	String sql = "delete from comment_tb where comNo IN ("+params+");";

	try (Connection conn = new connectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {

		result = pstmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;

}


/*
 * 답글 등록에 쓰는
 * 업데이트
 * 
 */
public int  insertBoardReplyUpdate(BoardVO board) {
	Connection conn = null;
	PreparedStatement pstmt = null;
//	
	try {
		conn = new connectionFactory().getConnection(); // private 으로 묶어서 올려버린다.

		StringBuilder sql = new StringBuilder();			
		sql.append("update comment_tb set reNo = reNo + 1 ");
		sql.append("	where groupNo = ? and reNo > ? ");

		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, board.getGroupNo());
		pstmt.setInt(2, board.getReNo());

		return pstmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return -1; //오류일 때
}



	

}




