<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">�����ı�</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">�����ı�</a></li>
                	<li class="active">�����ı� �ۼ�</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	<form action="reviewWrite" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>�����ı�</header>

                    <fieldset>
                        <section>
                            <label class="label">����</label>
                            <label class="input">
                                <input type="text" name="title">
                            </label>
                        </section>

                        <section>
                            <label class="label">������ : ${lecture.lect_name}</label>
                           	 <input type="hidden" name="lect_num" value="${lecture.lect_num}">
                        </section>

                        <section>
                            <label class="label">�۾��� : ${sessionScope.member.name}</label>  
                            <label class="input">
                                <input type="hidden" name="writer" value="${sessionScope.member.id}">
                            </label>          
                        </section>
                    
                        <section>
                            <label class="label">����</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content"></textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                        <button type="submit" class="btn-u">���</button>
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">����</button>
                    </footer>
                    </form>
                    
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>