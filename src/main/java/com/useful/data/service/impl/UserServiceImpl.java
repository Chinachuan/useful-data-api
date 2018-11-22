package com.useful.data.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.useful.data.dao.UserDao;
import com.useful.data.service.UserService;
import com.useful.entity.user.User;
import com.useful.support.DbException;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public int addUser(@Valid @RequestBody User user) throws DbException {
		int code = (int) (Math.random() * 100000000);
		String randomCode = String.valueOf(code);
		
		int call = (int) (Math.random() * 10000000);
		String randomCall = String.valueOf(call);
		
		User usr = new User();
		usr.setCardNo(Long.toString(System.currentTimeMillis()));
		usr.setEmail(randomCode + "@qq.com");
		usr.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		usr.setUsername("张三"+randomCode);
		usr.setShowname("LZ"+randomCode);
		usr.setIphone("136"+randomCall);
		usr.setQqCode(randomCode);
		int flag = userDao.addUser(usr);
		return flag;
	}

}
