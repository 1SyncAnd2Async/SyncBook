<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">학습신청</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="#">학습</a></li>
                	<li class="active">학습신청</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content">
    	<div class="row">
        	<div class="col-md-12">
            	<div class="headline"><h2>학습 신청</h2></div>

                <!-- Clients Block-->
                <c:forEach var="classList" items="${classList}">
                <div class="row clients-page">
                    <div class="col-md-2">
                        <img src="resources/upload/lectureImg/${classList.img}" class="img-responsive hover-effect" alt="" />
                    </div>
                    <div class="col-md-10">
                        <h3><a href="classDetail?lect_num=${classList.lect_num}">${classList.lect_name}</a></h3>
                        <ul class="list-inline">
                            <li><i class="fa fa-map-marker color-green"></i> 과목 : ${classList.subj_name} </li>
                            <li><i class="fa fa-briefcase color-green"></i> 교재 : ${classList.book_name}</li>
                        </ul>
                        <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati</p>
                        <p>Olerano ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna edetquam lacus. Fusce condimentum eleifend enim a sint occaecati feugiat..</p>
                    </div>
                </div>
                <hr>
                </c:forEach>
                <!-- End Clients Block-->

                <!-- Pagination -->
                <div class="text-center md-margin-bottom-30">
                    <ul class="pagination">
                        <li><a href="#">«</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li class="active"><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">»</a></li>
                    </ul>
                </div>
                <!-- End Pagination -->
            </div><!--/col-md-9-->
        </div><!--/row-->
    </div><!--/container-->
    <!--=== End Content Part ===-->
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>