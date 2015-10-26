<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
        	
            	<h1 class="pull-left">주문 내역</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">주문 내역</li>
            	</ul>
        	</div>
        	</div>
        	<!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	 <div class="col-md-12 md-margin-bottom-40">
    	
        	<form action="addLecture" method="post" id="sky-form4" class="sky-form" enctype="multipart/form-data">
					<header>주문 내역</header>							
					<fieldset>
						<section>
							<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
							<!--Basic Table-->
							<div class="panel panel-green margin-bottom-40">
								
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Date</th>
											<th>Id</th>
											<th>Phone</th>
											<th>Address</th>
											<th>Lecture</th>
											<th>Book</th>
											<th>Price</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}"  var="orderList" items="${orderList}">
											<tr>
												<td>${orderList.reg_num}</td>
												<td style="width:100px;">${orderList.reg_date}</td>
												<td>${orderList.member_id}</td>
												<td>${orderList.phone}</td>												
												<td>${orderList.post}<br>
													${orderList.address}<br>
													${orderList.detail_address}</td>
												<td>${orderList.lect_name}</td>
												<td>${orderList.book_name}</td>
												<td>${orderList.price} 원</td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</section>
					</fieldset>
			</form>
			
			
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
																href="orderList?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
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
                        									<c:choose>
		                                 							<c:when test="${pageInfo.currentPage == num.count}">
		                        										<li class="active"><a
																			href="orderList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="orderList?page=
		                                									 ${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
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
																			href="orderList?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="orderList?page=
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
																href="orderList?page=
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
			
			
			
			
			
			
			
			
			
			
    	</div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>