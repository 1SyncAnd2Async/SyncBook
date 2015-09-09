<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left">Book</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li class="active">Book</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content">
			<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
						<div class="col-md-8">
							<!--Basic Table-->
							<div class="panel panel-green margin-bottom-40">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-tasks"></i> 교재 목록
									</h3>
								</div>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>과목명</th>
											<th>교재명</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.num}</td>
												<td>${list.subj_name}</td>
												<td>${list.book_name}</td>
												<td>
													<button class="btn btn-danger btn-xs" onclick="location.href='deleteBook?book_num='+${list.book_num}">
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
						<div class="col-md-4">
							<!-- Reg-Form -->
							<form action="addBook" method="post" id="sky-form4" class="sky-form">
								<header>교재 등록</header>							
								<fieldset>
									<section>
										<label>과목명</label>
										<label  class="input">
										<select name="subj_num">
											<c:forEach var="subjectList" items="${subjectList}">											
			                                    <option value="${subjectList.subj_num }">${subjectList.subj_name }</option>		                                	
			                                </c:forEach>
		                                </select> 
										</label>
										</section>
										<section>
										<label>교재명 </label> <label class="input"> <i
											class="icon-append fa fa-user"></i> <input type="text"
											name="book_name" placeholder="Subject name">
										</label>
									</section>
								</fieldset>
								<footer>
									<div class="pull-right">
										<button type="submit" class="btn-u">등록</button>
									</div>
								</footer>
							</form>
							<!-- End Reg-Form -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>