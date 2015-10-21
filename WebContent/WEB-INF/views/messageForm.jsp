<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
        	<div class="col-md-12 md-margin-bottom-40">
            	<h1 class="pull-left">질문하기</h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index.html">Home</a></li>
                	<li><a href="memberClassList?id=${sessionScope.member.id}">내 강의 목록</a></li>
                	<li class="active">질문하기</li>
            	</ul>
            	</div>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	<div class="col-md-12 md-margin-bottom-40">
        	<!-- Write Your HTML Codes Here -->
        	<form action="messageWrite" enctype="multipart/form-data" method="post" class="sky-form">
                    <header>질문하기</header>

                    <fieldset>
                        <section>
                        	<c:choose>
                        	<c:when test="${sessionScope.member.id != null}">
	                            <label class="label">받는이 : ${memberClassDetail.teacher_id}</label>
	                            <input type="hidden" name="receiver" value="${memberClassDetail.teacher_id}">
	                            <label class="label">보내는이 : ${sessionScope.member.id}</label>
	                            <input type="hidden" name="sender" value="${sessionScope.member.id}">
                            </c:when>
                            <c:when test="${sessionScope.teacher.id != null}">
                            	<label class="label">받는이 : ${memberClassDetail.member_id}</label>
	                            <input type="hidden" name="receiver" value="${memberClassDetail.member_id}">
	                            <label class="label">보내는이 : ${sessionScope.teacher.id}</label>
	                            <input type="hidden" name="sender" value="${sessionScope.teacher.id}">
                            </c:when>
                            </c:choose>
                        </section>
                        <section>
                        	<input type="hidden" name="assign_num" value="${memberClassDetail.assign_num}">                        	
                            <label class="label">내용</label>
                            <label class="textarea">                         
                                <textarea rows="30" name="content"></textarea>
                            </label>
                            <div class="note"><strong>Note:</strong> height of the textarea depends on the rows attribute.</div>
                        </section>      
                    </fieldset>
                    <footer>
                        <button type="submit" class="btn-u">보내기</button>
                        <button type="button" class="btn-u btn-u-default" onclick="window.history.back();">이전</button>
                    </footer>
                    </form>
        </div>          
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>