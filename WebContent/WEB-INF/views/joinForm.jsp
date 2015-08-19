<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
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
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left">Join</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active">Join</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content Part ===-->
		<div class="container content">
			<div class="row">
				<!-- Begin Content -->
				<div class="col-md-9">
					<!-- Tabs -->
					<div class="tab-v1">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#profile-1" data-toggle="tab"
								aria-expanded="true"> 회원가입 </a></li>
						</ul>
						<div class="tab-content">
							<!-- Validation Forms -->
							<div class="tab-pane fade in active" id="profile-1">
								<form action="join" id="sky-form1" class="sky-form">
									<fieldset>
										<div class="row">
											<section class="col col-6">
												<label class="label">아이디</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="id">
													<b class="tooltip tooltip-bottom-right">Needed to enter	the website</b>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">패스워드</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="password" id="password">
													<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">패스워드 확인</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="password_confirm">
													<b class="tooltip tooltip-bottom-right">Don't forget your password</b>
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">이름</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" name="name">
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">전화번호</label> <label class="input">
													<i class="icon-append fa fa-phone"></i>
													<input type="tel" name="phone" id="phone">
												</label>
											</section>
										</div>

										<div class="row">
											<section class="col">
												<label>우편번호</label>
											</section>
											<section class="col">
												<input type="text" id="post1" name="post1"> -
												<input type="text" id="post2" name="post2">
												<input type="button" onclick="openDaumPostcode()" value="우편번호 찾기">
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">주소</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" id="address" name="address">
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-9">
												<label class="label">상세주소</label> <label class="input">
													<i class="icon-append fa fa-asterisk"></i>
													<input type="text" id="detail_address" name="detail_address">
												</label>
											</section>
										</div>
										<div class="row">
											<section class="col col-6">
												<label class="label">이메일</label> <label class="input">
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
		<!--/container-->
		<!--=== End Content Part ===-->


	</tiles:putAttribute>
</tiles:insertDefinition>