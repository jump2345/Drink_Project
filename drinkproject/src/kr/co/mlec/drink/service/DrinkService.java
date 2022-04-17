package kr.co.mlec.drink.service;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.drink.dao.DrinkDAO;
import kr.co.mlec.drink.vo.DrinkPagingVO;
import kr.co.mlec.drink.vo.DrinkVO;

public class DrinkService {

	private DrinkDAO drinkDao;
	
	
	public DrinkService() {
		drinkDao  = new DrinkDAO();
	}
	/**
	 * 스타벅스 메뉴조회 
	 * 
	 */
	public List<DrinkVO> selectAllStarbucks(DrinkPagingVO paging) {

		List<DrinkVO> list = drinkDao.selectAllStarbucks(paging);
		
		return list;
	}
	/**
	 * 공차 메뉴조회 
	 * 
	 */
	public List<DrinkVO> selectAllGongcha(DrinkPagingVO paging) {

		List<DrinkVO> list = drinkDao.selectAllGongcha(paging);
		
		return list;
	}
	
	/*
	 * 
	 * DrinkSuggest
	 * 음료추천
	 */
	public List<String> guessDrink(DrinkVO drinkVO) {
		
			return drinkDao.selectDrink(drinkVO);
		}
	
	/*
	 * 탑메뉴
	 * 관리자용으로 하는 것들....
	 * 
	 */
	
	
	// 관리자용 전체 음료 메뉴 조회 
	 
	public List<DrinkVO> selectAllDrink(DrinkPagingVO paging) {

		List<DrinkVO> list = drinkDao.selectAllDrink(paging);
		
		return list;
	}

	
	// 관리자용  음료 수정
	 
	
	public void updateDrink(DrinkVO drink) {
		
		System.out.println("update 서비스 : " + drink);

		drinkDao.updateDrink(drink);

	}

	//음료수정에 필요한 select
	
	
	public DrinkVO selectDrink(String dk_name) {
		DrinkVO drink = drinkDao.selectDrinkByName(dk_name);
		return drink;
	}
	// 관리자용   음료 삭제

	
	public void deleteDrink(String[] dkNames) {
		
		
		for(String dkName : dkNames) {
			System.out.println("delete 서비스 : " + dkName);
			drinkDao.deleteDrink(dkName);
		}
	}
	
	
	// 관리자용  음료 추가 

	public void insertDrink(DrinkVO drink) {
		// 게시물 번호(seq_tbl_board_no) 추출
		
		System.out.println("service insert 에서 : " + drink);
		
		drinkDao.insertDrink(drink);
		
		}
	
	}
