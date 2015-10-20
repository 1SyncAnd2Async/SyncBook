<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
	$(function() {
		$("a.pull-right").click(function() {
			$("font.text").hide();
			$("label.input input").show();
			$("label.input label").show();
			$("i.fa fa-pencil").hide();
			$("#profile_edit_btn").show();
			$("#profile_cancel_btn").show();
			$("input:file").show();
		});
	});
</script>
<script>
	$(function(){
		$("#teacherPwd").change(function(){
			jQuery.ajax({
				url: "teacherPwdCheck",
				data: "teacherPwd=" + $("#teacherPwd").val(),
				success: function(data) {
					if(data == "success"){
						document.getElementById("pwdCheckLayer").innerHTML = "<font color='green'>비밀번호가 일치합니다.</font>";
						$("#pwd_edit_btn").show();
						$("#pwd_cancel_btn").show();
					} else if(data == "fail"){
						document.getElementById("pwdCheckLayer").innerHTML = "<font color='red'>잘못된 비밀번호입니다.</font>";
						$("#pwd_edit_btn").hide();
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
		<!--=== Profile ===-->
		<div class="container content profile">
			<div class="row">
				<!--Left Sidebar-->
				<div class="col-md-3 md-margin-bottom-40">
					<img class="img-responsive profile-img margin-bottom-20" src="resources/upload/teacherImg/${sessionScope.teacher.img}" alt="">
					<ul class="list-group sidebar-nav-v1 margin-bottom-40"
						id="sidebar-nav-1">
						<li class="list-group-item"><a href="page_profile.html"><i
								class="fa fa-bar-chart-o"></i> Overall</a></li>
						<li class="list-group-item"><a href="page_profile_me.html"><i
								class="fa fa-user"></i> Profile</a></li>
						<li class="list-group-item"><a href="page_profile_users.html"><i
								class="fa fa-group"></i> Users</a></li>
						<li class="list-group-item"><a
							href="page_profile_projects.html"><i class="fa fa-cubes"></i>
								teacher Projects</a></li>
						<li class="list-group-item"><a
							href="page_profile_comments.html"><i class="fa fa-comments"></i>
								Comments</a></li>
						<li class="list-group-item"><a
							href="page_profile_history.html"><i class="fa fa-history"></i>
								History</a></li>
						<li class="list-group-item active"><a
							href="page_profile_settings.html"><i class="fa fa-cog"></i>
								Settings</a></li>
					</ul>

					<!--Datepicker-->
					<form action="#" id="sky-form2" class="sky-form">
						<div id="inline-start"></div>
					</form>
					<!--End Datepicker-->
				</div>
				<!--End Left Sidebar-->

				<!-- Profile Content -->
				<div class="col-md-9">
					<div class="profile-body margin-bottom-20">
						<div class="tab-v1">
							<ul class="nav nav-justified nav-tabs">
								<li class="active"><a data-toggle="tab" href="#profile">프로필
										변경</a></li>
								<li><a data-toggle="tab" href="#passwordTab">비밀번호 변경</a></li>
							</ul>
							<div class="tab-content">
								<!-- teacher Profile Edit -->
								<div id="profile" class="profile-edit tab-pane fade in active">
									<form action="updateTeacherProfile" method="post" enctype="multipart/form-data">
										<h2 class="heading-md">Manage your Name, ID and Email
											Addresses.</h2>
										<p>Below are the name and email addresses on file for your
											account.</p>
										<br>
										<dl class="dl-horizontal">
											<dt>
												<strong>아이디 </strong>
											</dt>
											<dd>
												${sessionScope.teacher.id}
												<span>
													<a class="pull-right" href="#">
														정보 변경 <i class="fa fa-pencil"></i>
													</a>
												</span>
											</dd>
											<hr>
											<dt>
												<strong>이름 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.teacher.name}</font> <label class="input">
													<input type="text" name="name" value="${sessionScope.teacher.name}"
													style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>연락처 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.teacher.phone}</font> <label class="input">
													<input type="tel" name="phone" id="phone"
													value="${sessionScope.teacher.phone}" style="display: none">
												</label>
											</dd>
											<hr>										
											<dt>
												<strong>이메일 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.teacher.email}</font> <label
													class="input"> <input type="text" name="email"
													value="${sessionScope.teacher.email}" style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>사진 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.teacher.img}</font>
												<label class="input">
													<input type="file" name="upfile" id="upfile" value="${sessionScope.teacher.img}" style="display: none">
												</label>
											</dd>
										</dl>
										<div class="pull-right">
											<input type="submit" class="btn-u" id="profile_edit_btn" value="변경 완료" style="display: none">
											<button type="button" class="btn-u btn-u-default" id="profile_cancel_btn" onclick="location.href='teacherPageForm'" style="display: none">변경 취소</button>
										</div>
									</form>
								</div>
								<!-- End teacher Profile Edit -->
								
								<!-- teacher Password Edit -->
								<div id="passwordTab" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Manage your Security Settings</h2>
									<p>Change your password.</p>
									<br>
									<form class="sky-form" id="sky-form1" action="updateteacherPwd" method="post">
										<dl class="dl-horizontal">
											<dt>현재 비밀번호</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" placeholder="Current password" id="teacherPwd">
														<b class="tooltip tooltip-bottom-right">Input your current password</b>
													</label>
													<span id="pwdCheckLayer"></span>
												</section>
											</dd>
											<dt>새 비밀번호</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" id="password" name="password" placeholder="New password">
														<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
													</label>
												</section>
											</dd>
											<dt>새 비밀번호 확인</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" name="password_confirm" placeholder="Confirm new password">
														<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
													</label>
												</section>
											</dd>
										</dl>
										<section>
											<label class="checkbox">
												<input type="checkbox" id="terms" name="terms"><i></i>
												<a href="#">비밀번호 변경에 동의합니다.</a>
											</label>
										</section>
										<div class="pull-right">
											<input type="submit" class="btn-u" id="pwd_edit_btn" value="변경 완료" style="display: none">
											<button type="button" class="btn-u btn-u-default" id="pwd_cancel_btn" onclick="location.href='teacherPageForm'" style="display: none">변경 취소</button>
										</div>
									</form>
								</div>
								<!-- End teacher Password Edit -->
							</div>
						</div>
					</div>
				</div>
				<!-- End Profile Content -->
			</div>
			<!--/end row-->
		</div>
		<!--=== End Profile ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>