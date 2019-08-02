package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.dao.IUserService;
import com.nucleus.dao.UserDao;
import com.nucleus.dao.UserRDBMSImpl;
import com.nucleus.dao.UserRDBMSImplService;
import com.nucleus.entity.UserLogin;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		UserLogin user = new UserLogin();
		user.setUserId(userid);
		user.setPassword(password);
		//UserDao userdao = new UserRDBMSImpl();
		IUserService userservice = new UserRDBMSImplService();
		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
				try {
			int flag = userservice.checkmakerlogindetails(user);
			if(flag !=0)
			{
				RequestDispatcher requestdispacher = request.getRequestDispatcher("MakerFunctions.jsp");
				requestdispacher.forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
