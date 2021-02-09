package com.itcast.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.admin.entity.Account;
import com.itcast.admin.mapper.AccountMapper;

@Service
public class AccountService {

	@Autowired
	AccountMapper accountMappper;
	
	
	public Account getAccountById(Long id) {
		return accountMappper.getAccount(id);
	}
}
