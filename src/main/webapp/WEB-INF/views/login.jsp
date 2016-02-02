<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Linkedin</title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/assets/img/lin.png"/>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-part2.css" />
		<![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-rtl.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-ie.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="<%=request.getContextPath()%>/resources/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath()%>/resources/assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
										&nbsp &nbsp &nbsp &nbsp <img width=250 height=50
						src="<%=request.getContextPath()%>/resources/assets/img/linkedin.png" />
											<h4 class="header blue lighter bigger">
											
												Please select a profile
											</h4>

											<div class="space-6"></div>

											<form action="<%=request.getContextPath()%>/findProfileWithName" method="GET">
												<fieldset>
													<div class="form-group">
													
                                            <label class="col-sm-3 control-label no-padding-top">Name : &nbsp </label>
											<div class="col-sm-8">
                                            <select name="profileName" required>
                                             <c:forEach items="${allNames}" var="nm">
                                                <option>${nm}</option>
                                             </c:forEach>   
                                            </select>
											</div>
                                      

													<br> <br> <br> <br> 

													<div class="clearfix">
														

														<button type="submit" class="btn btn-outline btn btn-blue btn-primary btn-lg btn-block">
															Visit profile
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											
										</div><!-- /.widget-main -->

										
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

								

							
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resources/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath()%>/resources/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/resources/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
		</script>
	</body>
</html>
