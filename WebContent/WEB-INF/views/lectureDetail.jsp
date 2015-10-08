<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left">${lecture.lect_name}</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li><a href="#">Pages</a></li>
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
				<!-- Reg-Form -->
				<form action="addData" method="post"
					enctype="multipart/form-data" id="sky-form4" class="sky-form">
					<header>수업 자료 등록</header>
					<fieldset>
						<input type="hidden" name="lect_num" value="${lecture.lect_num}"><br>
						
												
						<section>
							<label>Title </label><br>
							<input type="text" name="title" placeholder="Title">
						</section>
						<section>
							<label>File </label> <input type="file" name="upfile">
						</section>
					</fieldset>
					<footer>
						<div class="pull-right">
							<input type="submit" value="등록" class="btn-u">
						</div>
					</footer>
				</form>
				<!-- End Reg-Form -->
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
						<!--Basic Table-->
						<div class="panel panel-green margin-bottom-40">
							<table class="table">
								<thead>
									<tr>
										<th><div style="width: 50px">#</div></th>
										<th><div style="width: 400px">Title</div></th>
										<th><div style="width: 250px">File</div></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dataList" items="${dataList}">
										<tr>
											<td>${dataList.num}</td>
											<td>${dataList.title}</td>
											<td>${dataList.data_file}</td>
											<td>
												<button class="btn btn-danger btn-xs"
													onclick="location.href='deleteData?data_num='+${dataList.data_num}">
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
		<div class="container content height-500">
			<!-- Write Your HTML Codes Here -->

		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>