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
	
				<form action="assignLecture" method="post" id="sky-form4" class="sky-form">
					<header>수업 등록</header>							
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
											<th>수업명</th>
											<th>교재</th>
											<th>가격</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.rnum}</td>
												<td>${list.subj_name}</td>
												<td>${list.lect_name}</td>
												<td>${list.book_name}</td>
												<td>${list.price} 원</td>
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