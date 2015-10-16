<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">회원가입</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">Join</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	    <div class="container content-sm" style="padding-left:250px;">
        	    	
        <div class="row" >
        	<a href="memberJoinForm">
            <div class="col-md-4 content-boxes-v6 md">
                <i class="rounded-x icon-note"></i>
                <h1 class="title-v3-md text-uppercase margin-bottom-10">학생</h1>
                <p>At vero eos et accusato odio dignissimos ducimus qui blanditiis praesentium voluptatum.</p>
            </div>
            </a>
            <a href="teacherJoinForm">
            <div class="col-md-4 content-boxes-v6 md">
                <i class="rounded-x icon-briefcase"></i>
                <h2 class="title-v3-md text-uppercase margin-bottom-10">강사</h2>
                <p>At vero eos et accusato odio dignissimos ducimus qui blanditiis praesentium voluptatum.</p>
            </div>
            </a>
        </div><!--/row-->
    </div><!--/container-->
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>