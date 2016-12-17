// window.alert("Linking?!?");
function BarGraph(ctx) { //BarGraph function takes one parameter called "ctx" 
//which corresponds to the context of the canvas on which to draw the bar graph
	
  var that = this; //used to access the BarGraph object from inside the functions we will create
  var startArr; //used to store the array of values from during animation
  var endArr; //used to store the array of values from during animation
		
	var draw = function (arr) {
							
	  var numOfBars = arr.length;
	  var barWidth;
	  var barHeight;
	  var border = 2;
	  var ratio;
	  var maxBarHeight;
	  var gradient;
	  var largestValue;
	  var graphAreaX = 0;
	  var graphAreaY = 0;
	  var graphAreaWidth = that.width;
	  var graphAreaHeight = that.height;
	  var i;
	  
	  //update dimensions if they have changed
	  if (ctx.canvas.width !== that.width || ctx.canvas.height !== that.height) {
		ctx.canvas.width = that.width;
		ctx.canvas.height = that.height;
	  }
				
	  //set background colors of graph by public variable backgroundColor
	  ctx.fillStyle = that.backgroundColor;
	  ctx.fillRect(0, 0, that.width, that.height);
					
	  //This subtracts out the labels in the x axis to make room for the rest 
	  if (that.xAxisLabelArr.length) {
		graphAreaHeight -= 40;
	  }
				
	  //find the size of the bar by dividing the grpah into equal sections less the margin betwen the bars
	  barWidth = graphAreaWidth / numOfBars - that.margin * 2;
	  maxBarHeight = graphAreaHeight - 25;
				
	  // Determine the max value of the array parameter 
	  //Loop through and update the largestValue var when its bigger
	  var largestValue = 0;
	  for (i = 0; i < arr.length; i += 1) {
		if (arr[i] > largestValue) {
		  largestValue = arr[i];	
		}
	  }
	  
	  // go through each bar in array and determine height based on target value and max height
	  //if maxvalue property has been set then use that as max, and else we use largest Value in the parameter
	  //in parameter of array- use ratio to set height of current bar
	  for (i = 0; i < arr.length; i += 1) {
		// Set the ratio of current bar compared to the maximum
		if (that.maxValue) {
		  ratio = arr[i] / that.maxValue;
		} else {
		  ratio = arr[i] / largestValue;
		}
		
		barHeight = ratio * maxBarHeight;
	  
		//turn the shadow on for each bar
		//set value to canvas' ocntext's shadow properties 
		//offset and blur of 1 pixel
		//filRect 
		ctx.shadowOffsetX = 1;
		ctx.shadowOffsetY = 1;
		ctx.shadowBlur = 1;
		ctx.shadowColor = "#898989"; //lightish gray on color-hex
						

		//literally draw the bar background
		ctx.fillStyle = "#3d3d3d";	//darker gray 		
		ctx.fillRect(that.margin + i * that.width / numOfBars,
		  graphAreaHeight - barHeight,
		  barWidth,
		  barHeight);
			
		//turn the shadow off for each bar
		ctx.shadowOffsetX = 0;
		ctx.shadowOffsetY = 0;
		ctx.shadowBlur = 0;

		// Draw a bar color if it big enough
		//set the next objects to have shadow properties of 0
		if (barHeight > border * 2) {
			// Create gradient use createLinearGradient to set Gradient hiehgt
			gradient = ctx.createLinearGradient(0, 0, 0, graphAreaHeight);

			//addColorStop defines percentage of the height where each color starts
			//as well as destination color
			gradient.addColorStop(1-ratio, that.colors[i % that.colors.length]);
			gradient.addColorStop(1, "#ffffff");

			//fill bar with the fillRect method
			ctx.fillStyle = gradient;


			ctx.fillRect(that.margin + i * that.width / numOfBars + border,
			  graphAreaHeight - barHeight + border,
			  barWidth - border * 2,
			  barHeight - border * 2);
		}

		// Write bar value
		ctx.fillStyle = "#333";
		ctx.font = "bold 12px sans-serif";
		ctx.textAlign = "center";
		// Use try / catch to stop IE 8 from going to error town
		try {
		  ctx.fillText(parseInt(arr[i],10),
			i * that.width / numOfBars + (that.width / numOfBars) / 2,
			graphAreaHeight - barHeight - 10);
		} catch (ex) {}
		// Draw bar label if it exists
		if (that.xAxisLabelArr[i]) {					
		  // Use try / catch to stop IE 8 from going to error town				
		  ctx.fillStyle = "#333";
		  ctx.font = "bold 12px sans-serif";
		  ctx.textAlign = "center";
		  try{
			ctx.fillText(that.xAxisLabelArr[i],
			  i * that.width / numOfBars + (that.width / numOfBars) / 2,
			  that.height - 10);
			} catch (ex) {}
		  }
		}
	  };

  // Public properties and methods
	
  this.width = 300;
  this.height = 150;	
  this.maxValue;
  this.margin = 5;
  this.colors = ["blue", "green", "blue", "green", "blue"];
  this.curArr = [];
  this.backgroundColor = "#fff";
  this.xAxisLabelArr = [];
  this.yAxisLabelArr = [];
  this.animationInterval = 100;
  this.animationSteps = 10;
	
  // Update method sets the end bar array and starts the animation
	this.update = function (newArr) {

	  // If length of target and current array is different 
	  if (that.curArr.length !== newArr.length) {
		that.curArr = newArr;
		draw(newArr);
	  } else {
		// Set the starting array to the current array
		startArr = that.curArr;
		// Set the target array to the new array
		endArr = newArr;
		// Animate from the start array to the end array
		if (!looping) {	
		  loop();
		}
	  }
	}; 
}