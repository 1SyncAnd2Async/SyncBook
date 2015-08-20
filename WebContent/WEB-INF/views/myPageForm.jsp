<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
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
			$("#modify_btn").show();
			$("input:file").show();
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
					<img class="img-responsive profile-img margin-bottom-20" src="resources/upload/${sessionScope.member.img}" alt="">
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

					<div class="panel-heading-v2 overflow-h">
						<h2 class="heading-xs pull-left">
							<i class="fa fa-bar-chart-o"></i> Task Progress
						</h2>
						<a href="#"><i class="fa fa-cog pull-right"></i></a>
					</div>
					<h3 class="heading-xs">
						Web Design <span class="pull-right">92%</span>
					</h3>
					<div class="progress progress-u progress-xxs">
						<div style="width: 92%" aria-valuemax="100" aria-valuemin="0"
							aria-valuenow="92" role="progressbar"
							class="progress-bar progress-bar-u"></div>
					</div>
					<h3 class="heading-xs">
						Unify Project <span class="pull-right">85%</span>
					</h3>
					<div class="progress progress-u progress-xxs">
						<div style="width: 85%" aria-valuemax="100" aria-valuemin="0"
							aria-valuenow="85" role="progressbar"
							class="progress-bar progress-bar-blue"></div>
					</div>
					<h3 class="heading-xs">
						Sony Corporation <span class="pull-right">64%</span>
					</h3>
					<div class="progress progress-u progress-xxs margin-bottom-40">
						<div style="width: 64%" aria-valuemax="100" aria-valuemin="0"
							aria-valuenow="64" role="progressbar"
							class="progress-bar progress-bar-dark"></div>
					</div>
					<hr>
					<div class="margin-bottom-50"></div>

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
								<li><a data-toggle="tab" href="#settings">내 교재</a></li>
							</ul>
							<div class="tab-content">
								<form action="updateMemberProfile" method="post" enctype="multipart/form-data">
									<div id="profile" class="profile-edit tab-pane fade in active">
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
														${msg} <i class="fa fa-pencil"></i>
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
													<input type="file" name="upfile" id="upfile" style="display: none">
												</label>
											</dd>
										</dl>
										<div class="pull-right">
											<input type="submit" class="btn-u" id="modify_btn"
												value="변경 완료" style="display: none">
											<button type="button" class="btn-u btn-u-default">변경
												취소</button>
										</div>
									</div>
								</form>

								<div id="passwordTab" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Manage your Security Settings</h2>
									<p>Change your password.</p>
									<br>
									<form class="sky-form" id="sky-form4" action="#">
										<dl class="dl-horizontal">
											<dt>Username</dt>
											<dd>
												<section>
													<label class="input"> <i
														class="icon-append fa fa-user"></i> <input type="text"
														placeholder="Username" name="username"> <b
														class="tooltip tooltip-bottom-right">Needed to enter
															the website</b>
													</label>
												</section>
											</dd>
											<dt>Email address</dt>
											<dd>
												<section>
													<label class="input"> <i
														class="icon-append fa fa-envelope"></i> <input
														type="email" placeholder="Email address" name="email">
														<b class="tooltip tooltip-bottom-right">Needed to
															verify your account</b>
													</label>
												</section>
											</dd>
											<dt>Enter your password</dt>
											<dd>
												<section>
													<label class="input"> <i
														class="icon-append fa fa-lock"></i> <input type="password"
														id="password" name="password" placeholder="Password">
														<b class="tooltip tooltip-bottom-right">Don't forget
															your password</b>
													</label>
												</section>
											</dd>
											<dt>Confirm Password</dt>
											<dd>
												<section>
													<label class="input"> <i
														class="icon-append fa fa-lock"></i> <input type="password"
														name="passwordConfirm" placeholder="Confirm password">
														<b class="tooltip tooltip-bottom-right">Don't forget
															your password</b>
													</label>
												</section>
											</dd>
										</dl>
										<label class="toggle toggle-change"><input
											type="checkbox" checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Remember password</label> <br>
										<section>
											<label class="checkbox"><input type="checkbox"
												id="terms" name="terms"><i></i><a href="#">I
													agree with the Terms and Conditions</a></label>
										</section>
										<button type="button" class="btn-u btn-u-default">Cancel</button>
										<button class="btn-u" type="submit">Save Changes</button>
									</form>
								</div>

								<div id="payment" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Manage your Payment Settings</h2>
									<p>Below are the payment options for your account.</p>
									<br>
									<form class="sky-form" id="sky-form" action="#">
										<!--Checkout-Form-->
										<section>
											<div class="inline-group">
												<label class="radio"><input type="radio" checked=""
													name="radio-inline"><i class="rounded-x"></i>Visa</label> <label
													class="radio"><input type="radio"
													name="radio-inline"><i class="rounded-x"></i>MasterCard</label>
												<label class="radio"><input type="radio"
													name="radio-inline"><i class="rounded-x"></i>PayPal</label>
											</div>
										</section>

										<section>
											<label class="input"> <input type="text" name="name"
												placeholder="Name on card">
											</label>
										</section>

										<div class="row">
											<section class="col col-10">
												<label class="input"> <input type="text" name="card"
													id="card" placeholder="Card number">
												</label>
											</section>
											<section class="col col-2">
												<label class="input"> <input type="text" name="cvv"
													id="cvv" placeholder="CVV2">
												</label>
											</section>
										</div>

										<div class="row">
											<label class="label col col-4">Expiration date</label>
											<section class="col col-5">
												<label class="select"> <select name="month">
														<option disabled="" selected="" value="0">Month</option>
														<option value="1">January</option>
														<option value="1">February</option>
														<option value="3">March</option>
														<option value="4">April</option>
														<option value="5">May</option>
														<option value="6">June</option>
														<option value="7">July</option>
														<option value="8">August</option>
														<option value="9">September</option>
														<option value="10">October</option>
														<option value="11">November</option>
														<option value="12">December</option>
												</select> <i></i>
												</label>
											</section>
											<section class="col col-3">
												<label class="input"> <input type="text"
													placeholder="Year" id="year" name="year">
												</label>
											</section>
										</div>
										<button type="button" class="btn-u btn-u-default">Cancel</button>
										<button class="btn-u" type="submit">Save Changes</button>
										<!--End Checkout-Form-->
									</form>
								</div>

								<div id="settings" class="profile-edit tab-pane fade">
									<h2 class="heading-md">Manage your Notifications.</h2>
									<p>Below are the notifications you may manage.</p>
									<br>
									<form class="sky-form" id="sky-form3" action="#">
										<label class="toggle"><input type="checkbox"
											checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Email notification</label>
										<hr>
										<label class="toggle"><input type="checkbox"
											checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Send me email notification when a user
											comments on my blog</label>
										<hr>
										<label class="toggle"><input type="checkbox"
											checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Send me email notification for the
											latest update</label>
										<hr>
										<label class="toggle"><input type="checkbox"
											checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Send me email notification when a user
											sends me message</label>
										<hr>
										<label class="toggle"><input type="checkbox"
											checked="" name="checkbox-toggle-1"><i
											class="no-rounded"></i>Receive our monthly newsletter</label>
										<hr>
										<button type="button" class="btn-u btn-u-default">Reset</button>
										<button class="btn-u" type="submit">Save Changes</button>
									</form>
								</div>
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