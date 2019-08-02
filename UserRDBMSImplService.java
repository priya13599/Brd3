package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.UserLogin;

public class UserRDBMSImplService implements IUserService {

	UserDao userdao = UserDaoFactory.getUserDao();
	@Override
	public int checkmakerlogindetails(UserLogin maker) throws SQLException {
		
		int flag = userdao.checkmakerlogindetails(maker);
		return flag;
	}

}
