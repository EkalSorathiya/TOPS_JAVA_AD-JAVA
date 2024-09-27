package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.attribute.standard.RequestingUserName;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {

	public static void registerUser(User u)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="insert into user1(fname,lname,email,mobile,password) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,u.getFname());
			pst.setString(2,u.getLname());
			pst.setString(3,u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5,u.getPassword());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from user1 where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,email);
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
			Connection conn=UserUtil.createConnection();
			String sql="select * from user1 where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getInt("id"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getLong("mobile"));
				user.setPassword(rs.getString("psaaword"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
