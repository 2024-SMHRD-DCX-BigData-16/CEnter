package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Message;

@Mapper
public interface MessageMapper {

	public int messageSend(Message message);
	
	// select -> email일이 같은 유저의 모든 메세지를 가지고 올것(보낸사람, 번호,메세지 내용, 보낸 날짜)
	public List<Message> messageList(String email);

}
