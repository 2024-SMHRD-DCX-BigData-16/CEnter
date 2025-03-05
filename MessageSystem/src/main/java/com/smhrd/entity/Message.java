package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Message {
	
	private int num;
	private String sendE;
	private String receiveE;
	private String message;
	private String m_date;
	
	
	
	
}
