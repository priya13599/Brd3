package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertCustomerDetailsController
 */
@WebServlet("/InsertCustomerDetailsController")
public class InsertCustomerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCustomerDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		String userid = (String) session.getAttribute("userid");
		String customercode = request.getParameter("customercode");
		String customername= request.getParameter("customername");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String email = request.getParameter("email");
		long contactno = Long.parseLong(request.getParameter("contactno"));
		String contactperson = request.getParameter("contactperson");
		String flag = request.getParameter("flag");
		Date date = new Date();
		SimpleDateFormat smd = new SimpleDateFormat("dd/MMM/yyyy");
		String createdate = smd.format(date);
		String createby = userid;
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
