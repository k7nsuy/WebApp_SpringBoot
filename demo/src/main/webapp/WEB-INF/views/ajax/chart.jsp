<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.3/c3.min.css" rel="stylesheet" />
</head>
<body>
	<div id="chart" style="width:800px"></div>

	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/d3/5.9.7/d3.min.js"></script>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.3/c3.min.js"></script>
	<!-- script 순서를 맞춰야함.  -->

<script>
	     $(function(){
	    	 var chart = c3.generate({
 				bindto : '#chart',
 				data: {
 					columns: [
 						['data1', 30,200,100,400,150,250],
 						['data2', 130,300,140,300,190,30],
 						['data3', 1210,100,40,30,290,330]
 					]
 				}
 			});
 			
 			setInterval(function() {
     			$.ajax({
    				url: "${pageContext.request.contextPath}/item/chart.json",
    				dataType : 'json',
    				data : JSON.stringify({}),
    				processData: false,
    				contentType: "application/json; charset=utf-8",
    				type: 'POST',
    				success: function (res) {
    				    console.log(res);
                        //alert("success");
                        var data1 = eval(res.data1);
                        var data2 = eval(res.data2);
                        var data3 = eval(res.data3);
    				    
    				    chart.load({  
    				    	columns: [
    	 						data1,
    	 						data2,
    	 						data3
    	 					]
    				    });
    				},error: function (xhr) {
    					alert(xhr.responseText);
    				} 
    			});
 			},2000); 
 			
	     });
	 </script> 

</body>
</html>