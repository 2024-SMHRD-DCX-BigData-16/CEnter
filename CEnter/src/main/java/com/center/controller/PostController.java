package com.center.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.center.entity.Post;
import com.center.mapper.PostMapper;

@Controller
public class PostController {
	
	@Autowired
	PostMapper postmapper;
	
	// 게시판 작성 페이지 이동
	@RequestMapping("/postwrite")
    public String main() {
        return "PostWrite"; 
    }
	
	// 사용자가 게시글 작성 요청
	@PostMapping("/postinsert")
	public String postinsert(Post post) {
		postmapper.postInsert(post);
		System.out.println(post);
		return "redirect:/postselect"; // 게시글 목록 페이지로 이동
	}
	
	// 게시글 목록 조회
	@RequestMapping("/postselect")
	public String postselect(Model model) {
		List<Post> postList = postmapper.postselect();
		model.addAttribute("postList", postList);
		return "PostMain";
	}
	
	// 특정 게시글 상세 조회
	@RequestMapping("/postcontent")
	   public String postContent(@RequestParam int idx, Model model) {
	      Post postone = postmapper.postcontent(idx);
	      model.addAttribute("postdone", postone);
	      return "PostRead";   
	   }
	
	
	
	
}
