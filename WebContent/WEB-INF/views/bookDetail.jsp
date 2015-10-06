<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left">${book.book_name}</h1>
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
				<form action="regQuestion" method="post"
					enctype="multipart/form-data" id="sky-form4" class="sky-form">
					<header>문제 등록</header>
					<fieldset>
						<input type="hidden" name="book_num" value="${book.book_num}"><br>
						<section>
							<label>단원 번호</label> <label class="input"> <input
								type="text" name="unit_num">
							</label>
						</section>
						<section>
							<label>문제 번호</label> <label class="input"> <input
								type="text" name="question_num">
							</label>
						</section>
						<section>
							<label>문제 이미지 </label> <input type="file" name="upImg">
						</section>
						<section>
							<label>해설 </label><br>
							<textarea autofocus required wrap="hard" name="explanation"
								rows="10" cols="120" form="sky-form4"></textarea>
						</section>
						<section>
							<label>해설 영상 </label> <input type="file" name="upVideo">
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
										<th><div style="width: 250px">내용</div></th>
										<th><div style="width: 400px">해설</div></th>
										<th><div style="width: 250px">영상</div></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="questionList" items="${questionList}">
										<tr>
											<td>${questionList.book_num}-${questionList.unit_num}-${questionList.question_num}</td>
											<td><img
												src="resources/upload/questionImg/${questionList.content}"
												class="img-responsive hover-effect" alt="" /></td>
											<td>${questionList.explanation}</td>
											<td><video
													id="myVideo" width="320" height="240" controls="controls">
													<source src="resources/upload/questionVideo/${questionList.question_file}"
														type="video/mp4" />
												</video></td>
											<td>
												<button class="btn btn-danger btn-xs"
													onclick="location.href='deleteBook?book_num='+${list.book_num}">
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