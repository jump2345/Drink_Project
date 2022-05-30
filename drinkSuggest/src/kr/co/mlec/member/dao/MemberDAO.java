package kr.co.mlec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.member.vo.MemberPagingVO;
import kr.co.mlec.member.vo.MemberVO;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.util.connectionFactory;

public class MemberDAO {
	/**
	 * 로그인 서비스
	 * 
	 * @param loginVO ( 사용자가 입력한 id, password 저장)
	 * @return userVO (id, password로 조회된 회원 정보) 조회된 정보가 없다면 null 반환
	 */

	public MemberVO login(MemberVO loginVO) {

		MemberVO userVO = null; //

		StringBuilder sql = new StringBuilder();
		sql.append("select id, pw, name, email, tel, type ");
		sql.append("   from  member_tb ");
		sql.append("where id =? and pw = ? ");

		try (Connection conn = new connectionFactory().getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) { // 1.7버전의 for문
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPw());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 아이디가 안맞거나 맞는거 하나니까 0~1개
				userVO = new MemberVO();
				// String id = rs.getString("id");
				// userVO.setId(id);
				userVO.setId(rs.getString("id"));
				userVO.setPw(rs.getString("pw"));
				userVO.setName(rs.getString("name"));
				userVO.setEmail(rs.getString("email"));
				userVO.settel(rs.getString("tel"));
				userVO.setType(rs.getString("type"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

	/*
	 * 회원가입 서비스
	 */

	public MemberVO registerMember(MemberVO register) {

		MemberVO userVO = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into member_tb(id, pw , name, email, tel) ");
		sql.append("   values( ?, ?, ?, ?, ?) ");
		try (Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, register.getId());
			pstmt.setString(2, register.getPw());
			pstmt.setString(3, register.getName());
			pstmt.setString(4, register.getEmail());
			pstmt.setString(5, register.gettel());
			
			// pstmt.setString(8, register.getType());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userVO;

	}

	// 아이디 중복체크

	
	
	public int duplecateID(String id) {
		int cnt = 0;
		try {
			Connection conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			// 아이디 중복 확인
			sql.append(" SELECT count(id) as cnt ");
			sql.append("    FROM member_tb ");
			sql.append(" WHERE id = ? ");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
		} // try end }//duplecateID end
		return cnt;
	}




/**
* 회원등록
*/
public void insertMember(MemberVO member) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member_tb( id, pw, name, email, tel");
		sql.append("  values( ?, ?, ?, ?, ?) ");
		
		pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		pstmt.setString(5, member.gettel());
	
		
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}









/**
 * 관리자용
 * 회원 조회 + 페이징
 */
public List<MemberVO> selectAllMember(MemberPagingVO paging) {

	List<MemberVO> list = new ArrayList<>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int startNum = paging.getStartNum();
    int endNum = paging.getEndNum();
	
	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from (select  rownum rnum, b.*from(select * ");		//sql 변경해야함. 
		sql.append("  from member_tb order by id desc) b ) ");
		sql.append("  where (rnum >= ?) and (rnum <= ?) ");
		
		pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setInt(1, startNum);
		pstmt.setInt(2, endNum);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String tel = rs.getString("tel");
		
			
		MemberVO allMemberList = new MemberVO(id, pw, name, email, tel);
		
		list.add(allMemberList);	
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return list;
} 

//페이징
//관리자모드에서 회원 목록 뽑을 때....


public int getAllCountA() {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   
	   int count = 0;
	   
	   try {
	      conn = new connectionFactory().getConnection();
	      StringBuilder sql = new StringBuilder();
	      sql.append("SELECT COUNT(*) as count FROM member_tb ");

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
* 회원 수정(이름, 비번, 이메일 아이디, 도메인, 번호123, 우편번호, 기본주소, 상세주소)
*/
public void updateMember(MemberVO member) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("update member_tb ");
		sql.append("	set name = ?, pw = ?, email = ?, tel = ? ");
		sql.append(" where id = ? ");

		pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.gettel());
		pstmt.setString(5, member.getId());
		pstmt.executeQuery();
		
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}

/*
 * 회원 삭제 전에 글 지우기
 * 
 */

public void deleteBoardByMember(String id) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from comment_tb where id = ?");

		pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}



/*
 * 회원 삭제
 * 
 */

public void deleteMember(String id) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from member_tb where id = ?");

		pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}














}
