<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function() {
	ajaxFn();
	ajaxSubject();
});

var ajaxSubject = function(){
	$.ajax({
		url: "assignSubject",
		success:function(data) {
		$("#subject").html(data);
		}, error:function() {
		}
	});
}

var ajaxFn = function () {
	if($('#memberId').val() != null){
		$.ajax({
			url: "messageNotification",
			data: "id=" + $('#memberId').val(),
			success:function(data) {
			$("#notReadMessage").html(data);
			setTimeout(ajaxFn, 10000);
			}, error:function() {
			}
		});
	}else if($('#teacherId').val() != null){
		$.ajax({
			url: "messageNotification",
			data: "id=" + $('#teacherId').val(),
			success:function(data) {
			$("#notReadMessage").html(data);
			setTimeout(ajaxFn, 10000);
			}, error:function() {
			}
		});
		
	}
};
</script>
<body>
	<!--=== Header ===-->
    <div class="header">
        <div class="container">
            <!-- Logo -->
            <a class="logo" href="index">
                <img src="resources/assets/img/logo.png" alt="Logo">
            </a>
            <!-- End Logo -->

            <!-- Topbar -->
            <div class="topbar">
               <!-- <ul class="loginbar pull-right"> -->
              
               
                <ul class="list-inline badge-lists badge-icons margin-bottom-30" style="float:right!important; margin-top:10px;">
                    <c:choose>
                    	<c:when test="${!empty sessionScope.teacher}">
                    		<input type="hidden" id="teacherId" value="${sessionScope.teacher.id}">
                    		<li><a href="teacherPageForm" id="teacher">${sessionScope.teacher.name}</a></li> 님 환영합니다.
                    		<li><a href="messageList?page=1&receiver=${sessionScope.teacher.id}">
                    		 <i class="fa fa-envelope"></i>
                                    <span id="notReadMessage" class="badge badge-red rounded-x"></span></a></li>
                    		<li class="topbar-devider"></li>                    		
                    		<li><a href="teacherLogout">Logout</a></li>
                    		
                    	</c:when>
                    	<c:when test="${!empty sessionScope.member}">
                    		<input type="hidden" id="memberId" value="${sessionScope.member.id}">
                    		<li><a href="myPageForm?member_id=${sessionScope.member.id}" id="member">${sessionScope.member.name}</a></li> 님 환영합니다.
                    		
                    		<li><a href="messageList?page=1&receiver=${sessionScope.member.id}">
                    		 <i class="fa fa-envelope"></i>
                                    <span id="notReadMessage" class="badge badge-red rounded-x"></span></a></li>
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
                   
                    
                    <!-- Member Management -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            	관리
                        </a>
                        <ul class="dropdown-menu">
                        	 <li class="dropdown-submenu">
		                        <a href="javascript:void(0);">
		                            	회원관리
		                        </a>
		                        <ul class="dropdown-menu">
		                            <li>
		                                <a href="memberList?page=1">회원목록</a>
		                            </li>
		                        </ul>
		                    </li>
                        	 <li class="dropdown-submenu">
		                        <a href="javascript:void(0);">
		                            	주문관리
		                        </a>
		                        <ul class="dropdown-menu">
		                            <li>
		                                <a href="orderList?page=1">주문목록</a>
		                            </li>
		                        </ul>
		                    </li>
		                    
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
                            	학습신청
                        </a>
                        <ul class="dropdown-menu" id="subject">
                            
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
                            	<a href="noticeList?page=1">공지사항</a>
                                <a href="reviewList?page=1">수강후기</a>
                                <a href="qnaList?page=1">Q & A</a>
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
                                <a href="faqList?page=1">FAQ</a>
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