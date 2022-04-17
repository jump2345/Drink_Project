package kr.co.mlec.drink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.drink.vo.DrinkPagingVO;
import kr.co.mlec.drink.vo.DrinkVO;
import kr.co.mlec.util.JDBCClose;
import kr.co.mlec.util.connectionFactory;

/**
 * 
 * 음료 게시판(drink_tb) CRUD
 * 
 * @author user MVC 버전
 */
public class DrinkDAO {

	/**
	 * 전체 음료 메뉴 조회
	 */
	public List<DrinkVO> selectAllDrink() {

		List<DrinkVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {

			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select dk_name, dk_f1, dk_f2, dk_f3, dk_f4, dk_f5, dk_f6, dk_f7, dk_f8, dk_f9, dk_f10, dk_store, dk_price ");
			sql.append(" from drink_tb ");
			sql.append(" order by no asc ");
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			

			while (rs.next()) {
				String dkName = rs.getString("dk_name");
				String dkF1 = rs.getString("dk_f1");
				String dkF2 = rs.getString("dk_f2");
				String dkF3 = rs.getString("dk_f3");
				String dkF4 = rs.getString("dk_f4");
				String dkF5 = rs.getString("dk_f5");
				String dkF6 = rs.getString("dk_f6");
				String dkF7 = rs.getString("dk_f7");
				String dkF8 = rs.getString("dk_f8");
				String dkF9 = rs.getString("dk_f9");
				String dkF10 = rs.getString("dk_f10");
				String dkStore = rs.getString("dk_store");
				String dkPrice = rs.getString("dk_price");

				DrinkVO Drink = new DrinkVO(dkName,dkF1,dkF2,dkF3,dkF4,dkF5,dkF6,dkF7,dkF8,dkF9,dkF10,dkStore,dkPrice);

				// Systme.out.println(board);

				list.add(Drink);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	/**
	 * 스타벅스 음료 조회 + 페이징
	 *   
	 */
	public List<DrinkVO> selectAllStarbucks(DrinkPagingVO paging) {

		List<DrinkVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();

		try {

			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from (select  rownum rnum, b.* ");		//sql 변경해야함. 
			sql.append("  from(select * from drink_tb where dk_store like '스타벅스' order by dk_name) b ) ");
			sql.append("  where (rnum >= ?) and (rnum <= ?)  ");
			
			pstmt = conn.prepareStatement(sql.toString());
					
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
		
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String dkName = rs.getString("dk_name");
				String dkF1 = rs.getString("dk_f1");
				String dkF2 = rs.getString("dk_f2");
				String dkF3 = rs.getString("dk_f3");
				String dkF4 = rs.getString("dk_f4");
				String dkF5 = rs.getString("dk_f5");
				String dkF6 = rs.getString("dk_f6");
				String dkF7 = rs.getString("dk_f7");
				String dkF8 = rs.getString("dk_f8");
				String dkF9 = rs.getString("dk_f9");
				String dkF10 = rs.getString("dk_f10");
				String dkPrice = rs.getString("dk_price");

				DrinkVO starbucks = new DrinkVO(dkName, dkF1, dkF2, dkF3, dkF4, dkF5, dkF6, dkF7, dkF8, dkF9, dkF10, dkF10, dkPrice);
				// Systme.out.println(board);

				list.add(starbucks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	
	// 페이징 - 스타벅스 페이지
	public int getAllCount() {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   
		   int count = 0;
		   
		   try {
		      conn = new connectionFactory().getConnection();
		      StringBuilder sql = new StringBuilder();
		      sql.append("SELECT COUNT(*) as count FROM drink_tb where dk_store like'스타벅스' ");

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
	 * 
	 * 공차 메뉴 조회  + 페이징 
	 */
	public List<DrinkVO> selectAllGongcha(DrinkPagingVO paging) {

		List<DrinkVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int startNum = paging.getStartNum();
	    int endNum = paging.getEndNum();
	
		try {

			conn = new connectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from (select  rownum rnum, b.* ");		//sql 변경해야함. 
			sql.append("  from(select * from drink_tb where dk_store like '공차' order by dk_name) b ) ");
			sql.append("  where (rnum >= ?) and (rnum <= ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String dkName = rs.getString("dk_name");
				String dkF1 = rs.getString("dk_f1");
				String dkF2 = rs.getString("dk_f2");
				String dkF3 = rs.getString("dk_f3");
				String dkF4 = rs.getString("dk_f4");
				String dkF5 = rs.getString("dk_f5");
				String dkF6 = rs.getString("dk_f6");
				String dkF7 = rs.getString("dk_f7");
				String dkF8 = rs.getString("dk_f8");
				String dkF9 = rs.getString("dk_f9");
				String dkF10 = rs.getString("dk_f10");
				String dkPrice = rs.getString("dk_price");

				DrinkVO gongcha = new DrinkVO(dkName, dkF1, dkF2, dkF3, dkF4, dkF5, dkF6, dkF7, dkF8, dkF9, dkF10, dkF10, dkPrice);
				// Systme.out.println(board);

				list.add(gongcha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return list;
	}
	
	// 페이징 -  공차 페이지
	public int getAllCounG() {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   
		   int count = 0;
		   
		   try {
		      conn = new connectionFactory().getConnection();
		      StringBuilder sql = new StringBuilder();
		      sql.append("SELECT COUNT(*) as count FROM drink_tb where dk_store like'공차' ");

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
		/*
	 * 
	 * DrinkSuggest
	 * 탑메뉴에서 음료추천...
	 */
	public List<String> selectDrink(DrinkVO DrinkVO) {
		
		List<String> recommandDrinks = new ArrayList<>();
		
		boolean[] bools = new boolean[10];
		String[] options = new String[10];
		StringBuilder query = new StringBuilder();
		if(DrinkVO.getDk_f1() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f1 = ? ");
			bools[0] = true;
			options[0] = DrinkVO.getDk_f1();
			
		}
		if(DrinkVO.getDk_f2() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f2 = ? ");
			bools[1] = true;
			options[1] = DrinkVO.getDk_f2();
		}
		if(DrinkVO.getDk_f3() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f3 = ? ");
			bools[2] = true;
			options[2] = DrinkVO.getDk_f3();
		}
		if(DrinkVO.getDk_f4() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f4 = ? ");
			bools[3] = true;
			options[3] = DrinkVO.getDk_f4();
		}
		if(DrinkVO.getDk_f5() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f5 = ? ");
			bools[4] = true;
			options[4] = DrinkVO.getDk_f5();
			
		}
		if(DrinkVO.getDk_f6() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f6 = ? ");
			bools[5] = true;
			options[5] = DrinkVO.getDk_f6();
		}
		if(DrinkVO.getDk_f7() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f7 = ? ");
			bools[6] = true;
			options[6] = DrinkVO.getDk_f7();
		}
		if(DrinkVO.getDk_f8() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f8 = ? ");
			bools[7] = true;
			options[7] = DrinkVO.getDk_f8();
		}
		if(DrinkVO.getDk_f9() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f9 = ? ");
			bools[8] = true;
			options[8] = DrinkVO.getDk_f9();
		}
		if(DrinkVO.getDk_f10() != null) {
			if(query.toString().length() != 0) 
				query.append("and ");
			query.append("dk_f10 = ? ");
			bools[9] = true;
			options[9] = DrinkVO.getDk_f10();
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("select dk_name ");
		sql.append("  from drink_tb ");
		sql.append(" where " );
		sql.append(query);
		
		//System.out.println(sql.toString());
		
		
		try(
				Connection conn = new connectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			
			int loc = 1;
			for(int i = 0; i < bools.length; i++) {
				if(bools[i]) {
					pstmt.setString(loc++, options[i]);
				}
			}
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				recommandDrinks.add(rs.getString("dk_name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return recommandDrinks;
	}

	/*
	 *DrinkSearchDAO
	 *첫화면에서 음료 전체 검색 
	 * 
	 */
	

/**
 * 커피메뉴 검색
 */
 

	// 1. dk_name으로 검색
	

	public ArrayList<DrinkVO> DrinkSearchByname (String dk_name) {
		
		ArrayList<DrinkVO> drinklist = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new connectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select dk_name, dk_store, dk_price ");
			sql.append(" from drink_tb ");
			sql.append(" where instr(dk_name, ?)>0 ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dk_name);
		
			ResultSet rs = pstmt.executeQuery();
			drinklist = new ArrayList<DrinkVO>();
			
			while (rs.next()) {
				String dk_name_ = rs.getString("dk_name");
				String dk_store_ = rs.getString("dk_store");
				String dk_price_ = rs.getString("dk_price");
				
				
				
			DrinkVO search = new DrinkVO(dk_name_, dk_store_, dk_price_);
			System.out.println(search);
			drinklist.add(search);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return drinklist;
	}

		




		//2. 음료 가게명으로 검색


public ArrayList<DrinkVO> DrinkSearchBystore (String dk_store) {
	
	ArrayList<DrinkVO> drinklist2 = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = new connectionFactory().getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("select dk_name, dk_store, dk_price ");
		sql.append(" from drink_tb ");
		sql.append(" where instr(dk_store, ?)>0 ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, dk_store);
	
		ResultSet rs = pstmt.executeQuery();
		drinklist2 = new ArrayList<DrinkVO>();
		
		while (rs.next()) {
			String dk_name_ = rs.getString("dk_name");
			String dk_store_ = rs.getString("dk_store");
			String dk_price_ = rs.getString("dk_price");
			
		DrinkVO search = new DrinkVO(dk_name_, dk_store_, dk_price_);
		System.out.println(search);
		drinklist2.add(search);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return drinklist2;

	
}

/*
 * 
 * 관리자모드 
 * 
 */

//관리자용
//음료 삭제 

public void deleteDrink (String dkName) {

	
	String sql = "delete from drink_tb where dk_name = ? ";
	
	try (Connection conn = new connectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
	
		pstmt.setString(1, dkName);
		pstmt.executeUpdate();

		
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}

//관리자용
// 음료 추가


public void insertDrink(DrinkVO drink) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
		
		
		try {
			conn = new connectionFactory().getConnection(); // private 으로 묶어서 올려버린다.
			StringBuilder sql = new StringBuilder();
			sql.append("insert into drink_tb( dk_name, dk_f1, dk_f2, dk_f3, dk_f4,  ");
			sql.append("  dk_f5, dk_f6, dk_f7, dk_f8, dk_f9, dk_f10, dk_store, dk_price) ");
			sql.append("  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());

		
			//pstmt.setInt(1, board.getComNo());
			pstmt.setString(1, drink.getDk_name());
			pstmt.setString(2, drink.getDk_f1());
			pstmt.setString(3, drink.getDk_f2());
			pstmt.setString(4, drink.getDk_f3());
			pstmt.setString(5, drink.getDk_f4());
			pstmt.setString(6, drink.getDk_f5());
			pstmt.setString(7, drink.getDk_f6());
			pstmt.setString(8, drink.getDk_f7());
			pstmt.setString(9, drink.getDk_f8());
			pstmt.setString(10, drink.getDk_f9());
			pstmt.setString(11, drink.getDk_f10());
			pstmt.setString(12, drink.getDk_store());
			pstmt.setString(13, drink.getDk_price());
			
		pstmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
}	
	

//관리자용
// 음료 정보 수정


public void updateDrink(DrinkVO drink) {
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();

		sql.append("update drink_tb ");
		sql.append("	set dk_f1 = ?, dk_f2 = ?, dk_f3 = ?, dk_f4 = ?, dk_f5 = ?, ");
		sql.append("    dk_f6 = ?, dk_f7 = ?, dk_f8 = ?, dk_f9 = ?, dk_f10 = ?,  ");
		sql.append("    dk_store = ?, dk_price = ?  ");
		sql.append("    where dk_name = ? ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, drink.getDk_f1());
		pstmt.setString(2, drink.getDk_f2());
		pstmt.setString(3, drink.getDk_f3());
		pstmt.setString(4, drink.getDk_f4());
		pstmt.setString(5, drink.getDk_f5());
		pstmt.setString(6, drink.getDk_f6());
		pstmt.setString(7, drink.getDk_f7());
		pstmt.setString(8, drink.getDk_f8());
		pstmt.setString(9, drink.getDk_f9());
		pstmt.setString(10, drink.getDk_f10());
		pstmt.setString(11, drink.getDk_store());
		pstmt.setString(12, drink.getDk_price());
		pstmt.setString(13, drink.getDk_name());
		
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}

}


//관리자용
//음료 이름에 대한 조회

public DrinkVO selectDrinkByName(String dk_name) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	DrinkVO drink = null;

	try {
		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();

		sql.append("select dk_name, dk_f1, dk_f2, dk_f3, dk_f4, dk_f5, ");
		sql.append("    dk_f6, dk_f7, dk_f8, dk_f9, dk_f10,  ");
		sql.append("    dk_store, dk_price  ");
		sql.append("    from drink_tb  ");		
		sql.append("    where dk_name = ? ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, dk_name);
		
		 ResultSet rs = pstmt.executeQuery();

         if (rs.next()) {
        	 String dkName = rs.getString("dk_name");
        	 String dk_f1 = rs.getString("dk_f1");
        	 String dk_f2 = rs.getString("dk_f2");
        	 String dk_f3 = rs.getString("dk_f3");
        	 String dk_f4 = rs.getString("dk_f4");
        	 String dk_f5 = rs.getString("dk_f5");
        	 String dk_f6 = rs.getString("dk_f6");
        	 String dk_f7 = rs.getString("dk_f7");
        	 String dk_f8 = rs.getString("dk_f8");
        	 String dk_f9 = rs.getString("dk_f9");
        	 String dk_f10 = rs.getString("dk_f10");
        	 String dk_store = rs.getString("dk_store");
        	 String dk_price = rs.getString("dk_price");

        	 drink = new DrinkVO(dkName, dk_f1, dk_f2, dk_f3, dk_f4, dk_f5, dk_f6, dk_f7, dk_f8, dk_f9, dk_f10, dk_store, dk_price);
         } 			 
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return drink;
}



/**
 * 관리자용
 * 전체 음료 조회 + 페이징
 *   
 */
public List<DrinkVO> selectAllDrink(DrinkPagingVO paging) {

	List<DrinkVO> list = new ArrayList<>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int startNum = paging.getStartNum();
    int endNum = paging.getEndNum();

	try {

		conn = new connectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from (select  rownum rnum, b.*from(select * ");		//sql 변경해야함. 
		sql.append("  from drink_tb order by dk_name asc) b ) ");
		sql.append("  where (rnum >= ?) and (rnum <= ?) ");
		
		pstmt = conn.prepareStatement(sql.toString());
				
		pstmt.setInt(1, startNum);
		pstmt.setInt(2, endNum);
	
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String dkName = rs.getString("dk_name");
			String dkF1 = rs.getString("dk_f1");
			String dkF2 = rs.getString("dk_f2");
			String dkF3 = rs.getString("dk_f3");
			String dkF4 = rs.getString("dk_f4");
			String dkF5 = rs.getString("dk_f5");
			String dkF6 = rs.getString("dk_f6");
			String dkF7 = rs.getString("dk_f7");
			String dkF8 = rs.getString("dk_f8");
			String dkF9 = rs.getString("dk_f9");
			String dkF10 = rs.getString("dk_f10");
			String dkStore = rs.getString("dk_store");
			String dkPrice = rs.getString("dk_price");

			DrinkVO allDrinkList = new DrinkVO(dkName, dkF1, dkF2, dkF3, dkF4, dkF5, dkF6, dkF7, dkF8, dkF9, dkF10, dkStore, dkPrice);			
			// Systme.out.println(board);

			list.add(allDrinkList);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	return list;
}

// 관리자용 페이징 
public int getAllCounA() {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   
	   int count = 0;
	   
	   try {
	      conn = new connectionFactory().getConnection();
	      StringBuilder sql = new StringBuilder();
	      sql.append("SELECT COUNT(*) as count FROM drink_tb ");

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

}

