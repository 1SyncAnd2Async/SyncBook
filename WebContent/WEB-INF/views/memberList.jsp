<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
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
                        <c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}"  var="member" items="${memberList}">
                        	<tr>
                        		<td><a href="memberDetail?id=${member.id }">${member.id }</a></td>
                        		<td>${member.name }</td>                        		
                        		<td>${member.reg_date }</td>                     		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                <!-- Pagination -->
               			 <div align="center">
								<table style="width:100%;">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" style="text-align: center">
											<%--Page 이전 페이지 구현 --%> <c:choose>
												<c:when test="${searchType == null}">
													<c:choose>
														<c:when test="${pageInfo.currentBlock eq 1}">
															 
														</c:when>
														<c:otherwise>
															 <ul class="pagination">
                        										<li><a
																href="memberList?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
																«
															</a></li></ul>
														</c:otherwise>
													</c:choose>

													<%--Page  페이지 구현 --%>
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
															<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
																varStatus="num">
                                 							<ul class="pagination">
                        										<li><a
																	href="memberList?page=
                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																	${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li></ul>
                                							</c:forEach>
														</c:when>
														<c:otherwise>
															<c:forEach
																begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
																end="${pageInfo.totalPages}" varStatus="num">
                                 								<ul class="pagination">
                        										<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == num.count}">
		                        										<li class="active"><a
																			href="memberList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="memberList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:otherwise>
		                                						</c:choose>
                        										</ul>
                            							 </c:forEach>
														</c:otherwise>
													</c:choose>


													<%--Page 다음 페이지 구현 --%>
													<c:choose>
														<c:when
															test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
														</c:when>
														<c:otherwise>
															<ul class="pagination">
                        										<li><a
																href="memberList?page=
                  ${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }">
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
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>