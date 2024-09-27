<%@page import="com.dao.CartDao"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="zxx">

<head></head>

<body>
<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	Product p=ProductDao.getProducts(pid);
%>
        <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2><%=p.getProduct_name() %></h2>
                        <div class="breadcrumb__option">
                            <a href="./seller-index.jsp">Home</a>
                            <a href="./seller-index.jsp"><%=p.getProduct_category() %></a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="product_images/<%=p.getProduct_image() %>" alt="">
                        </div>
                        
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3><%=p.getProduct_name() %></h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(18 reviews)</span>
                        </div>
                        <div class="product__details__price"><%=p.getProduct_price() %></div>
                        <p><%=p.getProduct_desc() %></p>
                        <%
                        	if(user!=null)
                        	{
                        %>
                        		<%
                        			boolean cart_flag=CartDao.checkcart(p.getPid(), user.getUid());
                        			if(cart_flag==false)
                        			{
                        		%>
                        				<a href="add-to-cart.jsp?pid=<%=p.getPid()%>&uid=<%=user.getUid() %>" class="primary-btn">Add To Cart</a>
                        		<%
                        			}
                        			else
                        			{
                        		%>
                        				<a href="remove-from-cart.jsp?pid=<%=p.getPid()%>&uid=<%=user.getUid() %>" class="primary-btn">Remove From Cart</a>
                        		<%		
                        			}
                        		%>
                        		<%
                        			boolean wishlist_flag=WishlistDao.checkWishlist(p.getPid(), user.getUid());
                        			if(wishlist_flag==false)
                        			{
                        		%>
                        				<a href="add-to-wishlist.jsp?pid=<%=p.getPid()%>&uid=<%=user.getUid() %>" class="primary-btn">Add To Wishlist</a>
                        		<%
                        			}
                        			else
                        			{
                        		%>
                        				<a href="remove-from-wishlist.jsp?pid=<%=p.getPid()%>&uid=<%=user.getUid() %>" class="primary-btn">Remove From Wishlist</a>
                        		<%		
                        			}
                        		%>
                        <%
                        	}
                        	else
                        	{
                        %>
                        		<a href="login.jsp" class="primary-btn">Login</a>
                        <%		
                        	}
                        %>
                    </div>
                </div>
                      
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>


</body>

</html>