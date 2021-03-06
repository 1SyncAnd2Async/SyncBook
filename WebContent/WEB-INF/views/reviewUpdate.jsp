<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">수강후기 수정</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="">수강후기</a></li>
                	<li class="active">수강후기 수정</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	<div class="col-md-12 md-margin-bottom-40">
        	<!-- Write Your HTML Codes Here -->
        	<form action="reviewUpdateOk" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>공지사항</header>

                    <fieldset>
                        <section>
                            <label class="label">제목</label>
                            <label class="input">
                            	<input type="hidden" name="review_num" value="${review.review_num}">
                                <input type="text" name="title" value="${review.title}">
                            </label>
                        </section>

                        <section>
                            <label class="label">수업명 : ${lecture.lect_name}</label>
                        </section>

                        <section>
                            <label class="label">글쓴이 : ${review.writer}</label>        
                        </section>
                    
                        <section>
                            <label class="label">내용</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content">${review.content}</textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                    	<input type="submit" class="btn-u" value="등록">
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">이전</button>
                    </footer>
                    </form>
                    
    	</div>
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>