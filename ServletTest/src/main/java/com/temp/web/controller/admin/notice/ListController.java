package com.temp.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.temp.web.Entity.NoticeView;
import com.temp.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String field_ = req.getParameter("f");
		String query_ = req.getParameter("q");
		String page_ = req.getParameter("p");

		String field = "title";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String query = "";
		if (query_ != null && !query_.equals("")) {
			query = query_;
		}

		int page = 1;
		if (page_ != null) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int cnt = service.getNoticeCount(field, query);

		req.setAttribute("list", list);
		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String[] openIds = req.getParameterValues("openId");
		String[] delIds = req.getParameterValues("delId");
		String cmd = req.getParameter("cmd");

		System.out.println(cmd);
		switch (cmd) {
		case "일괄공개" -> {

			for (String openId : openIds) {
				System.out.printf("open id : %s\n", openId);
			}
		}
		case "일괄삭제" -> {
			
			NoticeService service = new NoticeService();
			
			int[] ids = new int[delIds.length];
			
			for(int i = 0; i < delIds.length; i++) {
				ids[i] = Integer.parseInt(delIds[i]);
			}// for
			
			int result = service.deleteNoticeAll(ids);
			
		}
		}// switch
		
		resp.sendRedirect("list");
	}// doPost

}// end class
