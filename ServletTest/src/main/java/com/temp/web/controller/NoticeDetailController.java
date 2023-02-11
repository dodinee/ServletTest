package com.temp.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.temp.web.Entity.Notice;
import com.temp.web.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
//모두 controller / view / model 로 분
//		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";
//		String sql = "SELECT * FROM SANREVIEW_TB where sanreview_cd=?";
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
//
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, id);
//
//			ResultSet rs = st.executeQuery();
//			rs.next();
//
//			
////			req.setAttribute("title", rs.getString("title"));
////			req.setAttribute("createdDt", rs.getTimestamp("created_dt"));
////			req.setAttribute("userCd", rs.getInt("user_cd"));
////			req.setAttribute("likeCnt", rs.getInt("like_cnt"));
////			req.setAttribute("contents", rs.getString("contents"));
//			// 자료화해서 관리하자 -> /Entity/Notice.class
//			
//			int cd = rs.getInt("sanreview_cd");
//			String title = rs.getString("title");
//			Timestamp createdDt = rs.getTimestamp("created_dt");
//			int userCd = rs.getInt("user_cd");
//			int likeCnt = rs.getInt("like_cnt");
//			String contents = rs.getString("contents");
//			
//			Notice notice = new Notice(cd, title, createdDt, userCd, likeCnt, contents);
			
			NoticeService service = new NoticeService();
			Notice notice = service.getNotice(id);
			req.setAttribute("n",  notice);
			
//			rs.close();
//			st.close();
//			con.close();
//
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}// try-catch
		
		//redirect : 아예 다른 페이지로 가기 		
		//forward : 작업 내용 이어받기 
		
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}
}
