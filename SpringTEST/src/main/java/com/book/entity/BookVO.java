package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {

	private int num;
	private String title;
	private String author;
	private String company;
	private String isbn;
	private int count;
}
