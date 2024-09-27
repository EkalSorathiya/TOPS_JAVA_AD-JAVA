package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Wishlist;
import com.util.ProjectUtil;

public class WishlistDao {
	
	public static void addToWishlist(Wishlist w) 
	{
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="insert into wishlist(pid,uid) values(?,?)";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static List<Wishlist> getWishlistByUser(int uid) 
	{
		List<Wishlist> list=new ArrayList<>();
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from wishlist where uid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Wishlist wishlist=new Wishlist();
				wishlist.setWid(rs.getInt("wid"));
				wishlist.setUid(rs.getInt("uid"));
				wishlist.setPid(rs.getInt("pid"));
				list.add(wishlist);
			}

		} catch (Exception e) {
			e.addSuppressed(e);
		}
		return list;
	}
	
	public static boolean checkWishlist(int pid,int uid)
	{
		boolean flag=false;
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from wishlist where pid=? and uid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, uid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}

		} catch (Exception e) {
			e.addSuppressed(e);
		}
		return flag;
	}
	
	public static void removeFromWishlist(Wishlist w)
	{
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="delete from wishlist where pid=? and uid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
