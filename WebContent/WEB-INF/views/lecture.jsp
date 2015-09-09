<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(function(){
	
	
	$("#subjectNum").change(function(){
		$.ajax({
			url: "selectBook",
			data: "subj_num=" + $("#subjectNum").val(),
			success:function(data){
				 $("#selectBook").html(data);
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
		<div class="row" style="margin-bottom:50px;">
		<!-- Reg-Form -->
	
				<form action="addLecture" method="post" id="sky-form4" class="sky-form">
					<header>수업 등록</header>							
					<fieldset>
							<section>
							<label>과목&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="subj_num" id="subjectNum">
								<option value="">과목선택</option>
								<c:forEach var="subjectList" items="${subjectList}">											
                                    <option value="${subjectList.subj_num }">${subjectList.subj_name }</option>		                                	
                                </c:forEach>
                               </select> 
							</label>
							
							<label>교재&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<span id="selectBook">
							<select name="book_num" id="Book">
							<option value="">교재선택</option>											
                               </select> 
                               </span>
							</label>
							
							<label>수업명&nbsp&nbsp</label> 										
							<label style="margin-right:30px;">
							<input type="text"
								name="lect_name" placeholder="Lecture name">
							</label>
							
							<label>강사&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="teacher_id">
								<option value="">강사선택</option>
								<c:forEach var="teacherList" items="${teacherList}">											
                                    <option value="${teacherList.id }">${teacherList.name }</option>		                                	
                                </c:forEach>
                               </select> 
							</label>										
							
							<label>요일&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<select name="day">		
									<option value="">요일선택</option>																		
                                    <option value="Mon">월요일</option>		    
                                    <option value="Tues">화요일</option>		     
                                    <option value="Wedn">수요일</option>		     
                                    <option value="Thur">목요일</option>		     
                                    <option value="Fri">금요일</option>				                               
                               </select> 
							</label>
							
							</section>
							<section>
							<label>시간&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<input type="text"
								name="beginTime" placeholder="beginTime">&nbsp&nbsp&nbsp&nbsp~&nbsp&nbsp&nbsp&nbsp
								<input type="text"
								name="endTime" placeholder="endTime">
							</label>
							
							<label>가격&nbsp&nbsp</label>
							<label style="margin-right:30px;">
							<input type="text"
								name="price" placeholder="price">
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
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-tasks"></i> 수업 목록
									</h3>
								</div>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>과목</th>
											<th>수업</th>
											<th>강사</th>
											<th>교재</th>
											<th>요일</th>
											<th>시간</th>
											<th>가격</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.num}</td>
												<td>${list.subj_name}</td>
												<td>${list.lect_name}</td>
												<td>${list.teacher_name}</td>
												<td>${list.book_name}</td>
												<td>${list.day}</td>
												<td>${list.beginTime} ~ ${list.endTime }</td>
												<td>${list.price}</td>
												<td>
													<button class="btn btn-danger btn-xs" onclick="location.href='deleteLecture?lect_num='+${list.lect_num}">
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