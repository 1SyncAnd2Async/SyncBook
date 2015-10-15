<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<!--=== Slider ===-->
    <div class="slider-inner">
        <div id="da-slider" class="da-slider">
            <!-- <div class="da-slide">
                <h2><i>CLEAN &amp; FRESH</i> <br /> <i>FULLY RESPONSIVE</i> <br /> <i>DESIGN</i></h2>
                <p><i>Lorem ipsum dolor amet</i> <br /> <i>tempor incididunt ut</i> <br /> <i>veniam omnis </i></p>
                <div class="da-img"><img class="img-responsive" src="resources/assets/plugins/parallax-slider/img/1.png" alt=""></div>
            </div>
            <div class="da-slide">
                <h2><i>RESPONSIVE VIDEO</i> <br /> <i>SUPPORT AND</i> <br /> <i>MANY MORE</i></h2>
                <p><i>Lorem ipsum dolor amet</i> <br /> <i>tempor incididunt ut</i></p>
                <div class="da-img">
                    <iframe src="http://player.vimeo.com/video/47911018" width="530" height="300" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
                </div>
            </div>
            <div class="da-slide">
                <h2><i>USING BEST WEB</i> <br /> <i>SOLUTIONS WITH</i> <br /> <i>HTML5/CSS3</i></h2>
                <p><i>Lorem ipsum dolor amet</i> <br /> <i>tempor incididunt ut</i> <br /> <i>veniam omnis </i></p>
                <div class="da-img"><img src="resources/assets/plugins/parallax-slider/img/html5andcss3.png" alt="image01" /></div>
            </div>
            <div class="da-arrows">
                <span class="da-arrows-prev"></span>
                <span class="da-arrows-next"></span>
            </div> -->
        </div>
    </div><!--/slider-->
    <!--=== End Slider ===-->

    <!--=== Purchase Block ===-->
    <div class="purchase">
        <div class="container">
            <div class="row">
                <div class="col-md-9 animated fadeInLeft">
                    <span>Unify is a clean and fully responsive incredible Template.</span>
                    <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi  vehicula sem ut volutpat. Ut non libero magna fusce condimentum eleifend enim a feugiat corrupti quos.</p>
                </div>
                <div class="col-md-3 btn-buy animated fadeInRight">
                    <a href="#" class="btn-u btn-u-lg"><i class="fa fa-cloud-download"></i> Download Now</a>
                </div>
            </div>
        </div>
    </div><!--/row-->
    <!-- End Purchase Block -->

    <!--=== Content Part ===-->
    <div class="container content-sm">
		
    	<!-- Recent Works -->
        <div class="headline"><h2>인기 강의</h2></div>
        <div class="row margin-bottom-20">
         <c:forEach begin="0" end="3" var="bestClassList" items="${bestClassList}">
            <div class="col-md-3 col-sm-6">
                <div class="thumbnails thumbnail-style thumbnail-kenburn">
                	<div class="thumbnail-img">
                        <div class="overflow-hidden">
                            <img src="resources/upload/lectureImg/${bestClassList.img}" class="img-responsive hover-effect" alt="" />
                        </div>
                        <a class="btn-more hover-effect" href="classDetail?lect_num=${bestClassList.lect_num}">read more +</a>
                    </div>
                    <div class="caption">
                        <h3><a class="hover-effect" href="classDetail?lect_num=${bestClassList.lect_num}">${bestClassList.lect_name}</a></h3>
                        <div style="overflow:hidden; text-overflow:ellipsis; word-break: break-word; -webkit-line-clamp: 3; display: -webkit-box; -webkit-box-orient: vertical;">${bestClassList.explanation}</div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    	<!-- End Recent Works -->
		
    	<!-- Info Blokcs -->
    	<div class="row margin-bottom-30">
        	<!-- Welcome Block -->
    		<div class="col-md-8 md-margin-bottom-40">
    			<div class="headline"><h2>Best수강후기</h2></div>
                <div class="row">
                    <div class="col-sm-4">
                        <img class="img-responsive margin-bottom-20" src="resources/upload/memberImg/${bestReview.img}" alt="">
                    </div>
                    <div class="col-sm-8">
                     	<p style="overflow:hidden; text-overflow:ellipsis; word-break: break-word; -webkit-line-clamp:1; 
                     	display: -webkit-box; -webkit-box-orient: vertical;">${bestReview.title}</p>
                     	<div style="overflow:hidden; text-overflow:ellipsis; word-break: break-word; -webkit-line-clamp: 6; 
                     	display: -webkit-box; -webkit-box-orient: vertical;">
                        ${bestReview.content}                        
                        </div>
                        <br>
                        <ul class="list-unstyled margin-bottom-20">
                            <li><i class="fa fa-check color-green"></i>수업명 : <a href="classDetail?lect_num=${bestReview.lect_num}">${bestReview.lect_name}</a></li>
                        </ul>
                    </div>
                </div>

                <blockquote class="hero-unify">
                   
                    <small>${bestReview.writer}&nbsp;&nbsp;&nbsp;${bestReview.write_date}</small>
                </blockquote>
            </div><!--/col-md-8-->

            <!-- Latest Shots -->
            <div class="col-md-4">
    			<div class="headline"><h2>Latest Shots</h2></div>
    			<div id="myCarousel" class="carousel slide carousel-v1">
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="resources/assets/img/main/img4.jpg" alt="">
                            <div class="carousel-caption">
                                <p>Facilisis odio, dapibus ac justo acilisis gestinas.</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="resources/assets/img/main/img2.jpg" alt="">
                            <div class="carousel-caption">
                                <p>Cras justo odio, dapibus ac facilisis into egestas.</p>
                            </div>
                            </div>
                        <div class="item">
                            <img src="resources/assets/img/main/img24.jpg" alt="">
                            <div class="carousel-caption">
                                <p>Justo cras odio apibus ac afilisis lingestas de.</p>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-arrow">
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
    			</div>
            </div><!--/col-md-4-->
    	</div>
    	<!-- End Info Blokcs -->

        <!-- Owl Clients v1 -->
        <div class="headline"><h2>Our Teachers</h2></div>
        <div class="owl-clients-v1" style="margin-bottom:50px;">
        	<c:forEach var="teacherList" items="${teacherList}">
            <div class="item">
                <img src="resources/upload/teacherImg/${teacherList.img}" class="img-responsive hover-effect" alt="" />
            </div>
            </c:forEach>
           
        </div>
        <!-- Service Blocks -->
         <div class="headline"><h2>Community</h2></div>
    	<div class="row margin-bottom-30">
        	<div class="col-md-4">
        		<div class="service">
        			<div class="desc">
        				<h4>공지사항</h4>
        				 <a style="float:right;"class="btn-more hover-effect" href="noticeList">더보기</a>
                        <table class="table">
                        	<tr>
                                <th >제목</th>
                                <th >작성자</th>
                            </tr>
                        <c:forEach var="notice" items="${noticeList}">
                        	<tr>
                        		<td style="overflow:hidden; text-overflow:ellipsis; 
                        		word-break: break-word; -webkit-line-clamp: 1; display: -webkit-box;
                        		 -webkit-box-orient: vertical; width:233px; height:30px;"><a href = "noticeDetail?notice_num=${notice.notice_num}">${notice.title }</a></td>
                        		<td>${notice.writer }</td>                  		
                        	</tr>
                        </c:forEach>
                    </table>
        			</div>
        		</div>
        	</div>
        	<div class="col-md-4">
        		<div class="service">
        			<div class="desc">
        				<h4>Q & A</h4>
        				 <a style="float:right;"class="btn-more hover-effect" href="noticeList">더보기</a>
                          <table class="table">
                            <tr>
                                <th>제목</th>
                                <th >작성자</th>
                            </tr>
                        <c:forEach var="qnaList" items="${qnaList}">
                        	<tr>
                        		<td style="overflow:hidden; text-overflow:ellipsis; 
                        		word-break: break-word; -webkit-line-clamp: 1; display: -webkit-box;
                        		 -webkit-box-orient: vertical; width:233px; height:30px;"><a href = "qnaDetail?qna_num=${qnaList.qna_num}">${qnaList.title }</a></td>
                        		<td>${qnaList.writer }</td>                  		
                        	</tr>
                        </c:forEach>
                    </table>
        			</div>
        		</div>
        	</div>
        	<div class="col-md-4">
        		<div class="service">
        			<div class="desc">
        				<h4>FAQ</h4>
        				 <a style="float:right;"class="btn-more hover-effect" href="faqList">더보기</a>
                         <table class="table">
                            <tr>
                                <th>제목</th>
                                <th >작성자</th>
                            </tr>
                       <c:forEach var="faqList" items="${faqList}">
                        	<tr>
                        		<td style="overflow:hidden; text-overflow:ellipsis; 
                        		word-break: break-word; -webkit-line-clamp: 1; display: -webkit-box;
                        		 -webkit-box-orient: vertical; width:233px; height:30px;"><a href = "faqDetail?faq_num=${faqList.faq_num}">${faqList.title }</a></td>
                        		<td>${faqList.writer}</td>                  		
                        	</tr>
                        </c:forEach>
                    </table>
        			</div>
        		</div>
        	</div>
    	</div>
    	<!-- End Service Blokcs -->
        <!-- End Owl Clients v1 -->
    </div><!--/container-->    
    <!-- End Content Part -->
    </tiles:putAttribute>
</tiles:insertDefinition>