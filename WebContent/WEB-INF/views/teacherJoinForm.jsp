<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
$(function(){
	$("#teacherId").change(function(){
		$.ajax({
			url: "teacherIdCheck",
			data: "teacherId=" + $("#teacherId").val(),
			success:function(data){
				if(data == "fail"){
					document.getElementById("idCheckLayer").innerHTML = "<font color='red'>이미 등록된 ID 입니다.</font>";
				} else if(data == "success"){
					document.getElementById("idCheckLayer").innerHTML = "";
				}
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
			<div class="col-md-12 md-margin-bottom-40">
				<h1 class="pull-left">강사 회원가입</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li class="active">Teacher Join</li>
				</ul>
			</div>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content Part ===-->
		<div class="container content">
		<div class="col-md-12 md-margin-bottom-40">
			<div class="row">
				<!-- Begin Content -->
				<div class="col-md-9">
					<!-- Tabs -->
					<div class="tab-v1">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#profile-1" data-toggle="tab"
								aria-expanded="true">강사 회원가입 </a></li>
						</ul>
						<div class="tab-content">
							<!-- Validation Forms -->
							<div class="tab-pane fade in active" id="profile-1">
								<form action="teacherJoin" method="post" id="sky-form1" class="sky-form">
									<fieldset>
										<div class="row">
											<section class="col">
												<label>아이디</label>
												<label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="id" id="teacherId">
													<b class="tooltip tooltip-bottom-right">Needed to enter	the website</b>
												</label>
												<span id="idCheckLayer"></span>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label>비밀번호</label> <label class="input">
													<i class="icon-append fa fa-lock"></i>
													<input type="password" name="password" id="password">
													<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label>비밀번호 확인</label> <label class="input">
													<i class="icon-append fa fa-lock"></i>
													<input type="password" name="password_confirm">
													<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label>이름</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="name">
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label>연락처</label> <label class="input">
													<i class="icon-append fa fa-phone"></i>
													<input type="tel" name="phone" id="phone">
												</label>
											</section>
										</div>										
										<div class="row">
											<section class="col col-6">
												<label>이메일</label> <label class="input">
													<i class="icon-append fa fa-envelope"></i>
													<input type="email" name="email">
												</label>
											</section>
										</div>
									</fieldset>
									<footer>
										<input type="submit" class="btn-u btn-u-default" value="가입">
										<button type="button" class="btn-u"
											onclick="window.history.back();">이전</button>
									</footer>
								</form>
							</div>
							<!-- End Validation Forms -->
						</div>
					</div>
					<!-- End Tabs-->
				</div>
				<!-- End Content -->
			</div>
		</div>
		</div>
		<!--/container-->
		<!--=== End Content Part ===-->


	</tiles:putAttribute>
</tiles:insertDefinition>