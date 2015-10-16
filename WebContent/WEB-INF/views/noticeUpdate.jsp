<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left">Blank Page</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
        	<form action="noticeUpdateOk" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>��������</header>

                    <fieldset>
                        <section>
                            <label class="label">����</label>
                            <label class="input">
                            	<input type="hidden" name="notice_num" value="${notice.notice_num}">
                                <input type="text" name="title" value="${notice.title}">
                            </label>
                        </section>

                        <section>
                            <label class="label">����</label>
                            <label for="file" class="input input-file">
                                <div class="button"><input type="file" id="upfile" name="upfile" onchange="this.parentNode.nextSibling.value = this.value">Browse</div><input type="text" readonly>
                            </label>
                        </section>

                        <section>
                            <label class="label">�۾��� : ������</label>  
                            <label class="input">
                                <input type="hidden" name="writer" value="������">
                            </label>          
                        </section>
                    
                        <section>
                            <label class="label">����</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content">${notice.content}</textarea>
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