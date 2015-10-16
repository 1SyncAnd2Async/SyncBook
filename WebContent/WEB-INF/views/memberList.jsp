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
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">회원목록</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">Member List</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content">
			<div class="col-md-12 md-margin-bottom-40">
    	<div class="panel panel-green margin-bottom-40">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-tasks"></i>회원목록</h3>
                    </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>이름</th>
                                <th>등록날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="member" items="${memberList}">
                        	<tr>
                        		<td><a href="memberDetail?id=${member.id }">${member.id }</a></td>
                        		<td>${member.name }</td>                        		
                        		<td>${member.reg_date }</td>                     		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>