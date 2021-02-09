package com.itcast.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.admin.entity.Account;
import com.itcast.admin.mapper.AccountMapper;
import com.itcast.admin.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountMapper accountMappper;
	
	
	public Account getAccountById(Long id) {
		return accountMappper.getAccount(id);
	}
}
