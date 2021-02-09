package com.itcast.admin;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itcast.admin.entity.User;
import com.itcast.admin.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Boot05Web2ApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account account", Long.class);
		log.info("總紀錄: {}", count);
		log.info("數據原類型: {}", dataSource.getClass());

	}

	@Test
	void testUserMapper() {
		System.out.println("dosum");
		List<User> userList  = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

}
