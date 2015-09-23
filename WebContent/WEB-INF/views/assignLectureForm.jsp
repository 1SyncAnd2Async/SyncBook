<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
				<h1 class="pull-left">Lecture</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li class="active">Lecture</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content">
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
                                    <option value="월요일">월요일</option>
                                    <option value="화요일">화요일</option>
                                    <option value="수요일">수요일</option>
                                    <option value="목요일">목요일</option>
                                    <option value="금요일">금요일</option>
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
										<c:forEach var="assignList" items="${assignList}">
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
							</div>
							<!--End Basic Table-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>