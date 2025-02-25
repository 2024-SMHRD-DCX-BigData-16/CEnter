package com.center.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import com.center.entity.Post;


@Mapper
public interface PostMapper {

	public void postInsert(Post post); // 게시글 추가(게시글을 DB에 저장)

	public List<Post> postselect(); // 모든 게시글 조회

	public Post postcontent(int idx); // 특정 게시글 상세 조회(idx의 게시글 상세 조회)
	//@RequestMapping("/postcontent"
	
	

}
