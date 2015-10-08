<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('post1').value = data.postcode1;
				document.getElementById('post2').value = data.postcode2;
				document.getElementById('address').value = data.address;
				document.getElementById('detail_address').focus();
			}
		}).open();
	}
</script>
<script>
	$(function() {
		$("a.pull-right").click(function() {
			$("font.text").hide();
			$("label.input input").show();
			$("label.input label").show();
			$("i.fa fa-pencil").hide();
			$("#profile_edit_btn").show();
			$("input:file").show();
		});
	});
</script>
<script>
	$(function(){
		$("#memberPwd").change(function(){
			jQuery.ajax({
				url: "pwdCheck",
				data: "memberPwd=" + $("#memberPwd").val(),
				success: function(data) {
					if(data == "success"){
						document.getElementById("pwdCheckLayer").innerHTML = "<font color='green'>비밀번호가 일치합니다.</font>";
						$("#pwd_edit_btn").show();
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
					<img class="img-responsive profile-img margin-bottom-20" src="resources/upload/memberImg/${sessionScope.member.img}" alt="">
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
								My Projects</a></li>
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
								<li><a data-toggle="tab" href="#payment">주문내역</a></li>
							</ul>
							<div class="tab-content">
								<!-- Member Profile Edit -->
								<div id="profile" class="profile-edit tab-pane fade in active">
									<form action="updateMemberProfile" method="post" enctype="multipart/form-data">
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
												${sessionScope.member.id}
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
												<font class="text">${sessionScope.member.name}</font> <label class="input">
													<input type="text" name="name" value="${sessionScope.member.name}"
													style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>연락처 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.phone}</font> <label class="input">
													<input type="tel" name="phone" id="phone"
													value="${sessionScope.member.phone}" style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>우편번호 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.post}</font> <label class="input">
													<input type="text" name="post1" id="post1" value="${sessionScope.post1}" style="display: none">
													<input type="text" name="post2" id="post2" value="${sessionScope.post2}" style="display: none">
													<input type="button" onclick="openDaumPostcode()" value="우편번호 찾기" style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>주소 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.address}</font> <label class="input"> <input
													type="text" name="address" id="address" value="${sessionScope.member.address}"
													style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>상세주소 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.detail_address}</font> <label class="input">
													<input type="text" name="detail_address"
													id="detail_address" value="${sessionScope.member.detail_address}" style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>이메일 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.email}</font> <label
													class="input"> <input type="text" name="email"
													value="${sessionScope.member.email}" style="display: none">
												</label>
											</dd>
											<hr>
											<dt>
												<strong>사진 </strong>
											</dt>
											<dd>
												<font class="text">${sessionScope.member.img}</font>
												<label class="input">
													<input type="file" name="upfile" id="upfile" value="${sessionScope.member.img}" style="display: none">
												</label>
											</dd>
										</dl>
										<div class="pull-right">
											<input type="submit" class="btn-u" id="profile_edit_btn" value="변경 완료" style="display: none">
											<button type="button" class="btn-u btn-u-default" onclick="location.href='myPageForm'">변경 취소</button>
										</div>
									</form>
								</div>
								<!-- End Member Profile Edit -->
								
								<!-- Member Password Edit -->
								<div id="passwordTab" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Manage your Security Settings</h2>
									<p>Change your password.</p>
									<br>
									<form class="sky-form" id="sky-form1" action="updateMemberPwd" method="post">
										<dl class="dl-horizontal">
											<dt>현재 비밀번호</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" placeholder="Current password" id="memberPwd">
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
											<button type="button" class="btn-u btn-u-default" onclick="location.href='myPageForm'">변경 취소</button>
										</div>
									</form>
								</div>
								<!-- End Member Password Edit -->
								
								<!-- Order List -->
								<div id="payment" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Order List</h2>
									<p>Please check the details you have ordered.</p>
									<br>
									<table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>날짜</th>
                                        <th>상품 정보</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="orderList" items="${orderList}">
                                    <tr>
                                        <td style="width:150px;"><form class="sky-form">
                                        <label class="label">${orderList.reg_date}</label></form></td>
                                        <td><div style="width:110px; float:left;margin-right:10px;">
                                        <img style="height:80px;"src="resources/upload/lectureImg/${orderList.img}" class="img-responsive hover-effect" alt="" />
                                        </div>
                                        <div><form class="sky-form">
                                        <label class="label"><span class=" icon-tag"></span>&nbsp;&nbsp;${orderList.subj_name}</label>
                                        <label class="label"><span class=" icon-book-open"></span>&nbsp;&nbsp;수업명 : ${orderList.lect_name}</label>
                                        <label class="label">&nbsp;&nbsp;&nbsp;&nbsp; 교재명 : ${orderList.book_name }&nbsp;&nbsp;&nbsp;&nbsp;
                                        	수업시간 : ${orderList.begintime}~${orderList.endtime}</label>
                                        <hr></form></div>
                                        <div style="margin-left:120px;"><form class="sky-form">
                                        <label class="label"><span class=" icon-user-female"></span>&nbsp;&nbsp;강사 : ${orderList.name}</label>
                                        <label>${orderList.price }원</label>
                                        </form></div></td>
                                        
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
								</div>
								<!-- End Order List -->
								
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