<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	    <div class="col-md-12 md-margin-bottom-40">
        	
            	<h1 class="pull-left">FAQ</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="faqList">FAQ</a></li>
                	<li class="active">No.${faqDetail.faq_num }</li>
            	</ul>
        	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	   	<div class="col-md-12 md-margin-bottom-40">
    	
        	<!-- Write Your HTML Codes Here -->
        	<div style="min-height:400px;" class="news-v3-in">
        			<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
        			 <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" 
        			 onclick="location.href='faqUpdate?faq_num=${faqDetail.faq_num}'">수정</button> 
        			 </c:when>
        			 </c:choose>
                    <ul class="list-inline posted-info">
                    	
                        <li>By ${faqDetail.writer}</li>                        
                        <li>${faqDetail.write_date }</li>
                        <li>조회 수${faqDetail.hit }</li>
                    </ul>
                    <h2>${faqDetail.title}</h2>
                    <p>${faqDetail.content}</p>
                   
            </div>
            </div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>