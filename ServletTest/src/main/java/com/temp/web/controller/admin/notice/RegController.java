package com.temp.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.temp.web.Entity.Notice;
import com.temp.web.service.NoticeService;


@MultipartConfig(location="/tmp", fileSizeThreshold = 1024*1024, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*50*5)
//절대경로 |  | 하나의 파일 사이즈 제한 | 한번에 보내는 파일 사이즈 제한 (byte)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String isOpen= req.getParameter("open");

		Part filePart = req.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		InputStream fis = filePart.getInputStream();
		
		String realPath = req.getServletContext().getRealPath("/upload");
		String filePath = realPath + File.separator + fileName;
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		int size;
		
		while((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}// while
		
		fos.close();
		fis.close();
		
		boolean pub = false;
		if(isOpen != null) pub = true;
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContents(content);
		notice.setPub(pub);
		notice.setUserCd(3);
		
		NoticeService service = new NoticeService();
//		service.insertNotice(notice);
		
		resp.sendRedirect("list");
		
	}// doPost
	
}// end class
