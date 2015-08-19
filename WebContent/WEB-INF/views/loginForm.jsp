<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">Login</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">Pages</a></li>
                	<li class="active">Login</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    
    	<!--=== Content Part ===-->
    	<div class="container content">
    		<div class="row">
            	<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
                	<form class="reg-page" action="login" method="post">
                    	<div class="reg-header">
                        	<h2>Login to your account</h2>
                    	</div>
                    	<div class="input-group margin-bottom-20">
                        	<span class="input-group-addon"><i class="fa fa-user"></i></span>
                        	<input type="text" name="id" placeholder="Username" class="form-control">
                    	</div>
                    	<div class="input-group margin-bottom-20">
                        	<span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        	<input type="password" name="password" placeholder="Password" class="form-control">
                    	</div>

                    	<div class="row">
                        	<div class="col-md-6 checkbox">
                            	<label><input type="checkbox"> Stay signed in</label>
                        	</div>
                        	<div class="col-md-6">
                            	<input type="submit" class="btn-u push" value="Login">
                            	<button class="btn-u btn-u-blue push" type="#">Join</button>
                        	</div>
                    	</div>
                    	<hr>
                    	<h4>Forget your Password ?</h4>
                    	<p>no worries, <a class="color-green" href="#">click here</a> to reset your password.</p>
                	</form>
            	</div>
        	</div><!--/row-->
    	</div><!--/container-->
    <!--=== End Content Part ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>