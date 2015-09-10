<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    	<div class="row pricing-table-v5 no-space-pricing">
    		<c:forEach var="list" items="${list}">
            <div class="col-md-3 col-sm-3 col-xs-6" style="margin-right:20px;">
                <div class="pricing-v5 pricing-v5-blue ">
                    <div class="pricing-v5-head">
                        <h4 class="text-center">${list.lect_name }</h4>
                        <div class="pricing-rounded"><h5 class="text-center">${list.price }<span>Won</span><i>/Month</i></h5></div>
                    </div>
                    <ul class="list-unstyled pricing-v5-content text-center">
                        <li><span class="icon-user-female">강사 :</span> ${list.teacher_name }</li>
                        <li><span class="icon-drawer">과목 : </span>${list.subj_name }</li>
                        <li><span class="icon-envelope-open">교재 : </span>${list.book_name }</li>
                        <li><span class="icon-layers">요일 : </span>${list.day }</li>
                        <li><span class="icon-wrench">시간 : </span>${list.beginTime }~${list.endTime }</li>
                        <li>
                            <a href="#" class="btn-u btn-u-blue">
                                <i class="price-corner"></i>
                                <i class="price-corner-2"></i>
                                Purchase Now
                                <span class="icon-basket"></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            </c:forEach>
            </div>
            </div>
           
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>