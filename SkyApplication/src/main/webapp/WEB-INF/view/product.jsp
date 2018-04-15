<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="/resources/css/style.css"  type="text/css">
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	  $(":checkbox").change(function() {
	    var arr = $(":checkbox:checked").map(function() {; return $(this).val(); }).get();
		  $("#basket").html(arr.join('</br>'));
	  });
	});
	
function validate(){

    var anyBoxesChecked = false;
    $( 'input[type="checkbox"]').each(function() {
        if ($(this).is(":checked")) {
            anyBoxesChecked = true;
        }
    });
 
    if (anyBoxesChecked == false) {

    	alert('Please select your favourite channel!!');
    	return false;
    } 
}	
</script>
<title>Product</title>
</head>
<body>
<form method="POST" action="/product/confirm" onsubmit="return validate();">
	<div align="center" class="title-h1"><h1>Sky Broadcasting</h1></div>
	<div  >
		<div class="box1" >
			<br><div class="label_item">Sports</div></br>
			<div><c:forEach items="${sportsList}" var="sportsProduct">
						<input type="checkbox" name ="sports" value="${sportsProduct.name}"><c:out value="${sportsProduct.name}" /></br>
				</c:forEach>
			</div>
		</div>
			
		<div class="box1"><br><div class="label_item">News</div></br>
			<div><c:forEach items="${newsList}" var="newsProduct">
					<input type="checkbox" name = "news" value="${newsProduct.name}"><c:out value="${newsProduct.name}" /></br>
			</c:forEach>
			</div> 
		</div>
			
			<div id="basket_full" class="box1" ><br>
				<div class="label_item">Basket</div></br>
                 
				<div class="basket_item">
					<div  id="basket" class="thing" contenteditable="false" data-placeholder="Ouhh....It's empty in here!" ></div>
				</div>
				<div class="button_item"><input type="submit" value="Checkout" ></div>
			</div>
	</div>
	</form>
	
</body>

</html>

