<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">공지사항</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="noticeList">공지사항</a></li>
                	<li class="active">No.${NoticeDetail.notice_num }</li>
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
        			 onclick="location.href='noticeUpdate?notice_num=${NoticeDetail.notice_num}'">수정</button> 
        			 </c:when>
        			 </c:choose>
        			  <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th colspan="4" style="border-top:1px solid #ddd;"><h2>${NoticeDetail.title}</h2></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>	
                                    	<td style="width:750px;"></td>
                                        <td>By ${NoticeDetail.writer}</td>      
                                        <td>${NoticeDetail.write_date }</td> 
                                        <td>조회수 ${NoticeDetail.hit }</td>                                 
                                    </tr>
                                    <tr  style="height:550px;">
                                        <td colspan="4">${NoticeDetail.content}</td>                                       
                                    </tr>  
                                    <tr><td colspan="4">
                                    	 <c:choose>
							            	<c:when test="${NoticeDetail.notice_file != null}" >
							            		<div><a href="noticeFileDownload?notice_file=${NoticeDetail.notice_file}">${NoticeDetail.notice_file}</a></div>
							            	</c:when>
							        	</c:choose></td>
                                    </tr>                                 
                                </tbody>
                            </table>
                    <%-- <ul class="list-inline posted-info">
                    	
                        <li></li>                        
                        <li>${NoticeDetail.write_date }</li>
                        <li>조회 수${NoticeDetail.hit }</li>
                    </ul>
                    <h2></h2>
                    <p>${NoticeDetail.content}</p> --%>
                   
            </div>
           
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>