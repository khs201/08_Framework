package com.kh.test.user.model.service;

import java.util.List;

import com.kh.test.user.model.dto.User;

public interface UserService {

	/** 조회
	 * @param userId
	 * @return searchList
	 */
	List<User> search(String userId);

}
