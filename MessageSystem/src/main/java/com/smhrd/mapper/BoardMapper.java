package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {

	public int insertBoard(Board board);

	public List<Board> boardlist();

	public Board boardContent(int idx);

	

	

}
