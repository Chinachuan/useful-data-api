package com.useful.data.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.useful.data.dao.UserDao;
import com.useful.entity.user.User;
import com.useful.support.DbException;
import com.useful.support.GenericServiceImpl;

//@Repository
@Service
@Transactional(readOnly=true)
public class UserDaoImpl extends GenericServiceImpl implements UserDao{
	
	@Override
	public int addUser(User user) throws DbException {
		// TODO Auto-generated method stub
		genericDao.save(user);
		return 0;
	}

}
