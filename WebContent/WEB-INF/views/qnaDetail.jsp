<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">Q&A</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="qnaList">Q&A</a></li>
                	<li class="active">No.${qnaDetail.qna_num }</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	<div style="min-height:400px;" class="news-v3-in">
        			<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
        			 <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" 
        			 onclick="location.href='qnaUpdate?qna_num=${qnaDetail.qna_num}'">수정</button> 
        			 </c:when>
        			 </c:choose>
                    <ul class="list-inline posted-info">
                    	
                        <li>By ${qnaDetail.writer}</li>                        
                        <li>${qnaDetail.write_date }</li>
                        <li>조회 수${qnaDetail.hit }</li>
                    </ul>
                    <h2>${qnaDetail.title}</h2>
                    <p>${qnaDetail.content}</p>
                   
            </div>
            <c:choose>
            	<c:when test="${qnaDetail.qna_file != null}" >
            <div><a href="qnaFileDownload?qna_file=${qnaDetail.qna_file}">${qnaDetail.qna_file}</a></div>
            	</c:when>
            	</c:choose>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>