<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.co.syncbook.vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">수강후기</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">수강후기</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content">
		<div class="row">
    	<div class="panel panel-green margin-bottom-40">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-tasks"></i>수강후기</h3>
                    </div>
                  	<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                      <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" onclick="location.href='reviewForm'">글쓰기</button>   
                    </c:when>
                    </c:choose>
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
                        <c:forEach var="reviewList" items="${reviewList}">
                        	<tr>
                        		<td>${reviewList.review_num }</td>
                        		<td><a href = "reviewDetail?review_num=${reviewList.review_num}">${reviewList.title }</a></td>
                        		<td>${reviewList.writer }</td>
                        		<td>${reviewList.write_date }</td>
                        		<td>${reviewList.hit }</td>                        		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="margin:0 auto; margin-bottom:30px; width:600px;">
                    <form action="reviewSearchList" method="post" id="search"> 
	                    	
	                    				<select name="searchKind">
		                                    <option value="review_num">글번호</option>
		                                    <option value="title">제목</option>
		                                    <option value="writer">글쓴이</option>
		                                </select>  
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           
	                           <button class="btn-u" type="submit" >Go</button>	                         
                        </form>
                            
                        </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>