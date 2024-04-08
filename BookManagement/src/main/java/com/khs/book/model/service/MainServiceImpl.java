package com.khs.book.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khs.book.main.model.mapper.MainMapper;
import com.khs.book.model.dto.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MainServiceImpl implements MainService {

	private final MainMapper mapper;

	@Override
	public List<Book> search() {

		return mapper.search();
	}

	@Override
	public List<Book> detailSearch(String bookTitle) {
		
		
		
		return mapper.detailSearch(bookTitle);
	}

}
