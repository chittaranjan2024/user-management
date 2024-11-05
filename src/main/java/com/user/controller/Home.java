package com.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		RequestDispatcher dispatcher;
		
		switch (action) {
		case "/register":
			 dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			break;
		case "/login":
			 dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	
}
