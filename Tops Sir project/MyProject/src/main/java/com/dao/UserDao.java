package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.util.ProjectUtil;

public class UserDao {

	public static void signupUser(User u)
	{
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="insert into user(fname,lname,email,mobile,address,password,usertype) values(?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getMobile());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getPassword());
			pst.setString(7, u.getUsertype());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="select * from user where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static User login(String email)
	{
		User user=null;
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="select * from user where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				user.setUsertype(rs.getString("usertype"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static void changePassword(String email,String password)
	{
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="update user set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
