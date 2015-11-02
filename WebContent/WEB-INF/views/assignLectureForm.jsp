<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(function(){
	$("#subjectNum").change(function(){
		$.ajax({
			url: "selectLecture",
			data: "subj_num=" + $("#subjectNum").val(),
			success:function(data){
				 $("#selectLecture").html(data);
			},
			error:function(){
				alert("error!");
			}
		});	
	});
});
</script>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
			<div class="col-md-12 md-margin-bottom-4">
				<h1 class="pull-left">강사배정</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li class="active">Lecture</li>
				</ul>
			</div>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content">
		<div class="col-md-12 md-margin-bottom-4">
		<div class="row">
		<!-- Reg-Form -->
	
				<form action="assignLecture" method="post" id="sky-form4" class="sky-form">
					<header>수업 배정</header>							
					<fieldset>
						<section>
							<label>과목&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="subj_num" id="subjectNum">
								<option value="">과목선택</option>
								<c:forEach var="subjectList" items="${subjectList}">											
                                    <option value="${subjectList.subj_num}">${subjectList.subj_name}</option>		                                	
                                </c:forEach>
                               </select> 
							</label>
							
							<label>수업명&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<span id="selectLecture">
								<select name="lect_num" id="Lecture">
									<option value="">수업선택</option>											
                               	</select> 
                            </span>
							</label>
							
							<label>강사&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="teacher_id">
								<option value="">강사선택</option>
								<c:forEach var="teacherList" items="${teacherList}">											
                                    <option value="${teacherList.id}">${teacherList.name}</option>		                                	
                                </c:forEach>
                               </select> 
							</label>
							
							<label>요일&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="day">
								<option value="">요일선택</option>																	
                                    <option value="Monday">월요일</option>
                                    <option value="Tuesday">화요일</option>
                                    <option value="Wednesday">수요일</option>
                                    <option value="Thursday">목요일</option>
                                    <option value="Friday">금요일</option>
                               </select> 
							</label>
							
							<label>시작시간&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<span id="selectLecture">
								<input type="text" name="begintime" placeholder="Begin time">
                            </span>
							</label>
							
							<label>종료시간&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<span id="selectLecture">
								<input type="text" name="endtime" placeholder="End time">
                            </span>
							</label>
							
						</section>
					</fieldset>
					<footer>
						<div class="pull-right">
							<button type="submit" class="btn-u">등록</button>
						</div>
					</footer>
				</form>
		</div>
			<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
							<!--Basic Table-->
							<div class="panel panel-green margin-bottom-40">
								
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>수업명</th>
											<th>강사</th>
											<th>요일</th>
											<th>시작시간</th>
											<th>종료시간</th>
											<th>배정상태</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach begin="${pageInfo.startRow}" end="${pageInfo.endRow}" var="assignList" items="${assignList}">
											<tr>
												<td>${assignList.rnum}</td>
												<td>${assignList.lect_name}</td>
												<td>${assignList.name}</td>
												<td>${assignList.day}</td>
												<td>${assignList.begintime}</td>
												<td>${assignList.endtime}</td>
												<td>
													<c:choose>
														<c:when test="${assignList.status == 0}">
															미배정
														</c:when>
														<c:otherwise>
															배정완료
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<button class="btn btn-danger btn-xs" onclick="location.href='deleteAssignLect?lect_num='+${list.lect_num}+'&teacher_id='+${list.teacher_id}">
														<i class="fa fa-trash-o"></i>삭제
													</button>
												</td>
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
																href="assignLectureForm?page= ${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">
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
																			href="assignLectureForm?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="assignLectureForm?page=
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
																			href="assignLectureForm?page=
		                                 									${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">
																			${(pageInfo.currentBlock- 1) * pageInfo.pagesPerBlock + num.count }</a></li>
		                                							</c:when>
		                                							<c:otherwise>
		                                								<li><a
																			href="assignLectureForm?page=
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
																href="assignLectureForm?page=
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
							<!--End Basic Table-->
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>