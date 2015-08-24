<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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
                    <ul class="list-inline posted-info">
                        <li>By ${NoticeDetail.writer}</li>                        
                        <li>${NoticeDetail.write_date }</li>
                        <li>조회 수${NoticeDetail.hit }</li>
                    </ul>
                    <h2>${NoticeDetail.title}</h2>
                    <p>${NoticeDetail.content}</p>
            </div>
            <c:if ${NoticeDetail.notice_file} != null >
            <div><a href="fileDownload?notice_file=${NoticeDetail.notice_file}">${NoticeDetail.notice_file}</a></div>
            </c:if>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>