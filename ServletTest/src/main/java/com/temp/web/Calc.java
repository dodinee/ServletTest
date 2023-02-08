package com.temp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String oper = req.getParameter("oper");
		
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		int result =0;
		
		if(oper.equals("add")) result = x + y;
		else if(oper.equals("subt")) result = x - y;
		else if(oper.equals("multi")) result = x * y;
		
		resp.getWriter().printf("result = %d", result);
		
	}// service
}// end class
