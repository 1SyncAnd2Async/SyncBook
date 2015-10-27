<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<div class="col-md-12 md-margin-bottom-40">
					<h1 class="pull-left">${memberClassDetail.lect_name}</h1>
					<ul class="pull-right breadcrumb">
						<li><a href="index">Home</a></li>
						<li><a href="memberClassList?id=${sessionScope.member.id}">내 강의 목록</a></li>
						<li class="active">${memberClassDetail.lect_name}</li>
					</ul>
				</div>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content height-500">
			<div class="col-md-12 md-margin-bottom-40">
				<div class="tab-v1">
					<div class="tab-content">
						<!-- Success Forms -->
						<div class="tab-pane fade in active" id="home-1">
							<form action="#" class="sky-form" id="selectTeacher">
								<header>
									<span class="icon-bubbles"></span>&nbsp;&nbsp;${memberClassDetail.lect_name}
								</header>
								<fieldset>
									<section>
										<div style="float: left; width: 33%;">
											<img style="margin-top: 0px; height: 250px;"
												src="resources/upload/lectureImg/${memberClassDetail.lect_img}"
												class="img-responsive hover-effect" alt="" />
										</div>
										<div
											style="float: left; margin-left: 10px; padding-bottom:20px; width: 62%; height: 250px;">
											<label><span class=" icon-tag">&nbsp;${memberClassDetail.subj_name}</span></label>
											<pre style="height: 100%;">${memberClassDetail.explanation }</pre>
										</div>
									</section>
								</fieldset>

								<fieldset>
									<div style="width: 100%;">
										<label><span class=" icon-user-female"></span>&nbsp;&nbsp;강사</label>
									</div>
									<div style="float: left; width: 20%">
										<img style="width: 100%;"
											src="resources/upload/teacherImg/${memberClassDetail.teacher_img}"
											class="img-responsive hover-effect" alt="" />
									</div>
									<div
										style="float: left; margin-top: 0px; margin-left: 30px; width: 70%; padding-top: 40px;">
										<label class="label">이름 :
											${memberClassDetail.teacher_name}</label> <label class="label">E-Mail
											: ${memberClassDetail.teacher_email}</label> <label class="label">번호
											: ${memberClassDetail.teacher_phone}</label>
									</div>
								</fieldset>

								<fieldset>
									<div style="width: 100%;">
										<label><span class=" icon-book-open"></span>&nbsp;&nbsp;교재</label>
									</div>
									<section>
										<label class="label"> ${memberClassDetail.book_name}</label>
									</section>
								</fieldset>
								<fieldset>
									<div style="width: 100%;">
										<label><span class="icon-earphones-alt"></span>&nbsp;&nbsp;수업
											참여</label>
									</div>
									<div style="padding-left: 38%; margin-bottom: 20px;">
										<c:choose>
											<c:when test="${sessionScope.member.id != null}">
												<input type="button"
													onclick="location.href='messageForm?reg_num=${memberClassDetail.reg_num}&id=${sessionScope.member.id}'"
													value="질문 하기" class="btn-u btn-u-lg">&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="button"
													onclick="location.href='lectureStart?reg_num=${memberClassDetail.reg_num}'"
													value="수업 시작" class="btn-u btn-u-lg">
											&nbsp;<b><font color="red">${msg}</font></b>
											
											</c:when>
											<c:when test="${sessionScope.teacher.id != null}">
												<input type="button"
													onclick="location.href='messageForm?reg_num=${memberClassDetail.reg_num}&id=${sessionScope.teacher.id}'"
													value="쪽지 쓰기" class="btn-u btn-u-lg">&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="button"
													onclick="window.open('http://117.17.143.126:52252/teacher/${memberClassDetail.reg_num}')"
													value="수업 시작" class="btn-u btn-u-lg">
											</c:when>
										</c:choose>
									</div>
								</fieldset>
								<fieldset>
									<div style="width: 100%;">
										<label><span class=" icon-doc"></span>&nbsp;&nbsp;수업 자료</label>
									</div>
									<section>
										<table class="table">
											<tbody>
												<c:forEach var="dataList" items="${dataList}">
													<tr>
														<td>${dataList.num}</td>
														<td>${dataList.title}</td>
														<td><a href="data_fileDownload?data_file=${dataList.data_file}">${dataList.data_file}</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</section>
								</fieldset>
							</form>
						</div>

					</div>
				</div>
				<!-- Write Your HTML Codes Here -->
			</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>