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
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">�����ı�</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">�����ı�</li>                	
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
                                <th>��ȣ</th>
                                <th style="width:50%; margin-left:150px;">����</th>
                                <th class="hidden-sm">�۾���</th>
                                <th>��¥</th>
                                <th>��ȸ ��</th>
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
                        		<c:choose>
                				<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                        		<td>
									<button class="btn btn-danger btn-xs" onclick="location.href='reviewDelete?review_num='+${reviewList.review_num}">
										<i class="fa fa-trash-o"></i>����
									</button>
								</td>  
								</c:when>
								</c:choose>                      		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="float:right;">
                    <form action="reviewSearchList" method="post" id="search"> 
	                    	
	                    				<select name="searchKind">
		                                    <option value="review_num">�۹�ȣ</option>
		                                    <option value="title">����</option>
		                                    <option value="writer">�۾���</option>
		                                </select>  
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           
	                           <button class="btn-u" type="submit" >Go</button>	                         
                        </form>
                        <c:choose>
	                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
	                      <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" onclick="location.href='reviewForm'">�۾���</button>   
	                    </c:when>
	                    </c:choose>   
                        </div>
                        </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>