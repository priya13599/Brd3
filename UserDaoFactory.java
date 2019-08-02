package com.nucleus.dao;

public class UserDaoFactory {
	public static UserDao getUserDao()
	{
		return new UserRDBMSImpl();
	}

}
