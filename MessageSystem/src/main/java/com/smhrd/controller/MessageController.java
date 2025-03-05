package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Message;
import com.smhrd.mapper.MessageMapper;

// 메세지와 관련된 모든 기능들을 수행하는 컨트롤러
@Controller
public class MessageController {
	
	
	
	
	
	@Autowired
	private MessageMapper messageMapper;
	
	
	@RequestMapping("/messageSend")
	public String messageSend(Message message) {
		System.out.println(message.toString());
		
		// 
		int result = messageMapper.messageSend(message);
		
		if(result > 0) {
			System.out.println("메세지 전송 성공");
		}else {
			System.out.println("메세지 전송 실패");
		}
		
		
		return "redirect:/goMain";
	}
	
	
	
}
