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
    	 <div class="row clients-page">
                    <div class="col-md-2">
                        <img src="assets/img/clients2/baderbrau.png" class="img-responsive hover-effect" alt="" />
                    </div>
                    <div class="col-md-10">
                        <h3>Cisco Systems, Inc</h3>
                        <ul class="list-inline">
                            <li><i class="fa fa-map-marker color-green"></i> USA</li>
                            <li><i class="fa fa-globe color-green"></i> <a class="linked" href="#">http://www.example.com</a></li>
                            <li><i class="fa fa-briefcase color-green"></i> Web Design &amp; Development</li>
                        </ul>
                        <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati</p>
                        <p>Olerano ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna edetquam lacus. Fusce condimentum eleifend enim a sint occaecati feugiat..</p>
                    </div>
                </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>