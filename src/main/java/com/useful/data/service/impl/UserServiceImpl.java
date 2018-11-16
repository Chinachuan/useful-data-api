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
		int code = (int) (Math.random() * 100000000);
		String randomCode = String.valueOf(code);
		
		int call = (int) (Math.random() * 10000000);
		String randomCall = String.valueOf(call);
		
		User user = new User();
		user.setCardNo(Long.toString(System.currentTimeMillis()));
		user.setEmail(randomCode + "@qq.com");
		user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		user.setUsername("张三"+randomCode);
		user.setShowname("LZ"+randomCode);
		user.setIphone("136"+randomCall);
		user.setQqCode(randomCode);
		int flag = userDao.addUser(user);
		return flag;
	}

}
