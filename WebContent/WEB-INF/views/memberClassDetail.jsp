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
                	<li><a href="index">Home</a></li>
                	<li><a href="#">Pages</a></li>
                	<li class="active">Blank Page</li>
            	</ul>
        	</div><!--/container-->
    	</div><!--/breadcrumbs-->
    	<!--=== End Breadcrumbs ===-->
    	
    	<!--=== Content ===-->
    	<div class="container content height-500">
    	
    		 <div class="tab-v1">
                    
                    <div class="tab-content">
                    
                        <!-- Success Forms -->
                    <div class="tab-pane fade in active" id="home-1">
                      <form action="#" class="sky-form" id="selectTeacher">
                        <header><span class="icon-bubbles"></span>&nbsp;&nbsp;${memberClassDetail.lect_name}</header>
						<fieldset>
                         <section>
                         	<div style="float:left; width:33%; ">
                         	<img style="margin-top:0px; height : 250px;"src="resources/upload/lectureImg/${memberClassDetail.lect_img}" class="img-responsive hover-effect" alt="" />
                             </div>
                             <div style="float:left; margin-left:10px; width:62%; height:250px;">
                             <pre style="margin-auto; height:100%;"><span class=" icon-tag">&nbsp;${memberClassDetail.subj_name}</span>
                             <br>${memberClassDetail.explanation }</pre>
                             </div>
                         </section>
                     	</fieldset>
                     	
                     	<fieldset>
                             <div style="width:100%;"><label><span class=" icon-user-female"></span>&nbsp;&nbsp;강사</label></div>                        	
                             <div style="float:left; width:20%">
                             <img style="width:100%;"src="resources/upload/teacherImg/${memberClassDetail.teacher_img}" class="img-responsive hover-effect" alt="" />
				           	 </div>
				           	 <div style="float:left;  margin-top:0px; margin-left: 30px; width:70%; padding-top:40px;">	
				        	 <label class="label">이름 : ${memberClassDetail.teacher_name }</label>
				        	 <label class="label">E-Mail : ${memberClassDetail.teacher_email}</label>
				        	 <label class="label">번호 : ${memberClassDetail.teacher_phone}</label>
				        	 </div>
                     	</fieldset>
                     
                     <fieldset>
                     <div style="width:100%;"><label><span class=" icon-book-open"></span>&nbsp;&nbsp;교재</label></div>
                         <section>
                            <label class="label"> ${memberClassDetail.book_name }</label>
                         </section>
                     </fieldset>
                     <fieldset>
                      <div style="width:100%;"><label><span class="icon-earphones-alt"></span>&nbsp;&nbsp;수업 참여</label></div>
                     <div style="padding-left:40%; margin-bottom:20px;">
                     <button class="btn-u btn-u-lg">수업 듣기</button>
                     </div>
                     </fieldset>
                     <fieldset>
                     <div style="width:100%;"><label><span class=" icon-doc"></span>&nbsp;&nbsp;수업 자료</label></div>
                      <section>
                             
                      </section>
                     </fieldset>
                     </form>
                     </div>
                     
                     </div>
                     </div>
        	<!-- Write Your HTML Codes Here -->
        	
        	
        	
        	
        	
        	
        	
    	</div>
    	<!--=== End Content ===-->
    </tiles:putAttribute>
</tiles:insertDefinition>