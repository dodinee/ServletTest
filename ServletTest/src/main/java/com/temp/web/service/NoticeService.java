package com.temp.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.temp.web.Entity.Notice;
import com.temp.web.Entity.NoticeView;

public class NoticeService {

	public List<NoticeView> getNoticeList() {

		return getNoticeList("title", "", 1);
	}

	public List<NoticeView> getNoticeList(int page) {

		return getNoticeList("title", "", page);
	}

	public List<NoticeView> getNoticeList(String field, String query, int page) {

		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, sanreview_view.* FROM sanreview_view WHERE "
				+ field + " LIKE ?) WHERE num BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";

		List<NoticeView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, (page - 1) * 5 + 1);
			st.setInt(3, page * 5);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int cd = rs.getInt("sanreview_cd");
				String title = rs.getString("title");
				Timestamp createdDt = rs.getTimestamp("created_dt");
				int userCd = rs.getInt("user_cd");
				int likeCnt = rs.getInt("like_cnt");
				String contents = rs.getString("contents");
				int reCnt = rs.getInt("re_cnt");

				NoticeView noticeV = new NoticeView(cd, title, createdDt, userCd, likeCnt, contents, reCnt);
				list.add(noticeV);
			} // while

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // try-catch

		return list;
	}
	/*
	 * SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY created_dt DESC) num,
	 * sanreview_tb.* FROM sanreview_tb) WHERE num between 2 and 4;
	 */

	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {

		String sql = "SELECT COUNT(sanreview_cd) cnt FROM (SELECT ROW_NUMBER() OVER(ORDER BY created_dt DESC) num, sanreview_tb.* FROM sanreview_tb WHERE "
				+ field + " LIKE ?)";
		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";

		int count = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			count = rs.getInt("cnt");

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // try-catch

		return count;
	}

	public Notice getNotice(int id) {

		String sql = "SELECT * FROM sanreview_view WHERE sanreview_cd=?";
		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";
		Notice notice = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();

			int cd = rs.getInt("sanreview_cd");
			String title = rs.getString("title");
			Timestamp createdDt = rs.getTimestamp("created_dt");
			int userCd = rs.getInt("user_cd");
			int likeCnt = rs.getInt("like_cnt");
			String contents = rs.getString("contents");

			notice = new Notice(cd, title, createdDt, userCd, likeCnt, contents);

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // try-catch

		return notice;
	}

	public Notice getNextNotice(int id) {

		String sql = """
				SELECT *
				FROM sanreview_tb
				WHERE sanreview_cd = (SELECT sanreview_cd FROM sanreview_tb
				WHERE created_dt > (SELECT created_dt FROM sanreview_tb WHERE sanreiview_cd=3)
				AND rownum = 1)
				""";
		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";
		Notice notice = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();

			int cd = rs.getInt("sanreview_cd");
			String title = rs.getString("title");
			Timestamp createdDt = rs.getTimestamp("created_dt");
			int userCd = rs.getInt("user_cd");
			int likeCnt = rs.getInt("like_cnt");
			String contents = rs.getString("contents");

			notice = new Notice(cd, title, createdDt, userCd, likeCnt, contents);

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // try-catch

		return notice;
	}

	public Notice getPrevNotice(int id) {

		String sql = """
				SELECT *
				FROM ( SELECT sanreview_cd FROM sanreview_tb ORDER BY created_dt DESC)
				WHERE sanreview_cd = (SELECT sanreview_cd FROM sanreview_tb
				WHERE created_dt < (SELECT created_dt FROM sanreview_tb WHERE sanreiview_cd=3)
				AND rownum = 1)
				""";

		String url = "jdbc:oracle:thin:@wegodb1_high?TNS_ADMIN=/Users/sowls/wallet/Wallet_wegodb1";
		Notice notice = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "admin", "Wego12345678");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();

			int cd = rs.getInt("sanreview_cd");
			String title = rs.getString("title");
			Timestamp createdDt = rs.getTimestamp("created_dt");
			int userCd = rs.getInt("user_cd");
			int likeCnt = rs.getInt("like_cnt");
			String contents = rs.getString("contents");

			notice = new Notice(cd, title, createdDt, userCd, likeCnt, contents);

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // try-catch

		return notice;
	}

}// end class
