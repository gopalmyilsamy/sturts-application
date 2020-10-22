package com.struts.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.struts.DbUtil;

public class LoginAction {

	String userName;
	String password;

	public String execute() {
		if(isValidUser()) {
			return "success";
		}else
		{
			return "input";
		}

	}

	public boolean isValidUser() {
		boolean isAuthorizedUser = false;
		try {
			Connection conn = DbUtil.getConnection();

			String sql = "select user_name,password from user where user_name='" + userName + "' and password='"+password+"'";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			if (rs.next()) {
				isAuthorizedUser = true;
			}
			DbUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAuthorizedUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
