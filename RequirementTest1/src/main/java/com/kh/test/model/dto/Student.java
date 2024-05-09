package com.kh.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	/*
	 * STUDENT_NO NUMBER PRIMARY KEY,
	 * 
	 * STUDENT_NAME NVARCHAR2(10) NOT NULL,
	 * 
	 * STUDENT_MAJOR NVARCHAR2(20) NOT NULL,
	 * 
	 * STUDENT_GENDER CHAR(1) CHECK(STUDENT_GENDER IN ('M', 'F')) NOT NULL
	 */
	
	private int studentNo;
	private String studentName;
	private String studentMajor;
	private String studentGender;
	
}
