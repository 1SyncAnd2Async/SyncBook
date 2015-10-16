<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">학습신청</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="#">학습</a></li>
                	<li class="active">학습신청</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	
    	<div class="container content">
    	<div class="row">
        	<div class="col-md-12">
            	<div class="headline"><h2>학습 신청</h2></div>

                <!-- Clients Block-->
                <ul class="all-blogs" >
                <c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}" var="classList" items="${classList}">
                <div class="row clients-page">
                    <div class="col-md-2">
                        <img src="resources/upload/lectureImg/${classList.img}" class="img-responsive hover-effect" alt="" />
                    </div>
                    <div class="col-md-10">
                        <h3><a href="classDetail?lect_num=${classList.lect_num}">${classList.lect_name}</a></h3>
                        <ul class="list-inline">
                            <li><i class="fa fa-map-marker color-green"></i> 과목 : ${classList.subj_name} </li>
                            <li><i class="fa fa-briefcase color-green"></i> 교재 : ${classList.book_name}</li>
                        </ul>
                        <p> ${classList.explanation}</p>
                    </div>
                </div>
                <hr>
                </c:forEach>
                </ul>
                <!-- End Clients Block-->

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
																href="classListForm?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
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
																	href="classListForm?page=
                                 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																	${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li></ul>
                                </c:forEach>
														</c:when>
														<c:otherwise>
															<c:forEach
																begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
																end="${pageInfo.totalPages}" varStatus="num">
                                 <ul class="pagination">
                        										<li><a
																	href="classListForm?page=
                   ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																	${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }</a></li></ul>
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
																href="classListForm?page=
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
            </div><!--/col-md-9-->
        </div><!--/row-->
    </div></div><!--/container-->
    <!--=== End Content Part ===-->
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>