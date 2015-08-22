<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon -->
<link rel="shortcut icon" href="resources/favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet" href="resources/assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/assets/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="resources/assets/css/headers/header-default.css">
<link rel="stylesheet" href="resources/assets/css/footers/footer-v1.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="resources/assets/plugins/animate.css">
<link rel="stylesheet" href="resources/assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet" href="resources/assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/assets/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet" href="resources/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="resources/assets/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet" href="resources/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
<link rel="stylesheet" href="resources/assets/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="resources/assets/css/theme-colors/aqua.css" id="style_color">
<link rel="stylesheet" href="resources/assets/css/theme-skins/dark.css">

<!-- CSS Page Style -->
<link rel="stylesheet" href="resources/assets/css/pages/page_log_reg_v1.css">
<link rel="stylesheet" href="resources/assets/css/pages/profile.css">

<!-- CSS Customization -->
<link rel="stylesheet" href="resources/assets/css/custom.css">

<!-- JS Global Compulsory -->
<script type="text/javascript" src="resources/assets/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="resources/assets/plugins/jquery/jquery-migrate.min.js"></script>
<script type="text/javascript" src="resources/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- JS Implementing Plugins -->
<script type="text/javascript" src="resources/assets/plugins/back-to-top.js"></script>
<script type="text/javascript" src="resources/assets/plugins/smoothScroll.js"></script>
<script type="text/javascript" src="resources/assets/plugins/parallax-slider/js/modernizr.js"></script>
<script type="text/javascript" src="resources/assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
<script type="text/javascript" src="resources/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
<script type="text/javascript" src="resources/assets/plugins/sky-forms-pro/skyforms/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/assets/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="resources/assets/plugins/sky-forms-pro/skyforms/js/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="resources/assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- JS Customization -->
<script type="text/javascript" src="resources/assets/js/custom.js"></script>
<!-- JS Page Level -->
<script type="text/javascript" src="resources/assets/js/app.js"></script>
<script type="text/javascript" src="resources/assets/js/forms/reg.js"></script>
<script type="text/javascript" src="resources/assets/js/plugins/owl-carousel.js"></script>
<script type="text/javascript" src="resources/assets/js/plugins/parallax-slider.js"></script>
<script type="text/javascript" src="resources/assets/js/forms/checkout.js"></script>
<script type="text/javascript" src="resources/assets/js/plugins/masking.js"></script>
<script type="text/javascript" src="resources/assets/js/plugins/datepicker.js"></script>
<script type="text/javascript" src="resources/assets/js/plugins/validation.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		App.init();
		App.initScrollBar();
        RegForm.initRegForm();
        Datepicker.initDatepicker();
        CheckoutForm.initCheckoutForm();
		OwlCarousel.initOwlCarousel();
		ParallaxSlider.initParallaxSlider();
		Masking.initMasking();
        Datepicker.initDatepicker();
        Validation.initValidation();
	});
</script>

<title>Insert title here</title>
</head>
<tiles:insertAttribute name="header" flush="true" />
<tiles:insertAttribute name="body" flush="true" />
<tiles:insertAttribute name="footer" flush="true" />
</body>
</html>