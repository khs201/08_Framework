package com.kh.test.model.service;

import java.util.List;

import com.kh.test.model.dto.Student;

public interface StudentService {

	/** 학생 전체 조회
	 * @return
	 */
	List<Student> selectList();


}
