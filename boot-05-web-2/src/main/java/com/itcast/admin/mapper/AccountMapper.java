package com.itcast.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itcast.admin.entity.Account;

@Mapper
public interface AccountMapper {
	
	public Account getAccount (Long id);
	
}
