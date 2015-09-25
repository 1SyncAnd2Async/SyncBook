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
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left"></h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li><a href="#">Pages</a></li>
					<li class="active">Order Page</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content height-500">
			<!-- Write Your HTML Codes Here -->
			<div class="tab-v1">
				<div class="tab-content">
					<!-- Success Forms -->
					<div class="tab-pane fade in active" id="home-1">
						<form action="order" method="post" class="sky-form" id="selectTeacher">
							<header>주문하기</header>
							<fieldset>
								<section>
									<h4><b> 1. 과목 정보 </b></h4>
									<div class="icon-check"> <font color="gray">선택된 과목이 원하시는 강의인지 다시 한번 확인하시기 바랍니다.</font></div><br>
									<table class="table table-striped">
										<thead>
											<tr>
												<th>강의명</th>
												<th>강사</th>
												<th>수강시간</th>
												<th>수강료</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
													${Class.lect_name}
													<input type="hidden" name="assign_num" value="${Class.assign_num}">
												</td>
												<td>${Class.name}</td>
												<td>${Class.day} / ${Class.begintime} ~ ${Class.endtime}</td>
												<td>${Class.price} 원</td>
											</tr>
										</tbody>
									</table>
								</section>
							</fieldset>
							<fieldset>
								<section>
									<h4><b> 2. 주문자 정보 </b></h4>
									<table class="table" style="width: 70%">
										<tr>
											<td bgcolor="#F9F9F9"><b>이름</b></td>
											<td>
												${sessionScope.member.name}
												<input type="hidden" name="member_id" value="${sessionScope.member.id}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>휴대폰</b></td>
											<td>
												<input type="tel" name="phone" value="${sessionScope.member.phone}">
												<br><font size="2" color="gray">비상시 연락 가능한 연락처를 기재해주세요.</font>
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>E-mail</b></td>
											<td>
												<input type="text" name="email" value="${sessionScope.member.email}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>우편번호</b></td>
											<td>
												<input type="text" name="post1" id="post1" value="${sessionScope.post1}">
												<input type="text" name="post2" id="post2" value="${sessionScope.post2}">
												<input type="button" onclick="openDaumPostcode()" value="우편번호 찾기">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>주소</b></td>
											<td>
												<input type="text" name="address" id="address" value="${sessionScope.member.address}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>상세주소</b></td>
											<td>
												<input type="text" name="detail_address" id="detail_address" value="${sessionScope.member.detail_address}">
												<br><font size="2" color="gray">교재를 수령할 정확한 주소를 기재해주세요.</font>
											</td>
										</tr>
									</table>
								</section>
							</fieldset>
							<fieldset>
								<section>
									<h4><b> 3. 결제 정보 </b></h4>
									<table class="table" style="width: 70%">
										<tr>
											<td bgcolor="#F9F9F9"><b>최종 결제금액</b></td>
											<td><font color="red"><b><font size="6">${Class.price}</font> 원</b></font></td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>결제방법</b></td>
											<td>
												<input type="radio" name="pay"> 신용카드 <br>
												<input type="radio" name="pay"> 실시간 계좌이체 <br>
												<input type="radio" name="pay"> 휴대폰 결제
											</td>
										</tr>
									</table>
									&nbsp;<div class="icon-check"> <b>결제시 수강료 환불 규정 안내</b></div><br>
									&nbsp;수강 취소는 학원의 설립·운영 및 과외 교숩에 관한 법률에 따른 수강료 반환기준에 의거하여 수강 취소 및 환불이 가능합니다.
								</section>
							</fieldset>
							<fieldset>
								<section>
									<div align="center">
										<input type="submit" value="결제하기" class="btn-u btn-u-blue pulse-grow">
										<input type="button" value="취소하기" class="btn-u" onclick="location.href='orderCancel?lect_num=${Class.lect_num}'">
									</div>
								</section>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>