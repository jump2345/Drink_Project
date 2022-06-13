package kr.co.mlec.mention.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.mention.vo.MentionVO;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.util.connectionFactory;

public class MentionDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	private static MentionDAO instance;

	public static MentionDAO getInstance() {
		if (instance == null)
			instance = new MentionDAO();
		return instance;
	}

	
	
	//댓글번호
	public int selectMentionSeq() {
		
		
		// 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
		String sql = "SELECT mention_tb_seq.NEXTVAL FROM DUAL";
		int mentionNo = 0; // 1
		try (Connection conn = new connectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				mentionNo = rs.getInt(1); // 첫번째 컬럼에 있는 것을 가져온
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mentionNo;

	}

	// 댓글 등록
	public void insertMention(MentionVO mention) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new connectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into mention_tb");
			sql.append(" (mentionNo, commentNo, mentionId");
			sql.append(" , mentionParent, mentionContent)");
			sql.append(" VALUES(?,?,?,?,?)");
			//sql.append(" VALUES(mention_tb_seq.nextval,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());
			

			pstmt.setInt(1, mention.getMentionNo());
			pstmt.setInt(2, mention.getCommentNo());
			pstmt.setString(3, mention.getMentionId());
			pstmt.setInt(4, mention.getMentionParent());
			pstmt.setString(5, mention.getMentionContent());
			
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

	} // end boardInsert();

	
	
	
	
	// 댓글 목록 가져오기 // getCommentList
	public ArrayList<MentionVO> selectMentionList(int comNo) {
		
		
		ArrayList<MentionVO> list = new ArrayList<MentionVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new connectionFactory().getConnection();

			/*
			 * 댓글 페이지 처리..??
			 */
			 

			StringBuilder sql = new StringBuilder();
			sql.append("    select  mentionNo, level mentionLevel,");
			sql.append("            commentNo, mentionId, regDate, mentionParent");
			sql.append("            , CASE WHEN LEVEL =1 THEN '' ELSE LPAD('└',LEVEL*4,' ') END || mentionContent mentionContent ");
			sql.append("     from  ( select * from mention_tb where commentNo = ?) ");
			sql.append("     start with mentionParent = 0 ");
			sql.append("     connect by prior mentionNo = mentionParent ");
			sql.append("     order siblings by mentionNo ");
			//sql.append("    START WITH mentionParent = 0");
			//sql.append("    CONNECT BY PRIOR mentionNo = mentionParent");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, comNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MentionVO mention = new MentionVO();
				mention.setMentionLevel(rs.getInt("mentionLevel"));
				mention.setMentionNo(rs.getInt("mentionNo"));
				mention.setCommentNo(rs.getInt("commentNo"));
				mention.setMentionId(rs.getString("mentionId"));
				mention.setRegDate(rs.getString("regDate"));
				mention.setMentionParent(rs.getInt("mentionParent"));
				mention.setMentionContent(rs.getString("mentionContent"));
				list.add(mention);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}


    //댓글 수정 
	public void updateMention(MentionVO mention){
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

	}
	
	
	
	
	

	
	//댓글 삭제

	public void deleteMention(int mentionNo) {

		
		String sql = "delete from mention_tb where mentionNo =? ";
		


		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			
			pstmt.setInt(1, mentionNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	
	
	}
}




