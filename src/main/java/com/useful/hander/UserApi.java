package com.useful.hander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.useful.api.BaseApiResult;
import com.useful.api.user.UserHander;
import com.useful.data.service.UserService;
import com.useful.entity.user.User;
import com.useful.support.DbException;

@RestController
@RequestMapping("/user")
public class UserApi implements UserHander{
	
	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(value = "/adduser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseApiResult adduser(String userName){
		// TODO Auto-generated method stub
		BaseApiResult result = new BaseApiResult();
		try {
			User user = new User();
			user.setUsername(null);
			user.setEmail("6666666@qq.com");
			int flag = userService.addUser(user);
			if(flag == 1) {
				result.setMesg("添加成功");
				result.setSucc(true);
			}else {
				result.setMesg("操作失败");
				result.setSucc(false);
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
