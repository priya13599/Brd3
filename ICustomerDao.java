package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.CustomerDetails;

public interface ICustomerDao {
	
	public void SaveCustomerDetails(CustomerDetails customerdetails) throws SQLException;

}
