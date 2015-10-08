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
            	<h1 class="pull-left">��������</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">Notice</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="panel panel-green margin-bottom-40">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-tasks"></i>��������</h3>
                    </div>
                  	<c:choose>
                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                      <button style="float:right;margin-top:20px;margin-bottom:20px;" onclick="location.href='noticeForm'">�۾���</button>   
                    </c:when>
                    </c:choose>
                    </div>
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
                        <c:forEach var="notice" items="${NoticeList}">
                        	<tr>
                        		<td>${notice.notice_num }</td>
                        		<td><a href = "noticeDetail?notice_num=${notice.notice_num}">${notice.title }</a></td>
                        		<td>${notice.writer }</td>
                        		<td>${notice.write_date }</td>
                        		<td>${notice.hit }</td>                        		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="margin:0 auto; margin-bottom:30px; width:600px;">
                    <form action="noticeSearchList" method="post" id="search"> 
	                    	
	                    				<select name="searchKind">
		                                    <option value="notice_num">�۹�ȣ</option>
		                                    <option value="title">����</option>
		                                    <option value="writer">�۾���</option>
		                                </select>  
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           
	                           <button class="btn-u" type="submit" >Go</button>	                         
                        </form>
                            
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>