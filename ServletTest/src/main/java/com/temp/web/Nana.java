package com.temp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")// mapping by annotation
public class Nana extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String cnt_ = req.getParameter("cnt");		//localhost:8080/hello		==> null
		int cnt = 20;	// default					//localhost:8080/hello?		==> null
													//localhost:8080/hello?cnt	==> ""
		if(cnt_ != null && !cnt_.equals("")) {		//localhost:8080/hello?cnt=n
			cnt = Integer.parseInt(cnt_);
		}// if got value
		
		for(int i = 0; i < cnt; i++) { 
			out.println((i + 1) + ": 안녕 이제 한글 나온다 ~ <br>");
		}// for
		
	}// end class
}
