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
            	<h1 class="pull-left">Q&A</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="qnaList">Q&A</a></li>
                	<li class="active">No.${qnaDetail.qna_num }</li>
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
                	<c:when test="${sessionScope.member != null && qnaDetail.writer == sessionScope.member.id}">
                	<button class="btn btn-danger"  style="float:right;margin-top:20px;margin-bottom:20px;"
        			 onclick="location.href='qnaDelete?qna_num=${qnaDetail.qna_num}'">
					 	<i class="fa fa-trash-o"></i>삭제
					 </button>
        			 <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" 
        			 onclick="location.href='qnaUpdate?qna_num=${qnaDetail.qna_num}'">수정</button> 
        			 </c:when>
        			 </c:choose>
        			  	  <table class="table" style="background:rgba(255, 255, 255, 0.76);">
                                <thead>
                                    <tr>
                                        <th colspan="4" style="border-top:1px solid #ddd;"><h2>${qnaDetail.title}</h2></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>	
                                    	<td style="width:750px;"></td>
                                        <td>By ${qnaDetail.writer}</td>      
                                        <td>${qnaDetail.write_date }</td> 
                                        <td>${qnaDetail.hit }</td>                                 
                                    </tr>
                                    <tr  style="height:550px;">
                                        <td colspan="4">${qnaDetail.content}</td>                                       
                                    </tr>  
                                    <tr><td colspan="4">
                                    	 <c:choose>
							            	<c:when test="${qnaDetail.qna_file != null}" >
							            		<div><a href="qnaFileDownload?qna_file=${qnaDetail.qna_file}">${qnaDetail.qna_file}</a></div>
							            	</c:when>
							        	</c:choose></td>
                                    </tr>                                 
                                </tbody>
                            </table>
              </div>     
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>