package com.kh.test.customer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor 
public class Customer {
	
	private int customerNo;
	private String customerName;
	private String customerTel;
	private String customerAddress;

}
