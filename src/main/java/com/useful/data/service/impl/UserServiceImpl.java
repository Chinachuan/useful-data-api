package com.useful.data.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.useful.data.dao.UserDao;
import com.useful.data.service.UserService;
import com.useful.entity.user.User;
import com.useful.support.DbException;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public int addUser() throws DbException {
		User user = new User();
		user.setCardNo("622133201");
		user.setEmail("756663562@qq.com");
		user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		user.setUsername("龚霞");
		user.setShowname("你的样子");
		user.setIphone("13688734882");
		user.setQqCode("387483762");
		userDao.addUser(user);
		return 0;
	}

}
