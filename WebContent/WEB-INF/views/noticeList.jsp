<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">공지사항</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="panel panel-green margin-bottom-40">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-tasks"></i>공지사항</h3>
                    </div>
                    <div class="panel-body">
                        <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                    <table class="table" border="1">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th style="width:50%; margin-left:150px;">Title</th>
                                <th class="hidden-sm">Writer</th>
                                <th>Date</th>
                                <th>Hit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Mark</td>
                                <td class="hidden-sm">Otto</td>
                                <td>@mdo</td>
                                <td><span class="label label-warning">Expiring</span></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Jacob</td>
                                <td class="hidden-sm">Thornton</td>
                                <td>@fat</td>
                                <td><span class="label label-success">Success</span></td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Larry</td>
                                <td class="hidden-sm">the Bird</td>
                                <td>@twitter</td>
                                <td><span class="label label-danger">Error!</span></td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>htmlstream</td>
                                <td class="hidden-sm">Web Design</td>
                                <td>@htmlstream</td>
                                <td><span class="label label-info">Pending..</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>