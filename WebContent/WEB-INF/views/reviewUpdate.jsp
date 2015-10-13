<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">�����ı� ����</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">�����ı�</a></li>
                	<li class="active">�����ı� ����</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	<form action="reviewUpdateOk" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>��������</header>

                    <fieldset>
                        <section>
                            <label class="label">����</label>
                            <label class="input">
                            	<input type="hidden" name="review_num" value="${review.review_num}">
                                <input type="text" name="title" value="${review.title}">
                            </label>
                        </section>

                        <section>
                            <label class="label">������</label>
                            <label for="file" class="input input-file">
                                <div class="button"><input type="file" id="upfile" name="upfile" onchange="this.parentNode.nextSibling.value = this.value">Browse</div><input type="text" readonly>
                            </label>
                        </section>

                        <section>
                            <label class="label">�۾��� : </label>  
                            <label class="input">
                                <input type="hidden" name="writer" value="">
                            </label>          
                        </section>
                    
                        <section>
                            <label class="label">����</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content">${review.content}</textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                    	<input type="submit" class="btn-u" value="���">
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">����</button>
                    </footer>
                    </form>
                    
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>