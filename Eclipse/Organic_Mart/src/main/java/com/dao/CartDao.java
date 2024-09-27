package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Cart;
import com.bean.Wishlist;
import com.util.ProjectUtil;

public class CartDao {
		
	public static void addToCart(Cart c)
	{
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="insert into cart(pid,uid,product_price,product_qty,total_price) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getUid());
			pst.setInt(3, c.getProduct_price());
			pst.setInt(4, c.getProduct_qty());
			pst.setInt(5, c.getTotal_price());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static List<Cart> getCartByUser(int uid)
	{
		String payment_status="false";
		List<Cart> list=new ArrayList<>();
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="select * from cart where uid=? and payment_status=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.setString(2, payment_status);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Cart cart=new Cart();
				cart.setCid(rs.getInt("cid"));
				cart.setPid(rs.getInt("pid"));
				cart.setUid(rs.getInt("uid"));
				cart.setProduct_price(rs.getInt("product_price"));
				cart.setProduct_qty(rs.getInt("product_qty"));
				cart.setTotal_price(rs.getInt("total_price"));
				cart.setPayment_status(rs.getString("payment_status"));
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Cart> getOrderUser(int uid)
	{
		String payment_status="true";
		List<Cart> list=new ArrayList<>();
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="select * from cart where uid=? and payment_status=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.setString(2, payment_status);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Cart cart=new Cart();
				cart.setCid(rs.getInt("cid"));
				cart.setPid(rs.getInt("pid"));
				cart.setUid(rs.getInt("uid"));
				cart.setProduct_price(rs.getInt("product_price"));
				cart.setProduct_qty(rs.getInt("product_qty"));
				cart.setTotal_price(rs.getInt("total_price"));
				cart.setPayment_status(rs.getString("payment_status"));
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Cart getCart(int cid)
	{
		Cart cart=null;
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="select * from cart where cid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				cart=new Cart();
				cart.setCid(rs.getInt("cid"));
				cart.setPid(rs.getInt("pid"));
				cart.setUid(rs.getInt("uid"));
				cart.setProduct_price(rs.getInt("product_price"));
				cart.setProduct_qty(rs.getInt("product_qty"));
				cart.setTotal_price(rs.getInt("total_price"));
				cart.setPayment_status(rs.getString("payment_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public static void updateQty(Cart c)
	{
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="update cart set product_qty=?,total_price=? where cid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, c.getProduct_qty());
			pst.setInt(2, c.getTotal_price());
			pst.setInt(3, c.getCid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCartStatus(int cid)
	{
		String paymenty_status="true";
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="update cart set payment_status=? where cid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setString(1, paymenty_status);
			pst.setInt(2, cid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkCart(int pid,int uid)
	{
		boolean flag=false;
		String payment_status="false";
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from cart where pid=? and uid=? and payment_status=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, uid);
			pst.setString(3, payment_status);
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
	
	public static void removeFromCart(Cart w)
	{
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="delete from cart where pid=? and uid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, w.getPid());
			pst.setInt(2, w.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}