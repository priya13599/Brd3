package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.UserLogin;

public interface IUserService {
	
	public int checkmakerlogindetails(UserLogin maker) throws SQLException;

}
