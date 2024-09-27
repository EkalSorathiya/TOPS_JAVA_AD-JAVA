<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<style type="text/css">
	.bttnStyle
	{
		background-color: lightblue;
		border-radius: 0.50rem;
		border:1px solid transperent;
	}
</style>
</head>

<body>
    
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Organi Shop</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Home</a>
                            <span>Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 col-md-7">
                    
                   <%
                   		if(request.getAttribute("msg")!=null)
                   		{
                   			out.println(request.getAttribute("msg"));
                   		}
                   %>
                    <div class="row">
                    	<%
                    		int net_price=0;
                    		List<Cart> list=CartDao.getOrderUser(user.getUid());
                    		
                    		for(Cart c:list)
                    		{
                    			net_price=net_price+c.getTotal_price();
                    			Product p=ProductDao.getProducts(c.getPid());
                    	%>
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="product_images/<%=p.getProduct_image()%>">
                                    <ul class="product__item__pic__hover">
                                        
                                        <li><a href="product-details.jsp?pid=<%=p.getPid()%>"><i class="fa fa-info"></i></a></li>
                                        
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#"><%=p.getProduct_name() %></a></h6>
                                    <h5>Price : Rs. <%=c.getProduct_price() %></h5>
                                    <h5>Quantity : </h5>
                                    <form method="post" action="change_qty.jsp">
                                    	<input type="hidden" name="cid" value="<%=c.getCid()%>">
                                    	<input type="number" name="product_qty" value="<%=c.getProduct_qty()%>" min="1" max="10" readonly="readonly">
                                    </form>
                                    <h5>Total : Rs. <%=c.getTotal_price() %></h5>
                                </div>
                            </div>
                        </div>
                        <%
                    		}
                        %>
                        
                    </div>
                   
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

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

<script type="text/javascript">
	var xhttp=new XMLHttpRequest();
	var RazorpayOrderId;
	function CreateOrderID()
	{
		xhttp.open("GET","http://localhost:8080/MyProject/OrderCreation",false);
		xhttp.send();
		RazorpayOrderId=xhttp.responseText;
		OpenCheckOut();
	}
</script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript">
	
	
	function OpenCheckOut()
	{
		var amount=document.getElementById("amount").value;
		var new_amount=parseInt(amount)*100;
		var options={
				"key":"rzp_test_1ITQAMx0ytICH4",
				"amount":new_amount,
				"currency":"INR",
				"name":"Tops",
				"description":"Test",
				"callback_url":"http://localhost:8080/MyProject/index.jsp?id=<%=user.getUid()%>",
				"prefill":{
					"name":"Jigar Thakkar",
					"email":"jigar.thakkar.tops@gmail.com",
					"contact":"9377614772"
				},
				"notes":{
					"address":"Gandhinagar"
				},
				"theme":{
					"color":"#3399cc"
				}
				
				
		};
		var rzp1=new Razorpay(options);
		rzp1.on('payment.failed',function (response){
			alert(response.error.code);
	        alert(response.error.description);
	        alert(response.error.source);
	        alert(response.error.step);
	        alert(response.error.reason);
	        alert(response.error.metadata.order_id);
	        alert(response.error.metadata.payment_id);
		});
		rzp1.open();
	    e.preventDefault();
	}
</script>
</body>

</html>