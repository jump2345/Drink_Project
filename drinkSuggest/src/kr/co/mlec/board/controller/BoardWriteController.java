package kr.co.mlec.board.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String saveFolder = "C:\\Users\\user\\web-workspace\\drinkSuggest\\WebContent\\upload";

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8",
				new SesacFileNamePolicy());

		String comTitle = multi.getParameter("comTitle");
		String id = multi.getParameter("id");
		String comContent = multi.getParameter("comContent");

		BoardVO board = new BoardVO();
		board.setComTitle(comTitle);
		board.setId(id);
		board.setComContent(comContent);

		System.out.print("controller : " + board);

		
		// 첨부파일 추출(file_ori_name, file_save_name, file_size) ==> tbl_board_file 저장
		
		List<BoardFileVO> fileList = new ArrayList<>();
		Enumeration<String> files = multi.getFileNames();
		
		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			File file = multi.getFile(fileName);

			if(file != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)file.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
				fileList.add(fileVO);
			}
		}
		
		BoardService service = new BoardService();
		service.insertBoard(board, fileList);
		return "redirect:/board/list.do";
	}

}


