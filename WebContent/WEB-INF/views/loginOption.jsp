<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">로그인</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li class="active">Login</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	    <div class="container content-sm">
        	    	
        <div class="row" >
        	<a href="loginForm?login=login">
            <div class="col-md-4 content-boxes-v6 md">
                <i class="rounded-x icon-note"></i>
                <h1 class="title-v3-md text-uppercase margin-bottom-10">학생</h1>
                <p>At vero eos et accusato odio dignissimos ducimus qui blanditiis praesentium voluptatum.</p>
            </div>
            </a>
            <a href="loginForm?login=teacherLogin">
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