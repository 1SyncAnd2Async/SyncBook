<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import="kr.co.syncbook.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">받은 쪽지함</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">받은 쪽지함</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->  
    	
    	<!--=== Content ===-->
    	<div class="container content">
    	<div class="col-md-12 md-margin-bottom-40">
    	<div class="col-md-3 md-margin-bottom-40" >					
					<ul class="list-group sidebar-nav-v1 margin-bottom-40"
						id="sidebar-nav-1">
						<c:choose>
						<c:when test="${sessionScope.member.id != null}">
						<li class="list-group-item"><a href="messageSelect?id=${sessionScope.member.id}"><i
								class="fa fa-pencil"></i> 쪽지 쓰기</a></li>
						<li class="list-group-item"><a href="messageList?page=1&receiver=${sessionScope.member.id}"><i
								class="fa fa-envelope-square"></i> 받은 쪽지함</a></li>
						<li class="list-group-item"><a href="sendMessageList?page=1&sender=${sessionScope.member.id}"><i
								class="fa fa-pencil-square-o"></i> 보낸 쪽지함</a></li>
						</c:when>
						<c:when test="${sessionScope.teacher.id != null}">
						<li class="list-group-item"><a href="messageSelect?id=${sessionScope.teacher.id}"><i
								class="fa fa-pencil"></i> 쪽지 쓰기</a></li>
						<li class="list-group-item"><a href="messageList?page=1&receiver=${sessionScope.teacher.id}"><i
								class="fa fa-envelope-square"></i> 받은 쪽지함</a></li>
						<li class="list-group-item"><a href="sendMessageList?page=1&sender=${sessionScope.teacher.id}"><i
								class="fa fa-pencil-square-o"></i> 보낸 쪽지함</a></li>
						
						</c:when>
						</c:choose>
					</ul>
				</div>
		<div class="col-md-9">
                   <table class="table">
                        <thead>
                            <tr>
                                <th style="width:50%; margin-left:150px;">수업</th>
                                <th class="hidden-sm">받는이</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="memberClassList" items="${memberClassList}">
                        	<tr>
                        		<c:choose>
		                			<c:when test="${sessionScope.member.id != null}">
		                        		<td><a href="messageSelectForm?reg_num=${memberClassList.reg_num}&id=${sessionScope.member.id}">
		                        		${memberClassList.lect_name}</a></td>
		                        		<td>${memberClassList.teacher_id}</td>
		                        	</c:when>
		                        	<c:when test="${sessionScope.teacher.id != null}">
		                        		<td><a href="messageSelectForm?reg_num=${memberClassList.reg_num}&id=${sessionScope.teacher.id}">
		                        		${memberClassList.lect_name}</a></td>
		                        		<td>${memberClassList.member_id}</td>
		                        	</c:when>
		                        </c:choose>          		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>