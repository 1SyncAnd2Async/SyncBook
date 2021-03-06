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
                            
                            <tr><th>보낸사람 : ${messageDetail.sender}</th><th style="text-align: right;"> ${messageDetail.write_date}</th></tr>
                            <tr><th colspan="2">받는사람 : ${messageDetail.receiver}</th></tr>                            
                        </thead>
                        <tbody>
                        	<tr>
                                <td>수업 : ${messageDetail.lect_name}</td>
                                <td style="text-align: right;"><i class="glyphicon glyphicon-time color-green"></i>${messageDetail.beginTime} ~ ${messageDetail.endTime}</td>
                            </tr>                        
                        	<tr>
                        		<td colspan="2">${messageDetail.content }</td>
                        		                  		
                        	</tr>
                        </tbody>
                    </table>
                    
                        </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>