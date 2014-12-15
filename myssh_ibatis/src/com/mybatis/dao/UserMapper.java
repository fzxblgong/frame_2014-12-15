package com.mybatis.dao;

import com.mybatis.model.User;

public interface UserMapper {
	
	public User selectUserById(Integer id2); 
	public void insertUser(User user);
	/**
	 * 注释方式也可使用：
	 * 百度：MyBatis-Spring-1.2.2 指导手册
	 * @param userId
	 * @return
	 */
	/*@Select("SELECT * FROM users WHERE id = #{userId}") 
	User getUser(@Param("userId") String userId);*/
}
