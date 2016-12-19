
public class DisplayPage {
	public final String header = "<html><head><title>HTML5 Bar Graph Example</title</head><body><div id=\"graphs\">";
	
	
	public final String footer =   "<script src=\"js/barGraph.js\"></script><script>(function () {function createCanvas(divName) {var div = document.getElementById(divName);
		      var canvas = document.createElement(\'canvas\');
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
			    graph.update([10.25, 33, 0, 50, 50]);
		  }());
		  	</script>
		  
		</body>
		</html>
}
