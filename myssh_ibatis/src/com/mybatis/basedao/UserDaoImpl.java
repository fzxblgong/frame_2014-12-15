package com.mybatis.basedao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.model.User;
@Repository
public class UserDaoImpl {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public User getUserById(){
		User user = sqlSessionTemplate.selectOne("com.mybatis.dao.UserMapper.selectUserById", 1);
		return user;
	}
}
