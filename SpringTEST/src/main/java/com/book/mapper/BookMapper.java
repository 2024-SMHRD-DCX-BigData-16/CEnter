package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.book.entity.BookVO;

@Mapper
@MapperScan("com.book.mapper")
public interface BookMapper {

	 public List<BookVO> bookList();

	public void bookInsert(BookVO vo);

	

}
