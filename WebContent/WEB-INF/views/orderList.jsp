<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">Blank Page</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="#">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<form action="addLecture" method="post" id="sky-form4" class="sky-form" enctype="multipart/form-data">
					<header>주문 내역</header>							
					<fieldset>
						<section>
							<div class="row">
				<div class="col-md-12">
					<div class="row margin-bottom-40">
							<!--Basic Table-->
							<div class="panel panel-green margin-bottom-40">
								
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Date</th>
											<th>Id</th>
											<th>Phone</th>
											<th>Address</th>
											<th>Lecture</th>
											<th>Book</th>
											<th>Price</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="orderList" items="${orderList}">
											<tr>
												<td>${orderList.reg_num}</td>
												<td style="width:100px;">${orderList.reg_date}</td>
												<td>${orderList.member_id}</td>
												<td>${orderList.phone}</td>												
												<td>${orderList.post}<br>
													${orderList.address}<br>
													${orderList.detail_address}</td>
												<td>${orderList.lect_name}</td>
												<td>${orderList.book_name}</td>
												<td>${orderList.price} 원</td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</section>
					</fieldset>
			</form>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>