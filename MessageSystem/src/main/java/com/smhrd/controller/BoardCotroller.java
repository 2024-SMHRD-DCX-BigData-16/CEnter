package com.smhrd.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@Controller
public class BoardCotroller {

	@Autowired
	BoardMapper boardMapper;

	// BoardMain.jsp로 이동하는 기능
	@GetMapping("/goBoardMain")
	public String goBoardMain(Model model) {
		List<Board> blist = boardMapper.boardlist();
		// Spring에서 화면이 아닌 데이터를 리턴하기 위해 사용하는 객체
		model.addAttribute("boardlist", blist);
		// 전체 게시글 출력하는 기능
		// /goBoardMain 주소로 요청보내기! -> boardMapper 통해서 boardList 메소드를 호출!
		// -> interface -> Mapper.xml -> interface -> controller로 돌아와서 Model에 담아주기!
		
		return "BoardMain";
	}

	// BoardWrite.jsp로 이동하는 기능
	@GetMapping("/goBoardWrite")
	public String goBoardWrite() {
		return "BoardWrite";
	}
	@RequestMapping("/boardContent")
	public String boardContent(@RequestParam("idx")int idx, Model model) {
		
		// 내가 선택한 특정 게시물의 모든 정보를 출력!
		Board board = boardMapper.boardContent(idx);
		model.addAttribute("board", board);
		
		return "BoardDetail";
	}
	
	
	
	
	// 게시글 업로드 기능
	@PostMapping("/BoardInsert")
	public String BoardInsert(Board board, HttpServletRequest request) { // title, writer, filename, content

		// 파일 업로드를 위한 객체 : MultipartRequest

		MultipartRequest multi = null;

		try {
			// 1. 요청객체(request)
			// 2. 파일을 저장할 폴더의 경로(String)
			String savePath = request.getRealPath("resources/upload");
			System.out.println(savePath);
			// 3. 허용 용량 크기(int)
			int maxSize = 1024 * 1024 * 10; // 10MB
			// 4. 파일 이름의 인코딩 방식(String)
			String encoding = "UTF-8";
			// 5. 중복이름 제거(DefaultFileRenamePolicy)
			DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
			multi = new MultipartRequest(request, savePath, maxSize, encoding, dfrp);

			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String filename = multi.getFilesystemName("filename");
			String content = multi.getParameter("content");

			// DB에 넣어주기 위해서 묶어주기! -> Mybatis
			board = new Board(title, writer, filename, content);
			System.out.println(board);

		} catch (Exception e) {
			// TODO: handle exception
		}

		int result = boardMapper.insertBoard(board);

		if (result > 0) {
			System.out.println("게시글 업로드 완료!");
		} else {
			System.out.println("게시글 업로드 실패!");
		}

		return "redirect:/goBoardMain";
	}
}
