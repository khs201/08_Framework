package com.khs.book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter // Spring EL, Mybatis
@Setter // 커맨드 객체
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자(커맨드 객체)
public class Book {

	private int bookNo;
	private String bookTitle;
	private String bookWriter;
	private int bookPrice;
	private String regDate;
	
	
	
}
