package com.nucleus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.CustomerDetails;

public class CustomerRDBMSImpl implements ICustomerDao {

	@Override
	public void SaveCustomerDetails(CustomerDetails customerdetails) throws SQLException {
	
		Connectionclass connectionclass = new Connectionclass(); //Object of Connectionclass
		Connection con = connectionclass.getDBConnection();   // Calling a getDBConnection method of Connectionclass

		PreparedStatement preparedstmt = con.prepareStatement("insert into customer_priya (customer_code,customer_name,customer_address1,customer_address2,customer_pin_code,email_address,contact_number ,primary_contact_person,record_status,active_inactive_flag,create_date,created_by,modified_date, modified_by,authorized_date,authorized_by) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedstmt.setString(1,customerdetails.getCustomercode());
		preparedstmt.setString(2, customerdetails.getCustomername());
		preparedstmt.setString(3, customerdetails.getAddress1());
		preparedstmt.setString(4, customerdetails.getAddress2());
		preparedstmt.setInt(5, customerdetails.getCustomerpincode());
		preparedstmt.setString(6, customerdetails.getEmailaddress());
		preparedstmt.setLong(7, customerdetails.getContactno());
		preparedstmt.setString(8, customerdetails.getPrimary_contact_person());
		preparedstmt.setString(9, customerdetails.getRecord_status());
		preparedstmt.setString(10, customerdetails.getActive_inactive_flag());
		java.util.Date date = customerdetails.getCreate_date();
		if(date!=null)
		{
		java.sql.Date dt = new java.sql.Date(date.getTime());   // Util date converted into sql date
		preparedstmt.setDate(11, dt);
		}
		else
		{
			preparedstmt.setDate(11,(Date) date);     //this allows JDBC to identify this is a sql date
		}
	
		preparedstmt.setString(12, customerdetails.getCreated_by());
		
		java.util.Date date2 = customerdetails.getModified_date();
		if(date2!=null)
		{
		java.sql.Date dt1 = new java.sql.Date(date2.getTime());
		preparedstmt.setDate(13, dt1);
		}
		else
		{
			preparedstmt.setDate(13,(Date) date2);
		}
		
				preparedstmt.setString(14, customerdetails.getModified_by());
				
				java.util.Date date3 = customerdetails.getAuthorized_date();
				if(date3!=null)
				{
				java.sql.Date dt2 = new java.sql.Date(date3.getTime());
				preparedstmt.setDate(15, dt2);
				}
				else
				{
					preparedstmt.setDate(15,(Date) date3);
				}
			
				preparedstmt.setString(16, customerdetails.getAuthorized_by());
				
				preparedstmt.executeUpdate();
				System.out.println("------ Record Inserted In Database -------");
				connectionclass.closeDBConnection();

				
				}
				
	}
	


