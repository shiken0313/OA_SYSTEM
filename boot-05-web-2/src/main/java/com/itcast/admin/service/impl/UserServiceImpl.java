package com.itcast.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcast.admin.entity.User;
import com.itcast.admin.mapper.UserMapper;
import com.itcast.admin.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
	
}
