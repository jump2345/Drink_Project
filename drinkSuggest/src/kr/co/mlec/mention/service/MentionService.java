package kr.co.mlec.mention.service;

import java.util.ArrayList;


import kr.co.mlec.mention.dao.MentionDAO;
import kr.co.mlec.mention.vo.MentionVO;


public class MentionService {
	
	
	private MentionDAO mentionDao;
	
	public MentionService() {
		mentionDao = new MentionDAO();
	}
	
	
	
	//댓글 목록 조회 서비스
	public ArrayList<MentionVO> selectMentionList(int no) {

		ArrayList<MentionVO> list = mentionDao.selectMentionList(no);
		return list;
	}
	
	
	
	//댓글등록 서비스

	public void insertMention (MentionVO mention) {
		
		int mentionNo =mentionDao.selectMentionSeq();
		
		//System.out.println("ff"+mentionNo);
		mention.setMentionNo(mentionNo);
		
		mentionDao.insertMention(mention);
	}
	

	
	

	//댓글 수정
	public void updateMention(MentionVO mention) {

		//mentionDao.updateMention(mention);

	}


	
	
	
	
	//댓글 삭제
	public void deleteMention(int mentionNo) {

		mentionDao.deleteMention(mentionNo);
	}
	
	
	
	//대댓글

}
