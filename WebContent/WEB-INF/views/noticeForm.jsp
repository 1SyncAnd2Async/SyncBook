<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">공지사항 글쓰기</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">공지사항</a></li>
                	<li class="active">공지사항 글쓰기</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	<div class="col-md-12 md-margin-bottom-40">
        	<!-- Write Your HTML Codes Here -->
        	<form action="noticeWrite" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>공지사항</header>

                    <fieldset>
                        <section>
                            <label class="label">제목</label>
                            <label class="input">
                                <input type="text" name="title">
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
                                <textarea rows="30" name="content"></textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                        <button type="submit" class="btn-u">등록</button>
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">이전</button>
                    </footer>
                    </form>
        </div>          
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>