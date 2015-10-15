<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<!--=== Header ===-->
    <div class="header">
        <div class="container">
            <!-- Logo -->
            <a class="logo" href="index">
                <img src="resources/assets/img/syncbook.png" alt="Logo">
            </a>
            <!-- End Logo -->

            <!-- Topbar -->
            <div class="topbar">
                <ul class="loginbar pull-right">
                    <c:choose>
                    	<c:when test="${!empty sessionScope.teacher}">
                    		<li><a href="teacherPageForm?teacher_id=${sessionScope.teacher.id}" id="teacher">${sessionScope.teacher.id}</a></li> 님 환영합니다.
                    		<li class="topbar-devider"></li>
                    		<li><a href="teacherLogout">Logout</a></li>
                    	</c:when>
                    	<c:when test="${!empty sessionScope.member}">
                    		<li><a href="myPageForm?member_id=${sessionScope.member.id}" id="member">${sessionScope.member.id}</a></li> 님 환영합니다.
                    		<li class="topbar-devider"></li>
                    		<li><a href="logout">Logout</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li><a href="loginOption">Login</a></li>
                    		<li class="topbar-devider"></li>
                    		<li><a href="joinOption">Join</a></li>
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
                	<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	회원관리
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-submenu">
                                <a href="memberList">회원목록</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Member Management -->
                    <!-- Order Management -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	주문관리
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-submenu">
                                <a href="orderList">주문목록</a>
                            </li>
                        </ul>
                    </li>
                    <!-- End Order Management -->
                    
                    <!-- Member Management -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	관리
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-submenu">
                                <a href="subject">과목관리</a>
                            </li>
                            <li class="dropdown-submenu">
                                <a href="javascript:void(0);">교재관리</a>
                                <ul class="dropdown-menu">
                                    <li><a href="book">교재등록</a></li>
                                    <li><a href="questionForm">문제등록</a></li>
                                </ul>
                            </li>
                            <li class="dropdown-submenu">
                                <a href="javascript:void(0);">수업관리</a>
                                <ul class="dropdown-menu">
                                    <li><a href="addLectureForm">수업등록</a></li>
                                    <li><a href="assignLectureForm?page=1">수업배정</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    </c:when>
                    </c:choose>
                    <!-- End Member Management -->
                
                	
                	<!-- My Books -->
                	<c:choose>
                		<c:when test="${sessionScope.member.id != null}">
	                    <li class="dropdown">
	                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
	                            	내 강의
	                        </a>
	                        <ul class="dropdown-menu">
	                            <!-- Authentication Pages -->
	                            <li>
	                            	<a href="memberClassList?id=${sessionScope.member.id}">수강목록</a>
	                            </li>
	                        </ul>
	                       </li>
                           </c:when>
                           <c:when test="${sessionScope.teacher.id != null}">
                           <li class="dropdown">
	                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
	                            	내 강의
	                        </a>
	                        <ul class="dropdown-menu">
	                            <!-- Authentication Pages -->
	                            <li>
                               		<a href="memberClassList?id=${sessionScope.teacher.id}">강의목록</a>                               	
                            	</li>
                            <!-- End Authentication Pages -->
	                        	</ul>
	                    		</li>
                    		</c:when>
                			</c:choose>
                    <!-- End My Books -->
                    
                	
                    <!-- Books -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	학습
                        </a>
                        <ul class="dropdown-menu">
                        	<!-- Books List Pages -->
                            <li>
                                <a href="classListForm?page=1">학습신청</a>
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
                                <a href="reviewList">수강후기</a>
                                <a href="qnaList">Q & A</a>
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
                                <a href="faqList">FAQ</a>
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
    <div class="bg-image-v2 parallaxBg1">
    <!--=== End Header ===-->