<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">수강 후기</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="reviewList">수강 후기</a></li>
                	<li class="active">No.${reviewDetail.review_num }</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	<div  style="min-height:400px;" class="news-v3-in">
        			<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == reviewDetail.writer_id}">
        			 
        			 <button class="btn btn-danger"  style="float:right;margin-top:20px;margin-bottom:20px;"
        			 onclick="location.href='reviewDelete?review_num=${reviewDetail.review_num}'">
					 	<i class="fa fa-trash-o"></i>삭제
					 </button>
					 <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" 
        			 onclick="location.href='reviewUpdate?review_num=${reviewDetail.review_num}&lect_num=${reviewDetail.lect_num}'">수정</button> 
        			 </c:when>
        			 </c:choose>
        			 
        			 <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th colspan="4" style="border-top:1px solid #ddd;"><h2>${reviewDetail.title}</h2></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>	
                                    	<td style="width:750px;">수업명 : ${reviewDetail.lect_name}</td>
                                        <td>By  ${reviewDetail.writer}</td>      
                                        <td>${reviewDetail.write_date }</td> 
                                        <td>조회수 ${reviewDetail.hit }</td>                                 
                                    </tr>
                                    <tr  style="height:550px;">                                    	
                                        <td colspan="4">${reviewDetail.content}</td>                                       
                                    </tr>                                  
                                </tbody>
                            </table>
            </div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>