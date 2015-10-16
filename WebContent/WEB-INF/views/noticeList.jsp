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
            	<h1 class="pull-left">공지사항</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">공지사항</li>
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
                        <c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}" var="notice" items="${NoticeList}">
                        	<tr>
                        		<td>${notice.notice_num }</td>
                        		<td><a href = "noticeDetail?notice_num=${notice.notice_num}">${notice.title }</a></td>
                        		<td>${notice.writer }</td>
                        		<td>${notice.write_date }</td>
                        		<td>${notice.hit }</td> 
                        		<c:choose>
                				<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
                        		<td>
									<button class="btn btn-danger btn-xs" onclick="location.href='deleteNotice?notice_num='+${notice.notice_num}">
										<i class="fa fa-trash-o"></i>삭제
									</button>
								</td>  
								</c:when>
								</c:choose>                     		
                        	</tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
                    <div style="float:right">
                    <form action="noticeSearchList" method="post" id="search"> 
	                    	
	                    				<select name="searchKind">
		                                    <option value="notice_num">글번호</option>
		                                    <option value="title">제목</option>
		                                    <option value="writer">글쓴이</option>
		                                </select>  
	                                
	                       	<input type="text" class="form-control" name="searchValue" placeholder="Search">
	                           
	                           <button class="btn-u" type="submit" >Go</button>	                         
                        </form>
                         <c:choose>
	                	<c:when test="${sessionScope.member != null && sessionScope.member.id == 'admin'}">
	                      <button class="btn-u"  style="float:right;margin-top:20px;margin-bottom:20px;" onclick="location.href='noticeForm'">글쓰기</button>   
	                    </c:when>
	                    </c:choose>   
                        </div>
                        
                  		 <!-- Pagination -->
                <div align="center">
								<table>
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
																href="noticeList?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
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
																	href="noticeList?page=
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
																	href="noticeList?page=
                                 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																	${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
                                						</c:when>
                                						<c:otherwise>
                                						<li><a
																	href="noticeList?page=
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
																href="noticeList?page=
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
                        </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>