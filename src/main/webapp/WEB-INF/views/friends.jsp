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
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/assets/img/lin.png" />

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/ace-ie.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script
	src="<%=request.getContextPath()%>/resources/assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="<%=request.getContextPath()%>/resources/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath()%>/resources/assets/js/respond.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default    navbar-collapse">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

		<div class="navbar-container" id="navbar-container">

			<div class="navbar-header pull-center-left">
				<img width=120 height=60
					src="<%=request.getContextPath()%>/resources/assets/img/in.png" />

			</div>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">


				<!-- #section:basics/navbar.layout.brand -->
				<a href="${linkedinURL}"
					class="navbar-brand"> <small> Redirect to Linkedin
						profile of ${name} </small>
				</a>

				<!-- /section:basics/navbar.layout.brand -->



				<!-- /section:basics/navbar.toggle -->
			</div>

			<!-- #section:basics/navbar.dropdown -->
			<div
				class="navbar-buttons navbar-header pull-right  collapse navbar-collapse"
				role="navigation">
				<ul class="nav ace-nav">

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <span class="user-info"> <small>Welcome,</small>
								${name}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">


							<li><a href="<%=request.getContextPath()%>/login"> <i
									class="ace-icon fa fa-power-off"></i> Return to profiles choice
							</a></li>
						</ul></li>

					<!-- /section:basics/navbar.user_menu -->
				</ul>
			</div>

			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<br> <img width=150 height=150 
					src="${linkedinPicture}" /> <br>
					<font color="Green" size="2">${situation}</font>
					<br>
					<br>
					<font color="Black" size="4"><u>Relation with others</u></font>
				<br>
				<br>
				<c:forEach items="${mentionedProfessionals}" var="mp"> 
				<ul>
					<li><font color="Grey" size="3">${mp.name}</font> <font color="Blue" size="2">${mp.degree}</font><font color="red" size="2"> ${mp.sameUniversity}</font> <font color="red" size="2"> ${mp.workedInSameCompany}</font> </li>
						</font>
						<br>

					</ul>
						
				</c:forEach>

			</div>
			<!-- /.sidebar-shortcuts -->


		</div>

		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">


					<!-- /section:settings.box -->
					<div class="page-header">
						<h1>Friends of ${name}</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="hidden">
								<div id="sidebar2"
									class="sidebar h-sidebar navbar-collapse collapse">
									<ul class="nav nav-list">


										 <li class="hover">
												<a  href="<%=request.getContextPath()%>/research">
														<h4>Establish a research</h4></a>
											</li>





									<li class="hover">
										<a  href="#">
										<span class="menu-text">
												<h4>Profile</h4>
											</span>	
</a>
												<ul class="submenu">
													<li class="hover">
														<a href="<%=request.getContextPath()%>/generalInformations">
															<i class="menu-icon fa fa-caret-right"></i>
															General informations
														</a>

														<b class="arrow"></b>
													</li>

													<li class="hover">
														<a href="<%=request.getContextPath()%>/educations">
															<i class="menu-icon fa fa-caret-right"></i>
															Educations
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/skills">
															<i class="menu-icon fa fa-caret-right"></i>
															Skills
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/languages">
															<i class="menu-icon fa fa-caret-right"></i>
															Languages
														</a>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/currentPosts">
															<i class="menu-icon fa fa-caret-right"></i>
															Current Posts
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/pastPosts">
															<i class="menu-icon fa fa-caret-right"></i>
															Past Posts
														</a>

														<b class="arrow"></b>
													</li>
													
														<li class="hover">
														<a href="<%=request.getContextPath()%>/projects">
															<i class="menu-icon fa fa-caret-right"></i>
															Projects
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/certifications">
															<i class="menu-icon fa fa-caret-right"></i>
															Certfications
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/recommandedVisitors">
															<i class="menu-icon fa fa-caret-right"></i>
															Recommanded visitors
														</a>

														<b class="arrow"></b>
													</li>
													
													<li class="hover">
														<a href="<%=request.getContextPath()%>/friends">
															<i class="menu-icon fa fa-caret-right"></i>
															Friends
														</a>

														<b class="arrow"></b>
													</li>
													
														<li class="hover">
														<a href="<%=request.getContextPath()%>/groups">
															<i class="menu-icon fa fa-caret-right"></i>
															Groups
														</a>

														<b class="arrow"></b>
													</li>

													
												</ul>

										 </li>	
									

							
			
											
									
										</ul><!-- /.nav-list -->
									</div><!-- .sidebar -->
								</div>	





							<div class="col-xs-12">
								<c:forEach items="${allFriends}" var="fr">

									<form class="form-horizontal">
										<!-- #section:elements.form -->
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"
												for="form-field-1"> Name </label>

											<div class="col-sm-9">
												<input type="text" id="form-field-1" value="${fr.name}"
													class="col-xs-10 col-sm-5" disabled>
											</div>
										</div>
									</form>
									<br>
									<br>
									
								</c:forEach>






							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.page-content -->
				</div>
			</div>
			<!-- /.main-content -->

		</div>
		<!-- /.main-container -->

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
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>
			/resources/assets/js/jquery.mobile.custom.js'>"
								+ "<"+"/script>");
		</script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/bootstrap.js"></script>

		<!-- page specific plugin scripts -->
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/jquery.bootstrap-duallistbox.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/jquery.raty.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/bootstrap-multiselect.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/select2.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/typeahead.jquery.js"></script>

		<!-- ace scripts -->
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.scroller.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.colorpicker.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.fileinput.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.typeahead.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.wysiwyg.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.spinner.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.treeview.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.wizard.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.aside.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.ajax-content.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.touch-drag.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.sidebar.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.submenu-hover.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.widget-box.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.settings.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.settings-rtl.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.settings-skin.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.widget-on-reload.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.searchbox-autocomplete.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				var demo1 = $('select[name="duallistbox_demo1[]"]')
						.bootstrapDualListbox(
								{
									infoTextFiltered : '<span class="label label-purple label-lg">Filtered</span>'
								});
				var container1 = demo1.bootstrapDualListbox('getContainer');
				container1.find('.btn').addClass('btn-white btn-info btn-bold');

				/**var setRatingColors = function() {
					$(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
					$(this).find('.star-off-png').removeClass('orange2').addClass('grey');
				}*/
				$('.rating').raty({
					'cancel' : true,
					'half' : true,
					'starType' : 'i'
				/**,
				
				'click': function() {
					setRatingColors.call(this);
				},
				'mouseover': function() {
					setRatingColors.call(this);
				},
				'mouseout': function() {
					setRatingColors.call(this);
				}*/
				})//.find('i:not(.star-raty)').addClass('grey');

				//////////////////
				//select2
				$('.select2').css('width', '200px').select2({
					allowClear : true
				})
				$('#select2-multiple-style .btn').on('click', function(e) {
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if (which == 2)
						$('.select2').addClass('tag-input-style');
					else
						$('.select2').removeClass('tag-input-style');
				});

				//////////////////
				$('.multiselect')
						.multiselect(
								{
									enableFiltering : true,
									buttonClass : 'btn btn-white btn-primary',
									templates : {
										button : '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
										ul : '<ul class="multiselect-container dropdown-menu"></ul>',
										filter : '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
										filterClearBtn : '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
										li : '<li><a href="javascript:void(0);"><label></label></a></li>',
										divider : '<li class="multiselect-item divider"></li>',
										liGroup : '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
									}
								});

				///////////////////

				//typeahead.js
				//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
				var substringMatcher = function(strs) {
					return function findMatches(q, cb) {
						var matches, substringRegex;

						// an array that will be populated with substring matches
						matches = [];

						// regex used to determine if a string contains the substring `q`
						substrRegex = new RegExp(q, 'i');

						// iterate through the pool of strings and for any string that
						// contains the substring `q`, add it to the `matches` array
						$.each(strs, function(i, str) {
							if (substrRegex.test(str)) {
								// the typeahead jQuery plugin expects suggestions to a
								// JavaScript object, refer to typeahead docs for more info
								matches.push({
									value : str
								});
							}
						});

						cb(matches);
					}
				}

				$('input.typeahead').typeahead({
					hint : true,
					highlight : true,
					minLength : 1
				}, {
					name : 'states',
					displayKey : 'value',
					source : substringMatcher(ace.vars['US_STATES'])
				});

				///////////////

				//in ajax mode, remove remaining elements before leaving page
				$(document).one(
						'ajaxloadstart.page',
						function(e) {
							$('[class*=select2]').remove();
							$('select[name="duallistbox_demo1[]"]')
									.bootstrapDualListbox('destroy');
							$('.rating').raty('destroy');
							$('.multiselect').multiselect('destroy');
						});

			});

			jQuery(function($) {
				$('#sidebar2').insertBefore('.page-content');

				$('.navbar-toggle[data-target="#sidebar2"]').insertAfter(
						'#menu-toggler');

				$(document).on('settings.ace.two_menu',
						function(e, event_name, event_val) {
							if (event_name == 'sidebar_fixed') {
								if ($('#sidebar').hasClass('sidebar-fixed')) {
									$('#sidebar2').addClass('sidebar-fixed');
									$('#navbar').addClass('h-navbar');
								} else {
									$('#sidebar2').removeClass('sidebar-fixed')
									$('#navbar').removeClass('h-navbar');
								}
							}
						}).triggerHandler(
						'settings.ace.two_menu',
						[ 'sidebar_fixed',
								$('#sidebar').hasClass('sidebar-fixed') ]);
			})
		</script>

		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/resources/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="../docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript">
			ace.vars['base'] = '..';
		</script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/elements.onpage-help.js"></script>
		<script
			src="<%=request.getContextPath()%>/resources/assets/js/ace/ace.onpage-help.js"></script>
		<script src="../docs/assets/js/rainbow.js"></script>
		<script src="../docs/assets/js/language/generic.js"></script>
		<script src="../docs/assets/js/language/html.js"></script>
		<script src="../docs/assets/js/language/css.js"></script>
		<script src="../docs/assets/js/language/javascript.js"></script>
</body>
</html>
