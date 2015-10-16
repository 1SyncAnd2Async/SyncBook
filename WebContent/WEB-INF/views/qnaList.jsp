<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.co.syncbook.vo.QnaVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        		<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">Q&A</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">Q&A</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content">
    	<div class="col-md-12 md-margin-bottom-40">
		<div class="row">
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
                        <c:forEach var="qnaList" items="${qnaList}">
                        	<tr>
                        		<td>${qnaList.qna_num }</td>
                        		<td><a href = "qnaDetail?qna_num=${qnaList.qna_num}">${qnaList.title }</a></td>
                        		<td>${qnaList.writer }</td>
                        		<td>${qnaList.write_date }</td>
                        		<td>${qnaList.hit }</td>  
                        		<c:choose>
                				<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                        		<td>
									<button class="btn btn-danger btn-xs" onclick="location.href='qnaDelete?qna_num='+${qnaList.qna_num}">
										<i class="fa fa-trash-o"></i>삭제
									</button>
								</td>  
								</c:when>
								</c:choose>                         		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="float:right;">
                    <form action="qnaSearchList" method="post" id="search"> 
	                    	
	                    				<select name="searchKind">
		                                    <option value="qna_num">글번호</option>
		                                    <option value="title">제목</option>
		                                    <option value="writer">글쓴이</option>
		                                </select>  
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           
	                           <button class="btn-u" type="submit" >Go</button>	                         
                        </form>
                        <c:choose>
	                	<c:when test="${sessionScope.member != null}">
	                      <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" onclick="location.href='qnaForm'">글쓰기</button>   
	                    </c:when>
	                    </c:choose>    
                        </div>
                        </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>