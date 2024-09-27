package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.util.ProjectUtil;

public class ProductDao {

	public static void addProduct(Product p)
	{
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="insert into product(uid,product_category,product_name,product_price,product_desc,product_image) values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getUid());
			pst.setString(2, p.getProduct_category());
			pst.setString(3, p.getProduct_name());
			pst.setInt(4, p.getProduct_price());
			pst.setString(5, p.getProduct_desc());
			pst.setString(6, p.getProduct_image());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Product> getProductsBySeller(int uid)
	{
		List<Product> list=new ArrayList<>();
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from product where uid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rSet=pst.executeQuery();
			while(rSet.next())
			{
				Product p=new Product();
				p.setPid(rSet.getInt("pid"));
				p.setUid(rSet.getInt("uid"));
				p.setProduct_category(rSet.getString("product_category"));
				p.setProduct_name(rSet.getString("product_name"));
				p.setProduct_desc(rSet.getString("product_desc"));
				p.setProduct_price(rSet.getInt("product_price"));
				p.setProduct_image(rSet.getString("product_image"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Product getProducts(int pid)
	{
		Product p=null;
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from product where pid=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rSet=pst.executeQuery();
			if(rSet.next())
			{
				p=new Product();
				p.setPid(rSet.getInt("pid"));
				p.setUid(rSet.getInt("uid"));
				p.setProduct_category(rSet.getString("product_category"));
				p.setProduct_name(rSet.getString("product_name"));
				p.setProduct_desc(rSet.getString("product_desc"));
				p.setProduct_price(rSet.getInt("product_price"));
				p.setProduct_image(rSet.getString("product_image"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public static void updateProduct(Product p) {
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="update product set product_category=?,product_name=?,product_desc=?,product_price=? where pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_category());
			pst.setString(2, p.getProduct_name());
			pst.setInt(4, p.getProduct_price());
			pst.setString(3, p.getProduct_desc());
			pst.setInt(5, p.getPid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteProduct(int pid) {
		try {
			Connection conn=ProjectUtil.createConnection();
			String sql="delete from product where pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static List<Product> getAllProducts()
	{
		List<Product> list=new ArrayList<>();
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from product";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rSet=pst.executeQuery();
			while(rSet.next())
			{
				Product p=new Product();
				p.setPid(rSet.getInt("pid"));
				p.setUid(rSet.getInt("uid"));
				p.setProduct_category(rSet.getString("product_category"));
				p.setProduct_name(rSet.getString("product_name"));
				p.setProduct_desc(rSet.getString("product_desc"));
				p.setProduct_price(rSet.getInt("product_price"));
				p.setProduct_image(rSet.getString("product_image"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<Product> getAllVegetables()
	{
		String product_category="vegetables";
		List<Product> list=new ArrayList<>();
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from product where product_category=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setString(1, product_category);
			ResultSet rSet=pst.executeQuery();
			while(rSet.next())
			{
				Product p=new Product();
				p.setPid(rSet.getInt("pid"));
				p.setUid(rSet.getInt("uid"));
				p.setProduct_category(rSet.getString("product_category"));
				p.setProduct_name(rSet.getString("product_name"));
				p.setProduct_desc(rSet.getString("product_desc"));
				p.setProduct_price(rSet.getInt("product_price"));
				p.setProduct_image(rSet.getString("product_image"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<Product> getAllFruits()
	{
		String product_category="fruits";
		List<Product> list=new ArrayList<>();
		try {
			Connection connection=ProjectUtil.createConnection();
			String sql="select * from product where product_category=?";
			PreparedStatement pst=connection.prepareStatement(sql);
			pst.setString(1, product_category);
			ResultSet rSet=pst.executeQuery();
			while(rSet.next())
			{
				Product p=new Product();
				p.setPid(rSet.getInt("pid"));
				p.setUid(rSet.getInt("uid"));
				p.setProduct_category(rSet.getString("product_category"));
				p.setProduct_name(rSet.getString("product_name"));
				p.setProduct_desc(rSet.getString("product_desc"));
				p.setProduct_price(rSet.getInt("product_price"));
				p.setProduct_image(rSet.getString("product_image"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
