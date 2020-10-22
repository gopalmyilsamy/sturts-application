package com.struts.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.struts.DbUtil;
import com.struts.dao.BookManagementDAO;

public class DeleteAction {

	String bookId;
	
	public String execute() {
		deleteBook();
		return "success";
	}
	
	public void deleteBook() {
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "delete from book where book_id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bookId);
			int rows = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
}
