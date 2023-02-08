package com.temp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		ServletContext application = req.getServletContext();
//		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();

		String v_ = req.getParameter("v");
		String oper = req.getParameter("oper");

		int v = 0;
		if (!v_.equals(""))
			v = Integer.parseInt(v_);

		if (oper.equals("=")) {
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			int x = 0;

			for (Cookie c : cookies) {
				if (c.getName().equals("v")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			} // for

			int y = v;
//			String op = (String)application.getAttribute("oper");
//			String op = (String) session.getAttribute("oper");
			
			String op = "";
			for (Cookie c : cookies) {
				if (c.getName().equals("oper")) {
					op = c.getValue();
					break;
				}
			} // for

			int result = 0;

			if (op.equals("+"))
				result = x + y;
			else if (op.equals("-"))
				result = x - y;
			else if (op.equals("*"))
				result = x * y;

			resp.getWriter().printf("result = %d", result);
		} else {
//			application.setAttribute("value", v);
//			application.setAttribute("oper", oper);

//			session.setAttribute("value", v);
//			session.setAttribute("oper", oper);

			Cookie cookieV = new Cookie("v", String.valueOf(v));
			Cookie cookieOp = new Cookie("oper", oper);
			
			cookieV.setPath("/calc2"); // 해당되는 url에서만 쿠키 가져오기 
			cookieV.setMaxAge(24*60*60);
			cookieOp.setPath("/calc2");

			resp.addCookie(cookieV);
			resp.addCookie(cookieOp);
			
		} // = 이 아닌 연산의 경우 application에 값과 연산기호 저장

	}// service
}// end class
