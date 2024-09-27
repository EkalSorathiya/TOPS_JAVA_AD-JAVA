package com.controller;

import java.io.File;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.Product;
import com.dao.ProductDao;

@WebServlet("/ProductController")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512) // 512MB

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);//form-data; name="product_image"; filename="shoes1.jpg"
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("add product"))
		{
			String savePath = "F:\\Tops\\Eclipse\\MyProject\\src\\main\\webapp\\product_images";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("product_image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "F:\\Tops\\Eclipse\\MyProject\\src\\main\\webapp\\product_images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        Product p=new Product();
	        p.setUid(Integer.parseInt(request.getParameter("uid")));
	        p.setProduct_category(request.getParameter("product_category"));
	        p.setProduct_name(request.getParameter("product_name"));
	        p.setProduct_desc(request.getParameter("product_desc"));
	        p.setProduct_image(fileName);
	        p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
	        ProductDao.addProduct(p);
	        request.setAttribute("msg", "Product Added Successfully");
	        request.getRequestDispatcher("seller-add-product.jsp").forward(request,response);
		}
		else if(action.equalsIgnoreCase("update product"))
		{
			Product p=new Product();
			p.setPid(Integer.parseInt(request.getParameter("pid")));
	        p.setUid(Integer.parseInt(request.getParameter("uid")));
	        p.setProduct_category(request.getParameter("product_category"));
	        p.setProduct_name(request.getParameter("product_name"));
	        p.setProduct_desc(request.getParameter("product_desc"));
	        p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
	        ProductDao.updateProduct(p);
	        request.setAttribute("msg", "Product Updated Successfully");
	        request.getRequestDispatcher("seller-view-product.jsp").forward(request,response);
		}
	}	
}
