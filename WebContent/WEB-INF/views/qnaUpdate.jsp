<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">Q & A 수정</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="qnaList">Q & A</a></li>
                	<li class="active">Q & A 수정</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	<div class="col-md-12 md-margin-bottom-40">
        	<!-- Write Your HTML Codes Here -->
        	<form action="qnaUpdateOk" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>공지사항</header>

                    <fieldset>
                        <section>
                            <label class="label">제목</label>
                            <label class="input">
                            	<input type="hidden" name="qna_num" value="${qna.qna_num}">
                                <input type="text" name="title" value="${qna.title}">
                            </label>
                        </section>

                        <section>
                            <label class="label">파일</label>
                            <label for="file" class="input input-file">
                                <div class="button"><input type="file" id="upfile" name="upfile" onchange="this.parentNode.nextSibling.value = this.value">Browse</div><input type="text" readonly>
                            </label>
                        </section>

                        <section>
                            <label class="label">글쓴이 : 관리자</label>  
                            <label class="input">
                                <input type="hidden" name="writer" value="관리자">
                            </label>          
                        </section>
                    
                        <section>
                            <label class="label">내용</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content">${qna.content}</textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                    	<input type="submit" class="btn-u" value="등록">
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">이전</button>
                    </footer>
                    </form>
                    
    	</div></div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>