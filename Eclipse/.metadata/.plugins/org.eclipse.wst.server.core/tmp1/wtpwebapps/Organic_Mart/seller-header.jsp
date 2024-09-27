<%@page import="com.bean.User"%>
<%@page import="org.apache.tomcat.jni.*"%>
<%@page import="org.apache.catalina.*"%>
<%@page import="com.bean.*"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
       

    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <%
                            	User user=null;
                            	if(session!=null)
                            	{
                            		if(session.getAttribute("user")!=null)
                            		{
                            			user=(User)session.getAttribute("user");
                            %>
                            			<div class="header__top__right__auth">
			                                <a href="seller-change-password.jsp"><i class="fa fa-edit"></i>Change Password</a>
			                            </div>
                            			<div class="header__top__right__auth">
			                                <a href="logout.jsp"><i class="fa fa-user"></i> Logout</a>
			                            </div>
                            <%
                            		}
                            		else
                            		{
                  			%>
                  						<div class="header__top__right__auth">
			                                <a href="signup.jsp"><i class="fa fa-user"></i> Sign Up</a>
			                            </div>
			                            
			                            <div class="header__top__right__auth">
			                                <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
			                            </div>
                  			<%
                            		}
                            	}
                            	
                            %>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="seller-index.jsp">Home</a></li>
                            <li><a href="seller-add-product.jsp">Add Product</a></li>
                            <li><a href="seller-view-product.jsp">View Product</a></li>
                            
                        </ul>
                    </nav>
                </div>
                
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    
    
</body>

</html>