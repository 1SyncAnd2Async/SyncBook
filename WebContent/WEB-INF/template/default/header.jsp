<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body class="boxed-layout container">
	<!--=== Header ===-->
    <div class="header">
        <div class="container">
            <!-- Logo -->
            <a class="logo" href="index">
                <img src="resources/assets/img/logo1-default.png" alt="Logo">
            </a>
            <!-- End Logo -->

            <!-- Topbar -->
            <div class="topbar">
                <ul class="loginbar pull-right">
                    <c:choose>
                    	<c:when test="${sessionScope.member == null}">
                    		<li><a href="loginForm">Login</a></li>
                    		<li class="topbar-devider"></li>
                    		<li><a href="joinForm">Join</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li><a href="myPageForm">${sessionScope.member.id}</a></li> 님 환영합니다.
                    		<li class="topbar-devider"></li>
                    		<li><a href="logout">Logout</a></li>
                    	</c:otherwise>
                    </c:choose>
                    <li class="topbar-devider"></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </div>
            <!-- End Topbar -->

            <!-- Toggle get grouped for better mobile display -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="fa fa-bars"></span>
            </button>
            <!-- End Toggle -->
        </div><!--/end container-->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
            <div class="container">
                <ul class="nav navbar-nav">
                	<!-- Member Management -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	회원관리
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-submenu">
                                <a href="#">회원목록</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Member Management -->
                    
                    <!-- Member Management -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	과목
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-submenu">
                                <a href="subject">과목관리</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Member Management -->
                
                	<c:choose>
                	<c:when test="${sessionScope.member != null}">
                	<!-- My Books -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	내 교재
                        </a>
                        <ul class="dropdown-menu">
                            <!-- Authentication Pages -->
                            <li>
                                <a href="authentic">교재인증</a>
                            </li>
                            <!-- End Authentication Pages -->
                            
                            <!-- My Books List Pages -->
                            <li class="dropdown-submenu">
                                <a href="javascript:void(0);">교재목록</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">TOEIC 700+</a></li>
                                    <li><a href="#">Bootstrap</a></li>
                                    <li><a href="#">Spring Framework</a></li>
                                    <li><a href="#">jQuery</a></li>
                                    <li><a href="#">Ajax</a></li>
                                </ul>
                            </li>
                            <!-- End My Books List Pages -->
                        </ul>
                    </li>
                    <!-- End My Books -->
                    </c:when>
                	</c:choose>
                	
                    <!-- Books -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	교재
                        </a>
                        <ul class="dropdown-menu">
                        	<!-- Books List Pages -->
                            <li>
                                <a href="bookList">교재목록</a>
                            </li>
                            <!-- End Books List Pages -->
                            <!-- Category Pages -->
                            <li class="dropdown-submenu">
                                <a href="javascript:void(0);">북 카테고리</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">영어수험서</a></li>
                                    <li><a href="#">영어단행본</a></li>
                                    <li><a href="#">초,중,고</a></li>
                                    <li><a href="#">일본어</a></li>
                                    <li><a href="#">학원교재</a></li>
                                </ul>
                            </li>
                            <!-- End Category Pages -->
                            
                            <!-- New Books Pages -->
                            <li>
                                <a href="#">신간도서</a>
                            </li>
                            <!-- End New Books Pages -->
                            
                            <!-- Best Seller Pages -->
                            <li>
                                <a href="#">베스트셀러</a>
                            </li>
                            <!-- End Best Seller Pages -->
                        </ul>
                    </li>
                    <!-- End Books -->
                    
                    <!-- Community -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	커뮤니티
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                            	<a href="noticeList">공지사항</a>
                                <a href="#">교재후기</a>
                                <a href="#">자유게시판</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Community -->
                    
                    <!-- Customer Support -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	고객지원
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">FAQ</a>
                                <a href="#">자료실</a>
                                <a href="#">고객문의</a>
                                <a href="#">이용안내</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Customer Support -->
                    
                    <!-- Search Block -->
                    <li>
                        <i class="search fa fa-search search-btn"></i>
                        <div class="search-open">
                            <div class="input-group animated fadeInDown">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                                    <button class="btn-u" type="button">Go</button>
                                </span>
                            </div>
                        </div>
                    </li>
                    <!-- End Search Block -->
                </ul>
            </div><!--/end container-->
        </div><!--/navbar-collapse-->
    </div>
    <!--=== End Header ===-->