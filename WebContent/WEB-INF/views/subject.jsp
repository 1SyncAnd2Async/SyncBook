<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<div class="container">
				<h1 class="pull-left">Subject</h1>
				<ul class="pull-right breadcrumb">
					<li><a href="index">Home</a></li>
					<li class="active">Subject</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content ===-->
		<div class="container content">
			<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
						<div class="col-md-8">
							<!--Basic Table-->
							<div class="panel panel-green margin-bottom-40">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-tasks"></i> ���� ���
									</h3>
								</div>
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>�з�</th>
											<th>�����</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.subject_num}</td>
												<td>${list.category}</td>
												<td>${list.subject_name}</td>
												<td>
													<button class="btn btn-danger btn-xs" onclick="location.href='deleteSubject?subject_num='+${list.subject_num}">
														<i class="fa fa-trash-o"></i>����
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!--End Basic Table-->
						</div>
						<div class="col-md-4">
							<!-- Reg-Form -->
							<form action="addSubject" method="post" id="sky-form4" class="sky-form">
								<header>���� ���</header>
								<fieldset>
									<section>
										<label>�з� </label>
										<select name="category">
											<option value="����">����</option>
											<option value="����">����</option>
											<option value="����">����</option>
											<option value="��ȸ">��ȸ</option>
											<option value="����">����</option>
										</select>
									</section>
								</fieldset>
								<fieldset>
									<section>
										<label>����� </label> <label class="input"> <i
											class="icon-append fa fa-user"></i> <input type="text"
											name="subject_name" placeholder="Subject name">
										</label>
									</section>
								</fieldset>
								<footer>
									<div class="pull-right">
										<button type="submit" class="btn-u">���</button>
									</div>
								</footer>
							</form>
							<!-- End Reg-Form -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Content ===-->
	</tiles:putAttribute>
</tiles:insertDefinition>