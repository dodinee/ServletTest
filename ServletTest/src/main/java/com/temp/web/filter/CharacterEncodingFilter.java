package com.temp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("hello filter");
		// 서블릿 사전/사후 모두 실행됨 
		// 단, 실행된 후 처리에 대한 것도 작성해주어야 함
		
//		System.out.println("before filter");
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);	// 필터 이후 처리내용 
//		System.out.println("after filter");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

	}

}
