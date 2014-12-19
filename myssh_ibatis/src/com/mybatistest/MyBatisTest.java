package com.mybatistest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.basedao.UserDaoImpl;
import com.mybatis.dao.UserMapper;
import com.mybatis.model.User;

public class MyBatisTest {
	@Test
	public void testUser() {
		 BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		 UserMapper userMapper = (UserMapper)factory.getBean("userMapper");
		 /* User user = (User)userMapper.selectUserById(2);
		  System.out.println(user);
		  
		  UserDaoImpl userDaoImpl = (UserDaoImpl)factory.getBean("userDaoImpl");
		  User user2 = (User)userDaoImpl.getUserById();
		  System.out.println(user2);
		  //add user
		  User addUser1 = new User();
		  addUser1.setId(313);
		  addUser1.setUsername("313name");
		  addUser1.setUsername("313pas");
		  userMapper.insertUser(addUser1);*/
		  Map<String,Object> param = new HashMap<String,Object>();
		  param.put("password", "pas");
		  Integer userCount = userMapper.countByExample(param);
		  
		  param.put("sortField", "password");
		  param.put("sortOrder", "asc");
		  param.put("start", 0);
		  param.put("end", 20);
		  
		  List<Map<String,Object>> pageList = userMapper.selectByExample(param);
		  
		  Logger logger=Logger.getLogger(MyBatisTest.class); 
		  logger.info(userCount+" list size:"+pageList.size());
	}
}

