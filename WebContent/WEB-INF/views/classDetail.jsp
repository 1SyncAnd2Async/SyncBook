<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(function(){
	$("#selectTeacher").change(function(){
		$.ajax({
			url: "selectTimetable",
			data: "lect_num=" + $("#lect_num").val() + "&teacher_id=" + $("#teacher_id").val(),
			success:function(data){
				 $("#selectTimetable").html(data);
			},
			error:function(){
				alert("error!");
			}
		});	
	});
});
</script>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Breadcrumbs ===-->
    	<div class="breadcrumbs">
        	<div class="container">
            	<h1 class="pull-left"> </h1>
            	<ul class="pull-right breadcrumb">
                	<li><a href="index">Home</a></li>
                	<li><a href="#">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
        	<!-- Write Your HTML Codes Here -->
                <div class="tab-v1">
                    
                    <div class="tab-content">
                    
                        <!-- Success Forms -->
                    <div class="tab-pane fade in active" id="home-1">
                      <form action="#" class="sky-form" id="selectTeacher">
                        <header>${lecture.lect_name}</header>
						<input type="hidden" name="lect_num" value="${lecture.lect_num}" id="lect_num"/>
						<fieldset>
                         <section>
                             <img src="resources/upload/lectureImg/${lecture.img }" class="img-responsive hover-effect" alt="" />
                         </section>
                     	</fieldset>
						<fieldset>
                         <section>
                             <label class="label"><pre>${lecture.explanation }</pre></label>
                             
                         </section>
                     	</fieldset>
                     	<fieldset>
                         <section>
                             <label class="label">강사를 선택해 주세요.</label>
                             <label class="select state-success" >
                             	
                                 <select name="teacher_id" id="teacher_id">
                                 	<option value="">강사 선택</option>
                                 	<c:forEach var="teacherList" items="${classTeacherList}">
                                     
                                     <option value="${teacherList.teacher_id }">${teacherList.name }</option>
                                     </c:forEach>
                                 </select>
                                 <i></i>
                             </label>
                             <div class="note note-success">Thanks for your selection.</div>
                         </section>
                     	</fieldset>
                     
                     <fieldset>
                         <section>
                             <span id="selectTimetable">
                             </span>
                   
                             <div class="note note-success">Thanks for your selection.</div>
                         </section>
                     </fieldset>
                     </form>
                     </div>
                     
                     </div>
                     </div>
                    
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>