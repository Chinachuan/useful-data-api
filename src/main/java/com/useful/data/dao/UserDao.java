package com.useful.data.dao;

import com.useful.entity.user.User;
import com.useful.support.DbException;

public interface UserDao {
	
	public int addUser(User user) throws DbException;

}
