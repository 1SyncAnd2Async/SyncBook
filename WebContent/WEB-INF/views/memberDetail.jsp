<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">회원 프로필</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="memberList">Member List</a></li>
                	<li class="active">Member Profile</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<div class="profile-body margin-bottom-20">
						<div class="tab-v1">
							<ul class="nav nav-justified nav-tabs">
								<li class="active"><a data-toggle="tab" href="#profile">프로필</a></li>
								<li><a data-toggle="tab" href="#payment">주문내역</a></li>
								<li><a data-toggle="tab" href="#settings">회원 교재</a></li>
							</ul>
							<div class="tab-content">
								<!-- Member Profile Edit -->
								<div id="profile" class="profile-edit tab-pane fade in active">
									
										<dl class="dl-horizontal">
											<dt>
												<strong>사진 </strong>
											</dt>
											<dd>
												<img style="height:200px;" src="resources/upload/${member.img}" alt="">
											</dd>
											<hr>	
											<dt>
												<strong>아이디 </strong>
											</dt>
											<dd>
												<font class="text">${member.id}</font> 
											</dd>
											<hr>											
											<dt>
												<strong>이름 </strong>
											</dt>
											<dd>
												<font class="text">${member.name}</font> 
											</dd>
											<hr>
											<dt>
												<strong>연락처 </strong>
											</dt>
											<dd>
												<font class="text">${member.phone}</font>
											</dd>
											<hr>
											<dt>
												<strong>우편번호 </strong>
											</dt>
											<dd>
												<font class="text">${member.post}</font> 
											</dd>
											<hr>
											<dt>
												<strong>주소 </strong>
											</dt>
											<dd>
												<font class="text">${member.address}</font> 
											</dd>
											<hr>
											<dt>
												<strong>상세주소 </strong>
											</dt>
											<dd>
												<font class="text">${member.detail_address}</font>
											</dd>
											<hr>
											<dt>
												<strong>이메일 </strong>
											</dt>
											<dd>
												<font class="text">${member.email}</font>
											</dd>
										</dl>
								</div>
																
								<!-- Order List -->
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
								<!-- End Order List -->
								
								<!-- My Books -->
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
								<!-- End My Books -->
							</div>
						</div>
					</div>
				</div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>