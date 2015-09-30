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
							<header>�ֹ��ϱ�</header>
							<fieldset>
								<section>
									<h4><b> 1. ���� ���� </b></h4>
									<div class="icon-check"> <font color="gray">���õ� ������ ���Ͻô� �������� �ٽ� �ѹ� Ȯ���Ͻñ� �ٶ��ϴ�.</font></div><br>
									<table class="table table-striped">
										<thead>
											<tr>
												<th>���Ǹ�</th>
												<th>����</th>
												<th>�����ð�</th>
												<th>������</th>
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
												<td>${Class.price} ��</td>
											</tr>
										</tbody>
									</table>
								</section>
							</fieldset>
							<fieldset>
								<section>
									<h4><b> 2. �ֹ��� ���� </b></h4>
									<table class="table" style="width: 70%">
										<tr>
											<td bgcolor="#F9F9F9"><b>�̸�</b></td>
											<td>
												${sessionScope.member.name}
												<input type="hidden" name="member_id" value="${sessionScope.member.id}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>�޴���</b></td>
											<td>
												<input type="tel" name="phone" value="${sessionScope.member.phone}">
												<br><font size="2" color="gray">���� ���� ������ ����ó�� �������ּ���.</font>
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>E-mail</b></td>
											<td>
												<input type="text" name="email" value="${sessionScope.member.email}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>�����ȣ</b></td>
											<td>
												<input type="text" name="post1" id="post1" value="${sessionScope.post1}">
												<input type="text" name="post2" id="post2" value="${sessionScope.post2}">
												<input type="button" onclick="openDaumPostcode()" value="�����ȣ ã��">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>�ּ�</b></td>
											<td>
												<input type="text" name="address" id="address" value="${sessionScope.member.address}">
											</td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>���ּ�</b></td>
											<td>
												<input type="text" name="detail_address" id="detail_address" value="${sessionScope.member.detail_address}">
												<br><font size="2" color="gray">���縦 ������ ��Ȯ�� �ּҸ� �������ּ���.</font>
											</td>
										</tr>
									</table>
								</section>
							</fieldset>
							<fieldset>
								<section>
									<h4><b> 3. ���� ���� </b></h4>
									<table class="table" style="width: 70%">
										<tr>
											<td bgcolor="#F9F9F9"><b>���� �����ݾ�</b></td>
											<td><font color="red"><b><font size="6">${Class.price}</font> ��</b></font></td>
										</tr>
										<tr>
											<td bgcolor="#F9F9F9"><b>�������</b></td>
											<td>
												<input type="radio" name="pay"> �ſ�ī�� <br>
												<input type="radio" name="pay"> �ǽð� ������ü <br>
												<input type="radio" name="pay"> �޴��� ����
											</td>
										</tr>
									</table>
									&nbsp;<div class="icon-check"> <b>������ ������ ȯ�� ���� �ȳ�</b></div><br>
									&nbsp;���� ��Ҵ� �п��� ������� �� ���� ������ ���� ������ ���� ������ ��ȯ���ؿ� �ǰ��Ͽ� ���� ��� �� ȯ���� �����մϴ�.
								</section>
							</fieldset>
							<fieldset>
								<section>
									<div align="center">
										<input type="submit" value="�����ϱ�" class="btn-u btn-u-blue pulse-grow">
										<input type="button" value="����ϱ�" class="btn-u" onclick="location.href='orderCancel?lect_num=${Class.lect_num}'">
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