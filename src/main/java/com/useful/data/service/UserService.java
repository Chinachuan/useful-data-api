package com.useful.data.service;

import com.useful.entity.user.User;
import com.useful.support.DbException;

public interface UserService {
	public int addUser(User user) throws DbException;
}
