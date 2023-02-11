package com.temp.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = 0;
		String num_ = req.getParameter("n");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		String result = "";

		if (num % 2 == 0) {
			result = "짝수";
		} else {
			result = "홀수";
		}
		
		req.setAttribute("result", result);
		
		String[] names = {"sojin", "dragon", "rabbit"};
		req.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "el조아");
		req.setAttribute("notice", notice);
		
		//redirect = 현재 작업과 상관없이 새로운 요청을 함  
		//forward = 현재 작업을 이어서 할 수 있도록 공유 (request에 저장됨)
		//session = 현재 세션에 공유 
		//pagecontext = 모든 세션, 모든 페이지에서 공유  
		//cookie = 클라이언트에 저장 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
		dispatcher.forward(req, resp);
	}// doGet
}// end class
