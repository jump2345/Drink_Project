package kr.co.mlec.member.service;

import java.util.List;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberPagingVO;
import kr.co.mlec.member.vo.MemberVO;

public class MemberService {

	private MemberDAO loginDao;
	// 여러개의 DAO들이 올 수 있다.

	public MemberService() {
		loginDao = new MemberDAO();

	}

	public MemberVO login(MemberVO loginVO) {
		return loginDao.login(loginVO);

	}
	
	
 //회원가입
	private MemberDAO registerDao;
		
	public MemberVO Register(MemberVO register) {
		registerDao = new MemberDAO();
		return registerDao.registerMember(register);

	}
	
	
	/*
	 * //아이디 중복 체크 private MemberDAO idCheck;
	 * 
	 * public MemberVO Register(String id) { idCheck = new MemberDAO(); return
	 * idCheck.joinIdCheck(id);
	 * 
	 * }
	 */
	
	
	
	
	/*
	 * 
	 * 관리자모드 회원 관리....
	 * 
	 */
		//회원 목록 보기
		
		private MemberDAO adminMemberList;
		
		public  List<MemberVO> selectAllmember(MemberPagingVO paging){
			
			return adminMemberList.selectAllMember(paging);
		}


		//해당하는 회원의 글을 지우고, 회월을 삭제
		
		private MemberDAO adminDeleteMember = new MemberDAO();
		
		
		public void deleteMember(String[] ids) {
		
			for(String id : ids) {
			adminDeleteMember.deleteBoardByMember(id);
			adminDeleteMember.deleteMember(id);
			}
		}
		
		//
		


}
