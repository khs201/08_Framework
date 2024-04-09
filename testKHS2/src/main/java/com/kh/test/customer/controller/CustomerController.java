package com.kh.test.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService service;
	
	@PostMapping("/add")
	public String add(
			@RequestParam("addName") String customerName ,
			@RequestParam("addPhone") String customerTel ,
			@RequestParam("addAddress") String customerAddress ,
			 Model model
			) {
		
		Customer customer = service.add(customerName, customerTel, customerAddress);
		model.addAttribute("customer", customer);
		
		return "/result";
		
	}
	
	
}
