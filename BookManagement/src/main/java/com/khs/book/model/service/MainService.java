package com.khs.book.model.service;

import java.util.List;

import com.khs.book.model.dto.Book;

public interface MainService {

	/** 전체 조회
	 * @return bookList
	 */
	List<Book> search();

	/** 검색 조회
	 * @param bookName 
	 * @return
	 */
	List<Book> detailSearch(String bookTitle);

	/** 책 추가
	 * @param bookPrice
	 * @param bookWriter
	 * @param bookTitle
	 * @return 
	 */

	int addBook(int bookPrice, String bookWriter, String bookTitle);

}
