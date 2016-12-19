<%@ page import="watson.BookStats" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<head>
  <title>See the Emotions!</title>
  <script src="js/barGraph.js"></script>
  <script src="js/scripts.js"></script>
</head>

<body id="myBody">
	
	<form id="submitBook" onsubmit="myFunction();"  action="" method="post">
	  	Enter another book to search!: 
  		<input type="text" name="bookname"><br>
  		Number of Reviews (max 20): <input type="number" min="0" value="5" max="20" name="reviewcount"><br>
  		<input id="submitButton" type=submit>
  	</form>
	<br>
	${errorMessage}
	
	<c:if test="${not empty emotions}">
	<br>
	Showing results for: ${emotions.getBook().getTitle()}
	<br>
	By: ${emotions.getBook().getAuthor()}
	
  <div id="graphs">
  <div id = graphDiv1></div>
  </div>
  </c:if>
  <script>(function () {
  
    function createCanvas(divName) {
      
      var div = document.getElementById(divName);
      var canvas = document.createElement('canvas');
      div.appendChild(canvas);
      if (typeof G_vmlCanvasManager != 'undefined') {
        canvas = G_vmlCanvasManager.initElement(canvas);
      } 
      var ctx = canvas.getContext("2d");
      return ctx;
    }
	  
	    var ctx = createCanvas("graphDiv1");
	    
	    var graph = new BarGraph(ctx);
	    graph.maxValue = 100;
	    graph.margin = 2;
	    graph.colors = ["#007300", "#ff0000", "#007300", "#ff0000", "#007300"];
	    graph.xAxisLabelArr = ["Anger", "Disgust", "Fear", "Joy", "Sadness"];

  
	    graph.update(${emotionJson});
	    
	    
  
  }());
  	</script>
  


</body>
</html>

