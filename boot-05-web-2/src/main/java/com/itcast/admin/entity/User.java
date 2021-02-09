package com.itcast.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@TableField(exist = false)
	private String userName;
	@TableField(exist = false)
	private String password;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;

	}

	private Long id;
	private String name;
	private Integer age;
	private String email;

}
