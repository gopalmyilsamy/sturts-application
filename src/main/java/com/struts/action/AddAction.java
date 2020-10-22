package com.struts.action;

import com.struts.DbUtil;
import com.struts.dao.*;
import com.struts.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {
	String bookId;
	String bookName;
	String bookAuthor;
	Integer bookPrice;

	public String execute() {
		addBook();
		return "success";
	}

	public void addBook() {
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "insert into book(book_id,book_name,book_author,book_price) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookId);
			ps.setString(2, bookName);
			ps.setString(3, bookAuthor);
			ps.setInt(4, bookPrice);
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
