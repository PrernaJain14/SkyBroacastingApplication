<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="/resources/css/style.css"  type="text/css">

<title>Confirmation Page</title>
</head>
<script type="text/javascript">

	
function confirmDialog(){
    	
    	return confirm("Are you sure you want to Proceed!!");
    
}	
</script>
<body>
	<form method="POST" action="/confirm" onsubmit="return confirmDialog();">
		<div>
			<div align="center" class="title-h1"><h1>Sky Broadcasting</h1></div>
			<div align="left" class="title-h2"><h3>Customer ID:  ${customerID}</h3></div>
			<div align="left" class="title-h2"><h4>Your Selected Channels</h4></div>
			
			<div>
				<div class="confirm_box">
					<div  >
						<div class="label_item">Sports</div>
						<div class="confirm_div"><c:forEach items="${sportsList}" var="sportsProduct">
									<label name = "sports" ><c:out value="${sportsProduct}" /></br>
							</c:forEach>
						</div>
						
						<div class="label_item">News</div>
						<div class="confirm_div"><c:forEach items="${newsList}" var="newsProduct">
								<label name = "news" ><c:out value="${newsProduct}" /></br>
								</c:forEach>
						</div> 
					</div>
					<div class="button_item"><input type="submit" value="Confirm" ></div>
				</div>
			</div>
		</div>
	</form>
</body>

</html>

