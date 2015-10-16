<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">Blank Page</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="#">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	<div class="row">
        	<div class="col-md-12">
            	<div class="headline"><h2>내 강의 목록</h2></div>

                <!-- Clients Block-->
                <c:forEach var="classList" items="${memberClassList}">
                <div class="row clients-page">
                   <div class="col-md-2">
                        <img src="resources/upload/lectureImg/${classList.lect_img}" class="img-responsive hover-effect" alt="" />
                    </div>
                    <div class="col-md-10">
                        <a href="memberClassDetail?reg_num=${classList.reg_num}&member_id=${sessionScope.member.id}"><h3>${classList.lect_name}</h3></a>
                        <ul class="list-inline">
                            <li><i class="fa fa-map-marker color-green"></i> 과목 : ${classList.subj_name} </li>
                            <li><i class="fa fa-briefcase color-green"></i> 교재 : ${classList.book_name}</li>
                             <li><i class="glyphicon glyphicon-time color-green"></i> 시간 : ${classList.beginTime}~${classList.endTime}</li>
                             
                            
                            
                        </ul>
                        
                    </div>
                </div>
                <hr>
                </c:forEach>
                <!-- End Clients Block-->

                
                <!-- End Pagination -->
            </div><!--/col-md-9-->
        </div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>