<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.co.syncbook.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">공지사항</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">공지사항</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="panel panel-green margin-bottom-40">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-tasks"></i>공지사항</h3>
                    </div>
                    <div class="panel-body">   
                    <form action="noticeSearchList" method="post" id="search"> 
	                    <div class="input-group animated fadeInDown">
	                    	
	                    				<select name="searchKind">
		                                    <option value="notice_num">글번호</option>
		                                    <option value="title">제목</option>
		                                    <option value="writer">글쓴이</option>
		                                </select>  
		                </div>              	
	                   	<div class="input-group animated fadeInDown">
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           <span class="input-group-btn">
	                           	</form>
	                           <button class="btn-u" type="submit" >Go</button>
	                           </span>
	        
	                    </div>
	                    <div style="padding-left:94%; padding-top:20px;">
	                    <button class="btn-u btn-u-default box-shadow-inset" onclick="location.href='noticeForm'">글쓰기</button>
	                    </div>
                    
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th style="width:50%; margin-left:150px;">제목</th>
                                <th class="hidden-sm">글쓴이</th>
                                <th>날짜</th>
                                <th>조회 수</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="notice" items="${NoticeList}">
                        	<tr>
                        		<td>${notice.notice_num }</td>
                        		<td><a href = "noticeDetail?notice_num=${notice.notice_num}" } >${notice.title }</a></td>
                        		<td>${notice.writer }</td>
                        		<td>${notice.write_date }</td>
                        		<td>${notice.hit }</td>                        		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>