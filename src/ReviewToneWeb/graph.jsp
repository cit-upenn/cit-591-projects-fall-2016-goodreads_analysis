<!DOCTYPE html>
<head>
  <title>HTML5 Bar Graph Example</title>
</head>

<body>
	<%
	out.println("Your IP address is " + request.getRemoteAddr());
	%>
  <div id="graphs">
  <div id = graphDiv1></div>
  </div>
  <script src="js/barGraph.js"></script>
  <script>(function () {
	  var makeGraphs = "";
	  
	  
/* 	  for (var i = 0 ; i < 4; i++) {
		  makeGraphs += "<div id=\"graphDiv" + i + "\"></div>";
	  } */
	  
  
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
	    graph.update(<% out.print(request.getAttribute("emotions"));  %>);
  
  
  
  }());
  	</script>
  


</body>
</html>

