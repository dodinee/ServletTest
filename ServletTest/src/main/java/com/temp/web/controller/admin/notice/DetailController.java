package com.temp.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.temp.web.Entity.Notice;
import com.temp.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		NoticeService service = new NoticeService();
		Notice notice = service.getNotice(id);
		req.setAttribute("n", notice);

		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(req, resp);
	}
}
