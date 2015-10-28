<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	 <div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">회원 프로필</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="memberList?page=1">회원 목록</a></li>
                	<li class="active">회원 프로필</li>
            	</ul>
            
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	</div>
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	    <div class="row">
        	<div class="col-md-12">
        	<div class="profile-body margin-bottom-20">
						<div class="tab-v1">
							<ul class="nav nav-justified nav-tabs">
								<li class="active"><a data-toggle="tab" href="#profile">프로필</a></li>
								<li><a data-toggle="tab" href="#payment">주문내역</a></li>
							</ul>
							<div class="tab-content">
								<!-- Member Profile Edit -->
								<div id="profile" class="profile-edit tab-pane fade in active">
									
										<dl class="dl-horizontal">
											<dt>
												<strong>사진 </strong>
											</dt>
											<dd>
												<img style="height:200px;" src="resources/upload/memberImg/${member.img}" alt="">
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
                                        <td style="width:150px;"><form class="sky-form" style="border:0px;">
                                        <label class="label">${orderList.reg_date}</label></form></td>
                                        <td><div style="width:110px; float:left;margin-right:10px;">
                                        <img style="height:80px;"src="resources/upload/lectureImg/${orderList.img}" class="img-responsive hover-effect" alt="" />
                                        </div>
                                        <div><form class="sky-form" style="border:0px;">
                                        <label class="label"><span class=" icon-tag"></span>&nbsp;&nbsp;${orderList.subj_name}</label>
                                        <label class="label"><span class=" icon-book-open"></span>&nbsp;&nbsp;수업명 : ${orderList.lect_name}</label>
                                        <label class="label">&nbsp;&nbsp;&nbsp;&nbsp; 교재명 : ${orderList.book_name }&nbsp;&nbsp;&nbsp;&nbsp;
                                        	수업시간 : ${orderList.begintime}~${orderList.endtime}</label>
                                        <hr></form></div>
                                        <div style="margin-left:120px;"><form class="sky-form" style="border:0px;">
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
				</div>
				
    	</div>
 
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>