package com.khs.book.main.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khs.book.model.dto.Book;

@Mapper
public interface MainMapper {

	List<Book> search();

	List<Book> detailSearch(String bookTitle);

	int addBook(Book book);

	

}
