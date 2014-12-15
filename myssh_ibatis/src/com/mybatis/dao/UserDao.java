package com.mybatis.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mybatis.model.User;


public class UserDao extends SqlSessionDaoSupport {
	public void getUserById(){
		User user = this.getSqlSession().selectOne("com.mybatis.dao.UserMapper.selectUserById2", 1);
		System.out.print(user);
	}
	
}
