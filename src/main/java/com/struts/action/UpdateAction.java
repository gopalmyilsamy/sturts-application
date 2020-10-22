package com.struts.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.DbUtil;
import com.struts.dao.BookManagementDAO;
import com.struts.pojo.Book;


public class UpdateAction extends ActionSupport{
	String bookId;
	String bookName;
	String bookAuthor;
	Integer bookPrice;
	
	
	public String execute() {
		updateBook();
		return "success";
	}
	
	public void updateBook() {
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "update book set book_name=?,book_author=?,book_price=? where book_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookName);
			ps.setString(2, bookAuthor);
			ps.setInt(3, bookPrice);
			ps.setString(4, bookId);
			
			int rows = ps.executeUpdate();
			DbUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
