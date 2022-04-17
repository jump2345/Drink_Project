package kr.co.mlec.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardReplyController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		request.setCharacterEncoding("utf-8");
		
		String saveFolder = "C:\\Users\\I\\Desktop\\DrinkProjectJAVA\\drinkSuggest\\WebContent\\upload";

		MultipartRequest multi = new MultipartRequest
	            (request, saveFolder,1024*1024*3, "utf-8",new SesacFileNamePolicy());
		
		int comNo = Integer.parseInt(multi.getParameter("comNo"));
		String comTitle = multi.getParameter("comTitle");			//multi瑜� �씠�슜�빐�꽌 �궗�슜�엺�뵒.
		String id = multi.getParameter("id");
		String comContent = multi.getParameter("comContent");
	

		BoardVO board = new BoardVO();
		board.setComTitle(comTitle);
		board.setId(id);
		board.setComContent(comContent);
		board.setComNo(comNo);

		

		System.out.println(board);
		
		
		List<BoardFileVO> fileList = new ArrayList<>();
		
		
		
		Enumeration<String> files = multi.getFileNames();		//留� 泥섏쓬遺��꽣 �걹源뚯�
		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			//System.out.println(fileName);
			
			File file = multi.getFile(fileName);		//�뙆�씪 媛��닔媛� 留롮쓣 �뻹 �씠�젃寃� 媛��졇媛꾨떎.
			// File 媛앹껜�뒗 file�씠 �뼱�뵒�뿉 �엳怨� �겕湲곌� �뼱�뼸怨� �떎�뻾�븯�뒗嫄댁� �씫�뒗嫄댁� �븣�븘蹂� �닔 �엳�뒗 媛앹껜
			
			if(file != null) {	// �삤由ъ��꼸 �꽕�엫怨� 
				String fileOriName = multi.getOriginalFileName(fileName);		//�뙆�씪 �삤由ъ��꼸 �꽕�엫�븣湲�
				String fileSaveName = multi.getFilesystemName(fileName);	//�뙆�씪 由щ꽕�엫 �꽕�엫�븣湲� 
				int fileSize = (int)file.length();	//�뙆�씪 �겕湲� �븣湲�
				
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
				fileList.add(fileVO);
			}
		}
		BoardService service = new BoardService();
		service.insertReplyBoard(board, fileList);
		
		return "redirect:/board/list.do";
	}

	

}
