package com.struts.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.struts.DbUtil;
import com.struts.dao.BookManagementDAO;
import com.struts.pojo.Book;


public class BooksAction {

	List<Book> books=new ArrayList() ;
	
	public String execute() {
		getBookList();
		return "success";
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void getBookList() {
		try {
			Connection conn = DbUtil.getConnection();

			String sql = "select book_id,book_name,book_author,book_price from book";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getString(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookPrice(rs.getInt(4));
				books.add(book);
			}
			DbUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
