package com.temp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add2")
public class Add2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] num_ = req.getParameterValues("num");
		//같은 이름을 가진 여러 파라미터 받기 

		int result = 0;
		
		for(int i = 0; i < num_.length; i++) {
			int num = 0;
			
			if(num_[i].equals("")) num = 0;
			else num = Integer.parseInt(num_[i]);
			
			result += num;
		}// for
		
		resp.getWriter().printf("result = %d", result);
	}// service

}
