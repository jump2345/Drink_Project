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
		
		String saveFolder = "C:\\Users\\user\\web-workspace\\drinkSuggest\\WebContent\\upload";

		MultipartRequest multi = new MultipartRequest
	            (request, saveFolder,1024*1024*3, "utf-8",new SesacFileNamePolicy());
		
		int comNo = Integer.parseInt(multi.getParameter("comNo"));
		String comTitle = multi.getParameter("comTitle");			//multi를 이용해서 사용힌디.
		String id = multi.getParameter("id");
		String comContent = multi.getParameter("comContent");
	

		BoardVO board = new BoardVO();
		board.setComTitle(comTitle);
		board.setId(id);
		board.setComContent(comContent);
		board.setComNo(comNo);

		

		System.out.println(board);
		
		
		List<BoardFileVO> fileList = new ArrayList<>();
		
		
		
		Enumeration<String> files = multi.getFileNames();		//맨 처음부터 끝까지
		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			//System.out.println(fileName);
			
			File file = multi.getFile(fileName);		//파일 갯수가 많을 떄 이렇게 가져간다.
			// File 객체는 file이 어디에 있고 크기가 어떻고 실행하는건지 읽는건지 알아볼 수 있는 객체
			
			if(file != null) {	// 오리지널 네임과 
				String fileOriName = multi.getOriginalFileName(fileName);		//파일 오리지널 네임알기
				String fileSaveName = multi.getFilesystemName(fileName);	//파일 리네임 네임알기 
				int fileSize = (int)file.length();	//파일 크기 알기
				
				
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
