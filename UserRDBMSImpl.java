package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.UserLogin;

public class UserRDBMSImpl  implements UserDao{
	Connectionclass connectionclass = new Connectionclass();
	Connection con = connectionclass.getDBConnection();

	@Override
	public int checkmakerlogindetails(UserLogin user) throws SQLException {
 int flag =0;
		PreparedStatement preparedstmt = con.prepareStatement("select * from makercheckeruserlogin where userid=?");
		preparedstmt.setString(1, user.getUserId());
		ResultSet resultset = preparedstmt.executeQuery();
		while(resultset.next())
		{
			flag =1;
			//System.out.println(resultset.getString(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
			System.out.println("Successfully Login");
		}
		return flag ;
		
	}

}
