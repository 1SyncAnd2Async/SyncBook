<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.co.syncbook.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>    
<script>
$(function(){
    //전체선택 체크박스 클릭
	$("#allCheck").click(function(){
		//만약 전체 선택 체크박스가 체크된상태일경우
		if($("#allCheck").prop("checked")) {
			//해당화면에 전체 checkbox들을 체크해준다
			$("input[type=checkbox]").prop("checked",true);
		// 전체선택 체크박스가 해제된 경우
		} else {
			//해당화면에 모든 checkbox들의 체크를해제시킨다.
			$("input[type=checkbox]").prop("checked",false);
		}
	})
})

	 function checkDel() {
	  var chkFirList = document.getElementsByName('check');
	  var arrFir = new Array();
	  var cnt = 0;
	  for ( var idx = chkFirList.length - 1; 0 <= idx; idx--) {
	   if (chkFirList[idx].checked) {
	    arrFir[cnt] = chkFirList[idx].value;
	    cnt++;
	   }
	  }  
	  if (arrFir.length != 0) {
	   document.form1.submit();
	  } else {
	   alert('삭제할 쪽지를 선택하세요.');   
	   return;
	  }
	 }
	 
</script>
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
					<c:choose>
						<c:when test="${sessionScope.member.id != null}">
						<form name="form1" method="post" action="deleteReceiveMessage?id=${sessionScope.member.id}" id="checkList">
						</c:when>
						<c:when test="${sessionScope.teacher.id != null}">
						<form name="form1" method="post" action="deleteReceiveMessage?id=${sessionScope.teacher.id}" id="checkList">
						</c:when>
					</c:choose>
                   <table class="table">
                        <thead>
                            <tr>
                            	<th><input type="checkbox" id="allCheck"/></th>
                                <th style="width:50%; margin-left:150px;">내용</th>
                                <th class="hidden-sm">보낸이</th>
                                <th>날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}" var="message" items="${message}">
                        	<tr>                        		
                        		<td><input type='checkbox' class='input_check' name="check" value="${message.message_num}"></td>
                        		<td>
                        		<c:choose>
                        		<c:when test="${message.status == 0}">
                        		<a style="overflow:hidden; text-overflow:ellipsis; 
                        		word-break: break-word; -webkit-line-clamp: 1; display: -webkit-box;
                        		 -webkit-box-orient: vertical; font-weight:bolder;" href = "messageDetail?message_num=${message.message_num}">${message.content }</a>
                        		</c:when>
                        		<c:otherwise>
                        		<a style="overflow:hidden; text-overflow:ellipsis; 
                        		word-break: break-word; -webkit-line-clamp: 1; display: -webkit-box;
                        		 -webkit-box-orient: vertical; color:black;" href = "messageDetail?message_num=${message.message_num}">${message.content }</a>
                        		</c:otherwise>
                        		</c:choose>
                        		</td>
                        		<td>${message.sender }</td>
                        		<td>${message.write_date }</td>
									
								                 		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>	
                    			<button style="float:right;" class="btn btn-danger btn-xs" onclick="checkDel()">
										<i class="fa fa-trash-o"></i>삭제
								</button>
								</form>
                    
                        <br>
                  		<!-- Pagination -->
               			<div align="center">
								<table style="width:100%;">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" style="text-align: center">
											<!-- Page 이전 페이지 구현  --><c:choose>
												<c:when test="${sessionScope.member != null}">
													<c:choose>
														<c:when test="${pageInfo.currentBlock eq 1}">
															 
														</c:when>
														<c:otherwise>
															 <ul class="pagination">
                        										<li><a href="messageList?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }&receiver=${sessionScope.member.id}">
																«
															</a></li></ul>
														</c:otherwise>
													</c:choose>

													<!-- Page  페이지 구현 -->
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
															<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
																varStatus="num">
                                 							<ul class="pagination">                                 							
                                 							<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == num.count}">
		                        										<li class="active"><a
																			href="messageList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.member.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="messageList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.member.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:otherwise>
		                                						</c:choose>
                        									</ul>
                                							</c:forEach>
														</c:when>
														<c:otherwise>
															<c:forEach
																begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
																end="${pageInfo.totalPages}" varStatus="num">
                                 								<ul class="pagination">
                        										<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == (pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + num.count}">
		                        										<li class="active"><a
																			href="messageList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.member.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="messageList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.member.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:otherwise>
		                                						</c:choose>
                        										</ul>
                            							 </c:forEach>
														</c:otherwise>
													</c:choose>


													<!-- Page 다음 페이지 구현 -->
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
														</c:when>
														<c:otherwise>
															<ul class="pagination">
                        										<li><a
																href="messageList?page=
                  ${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }&receiver=${sessionScope.member.id}">
																»
															</a></li>
															</ul>
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:when test="${sessionScope.teacher != null}">
													<c:choose>
														<c:when test="${pageInfo.currentBlock eq 1}">
															 
														</c:when>
														<c:otherwise>
															 <ul class="pagination">
                        										<li><a href="messageList?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }&receiver=${sessionScope.teacher.id}">
																«
															</a></li></ul>
														</c:otherwise>
													</c:choose>

													<!-- Page  페이지 구현 -->
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
															<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
																varStatus="num">
                                 							<ul class="pagination">
                        										<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == num.count}">
		                        										<li class="active"><a
																			href="messageList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.teacher.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="messageList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.teacher.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:otherwise>
		                                						</c:choose></ul>
                                							</c:forEach>
														</c:when>
														<c:otherwise>
															<c:forEach
																begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
																end="${pageInfo.totalPages}" varStatus="num">
                                 								<ul class="pagination">
                        										<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == (pageInfo.currentBlock-1)*pageInfo.pagesPerBlock +num.count}">
		                        										<li class="active"><a
																			href="messageList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.teacher.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="messageList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }&receiver=${sessionScope.teacher.id}">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:otherwise>
		                                						</c:choose>
                        										</ul>
                            							 </c:forEach>
														</c:otherwise>
													</c:choose>


													<!-- Page 다음 페이지 구현 -->
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
														</c:when>
														<c:otherwise>
															<ul class="pagination">
                        										<li><a
																href="messageList?page=
                  ${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }&receiver=${sessionScope.teacher.id}">
																»
															</a></li>
															</ul>
														</c:otherwise>
													</c:choose>
												</c:when>
											</c:choose>
										</td>
									</tr>
								</table>
							</div>
                
            <!-- End Pagination -->
                        </div>
                        </div>
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>