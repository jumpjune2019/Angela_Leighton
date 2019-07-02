$.ready(function() {
	// $.get('title').innerHTML = $.string.format("Quiz Game {0}", $.getVersion());
});

//define vars to hold time values
var seconds = 0;
var minutes = 0;
var hours = 0;

//define vars to hold display values
var displaySeconds = 0;
var displayMinutes = 0;
var displayHours = 0;

//var to hold setInterval() function
var interval = null;

//stopwatch status
var status = "begin";


function loadData() {

	//sets a variable equal to a new HTTP request
	var myRequest = new XMLHttpRequest();

	//get the file
	myRequest.open("GET", "terms.json", true);

	myRequest.onload = function(){
		var termData = JSON.parse(myRequest.responseText);

		//display terms and definitions
		buildQuiz(termData);
	}

	//send the request
	myRequest.send();
}

function buildQuiz(quizData){

	//get all the termWidgets
	var terms = document.getElementsByClassName("termWidget");
	var defs = document.getElementsByClassName("definitionText");

	var definitions = [];

	numQuest = quizData.data.length;

	//loop thru termWidgets and change to visible
	for (var i = 0; i < terms.length; i++) {
	  terms[i].style.visibility = "visible";
	  let x = Math.trunc(numQuest * Math.random());
	  terms[i].innerHTML = quizData.data[x].term;
	  
	  //push the definition into the array
	  definitions.push(quizData.data[x].definition);
	}

	//randomize the definitions
	for(let z = 0; z < 5; z++){
		//get a random number from 0 to array.length
		let y = Math.trunc(definitions.length * Math.random());
		var def = definitions.splice(y,1);
		defs[z].innerHTML = def;
	}


	//loop thru termWidgets and change to visible
	for (var i = 0; i < defs.length; i++) {
	  defs[i].style.visibility = "visible";
	}
}

function allowDrop(ev) {
  ev.preventDefault();
}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  ev.target.appendChild(document.getElementById(data));
}

//stopwatch function - logic to determine when to increment next value
function stopWatch() {
  
  seconds++;
  //logic to determine when to increment next value
  if (seconds / 60 == 1){
    seconds = 0;
    minutes++;

    if(minutes / 60 == 1){
      minutes = 0;
      hours++;
    }
  }

  //if seconds does not have a leading 0 add it
  if (seconds < 10) {
    displaySeconds = "0" + seconds.toString();
  }
  else{
    displaySeconds = seconds;
  }

  //if minutes does not have a leading 0 add it
  if (minutes < 10) {
    displayMinutes = "0" + minutes.toString();
  }
  else{
    displayMinutes = minutes;
  }

  //if hours does not have a leading 0 add it
  if (hours < 10) {
    displayHours = "0" + hours.toString();
  }
  else {
    displayHours = hours;
  }

  //display updated time values to user
  document.getElementById("displayTime").innerHTML = displayHours + ":" + displayMinutes + ":" + displaySeconds;
}

function controlGame() {
  //controls the main game button
 
  if(status == "begin") {
    //Start the stopwatch
    interval = window.setInterval(stopWatch, 1000);

    //change the main button text
    document.getElementById("controlButton").innerHTML = "End";

    //make terms draggable
    setDraggable(true);

    //load the JSON file
    loadData();
    
    //update the status of the game
    status = "started";
  }
  else if (status == "started") {
    //stop timer
    window.clearInterval(interval);

    //change the main button text
    document.getElementById("controlButton").innerHTML = "Show Score";

    //make terms not draggable
    setDraggable(false);
    
    //update the status of the game
    status = "ended";
  }
  else if (status == "ended") {

    //change the main button text
  	document.getElementById("controlButton").innerHTML = "Play Again";

  	//make the score message center visible
  	document.getElementById("score").style.visibility = "visible";
    
    //update the status of the game
  	status = "score";

  	//reset the timer
  	reset();
  }
  else if (status == "score") {

    //change the main button text
  	document.getElementById("controlButton").innerHTML = "End";

  	//make the score message center invisible
  	document.getElementById("score").style.visibility = "hidden";
    
    //update the status of the game
  	status = "started";

  	//Start the stopwatch
    interval = window.setInterval(stopWatch, 1000);
  }
}

function reset() {
	//resets the timer
  window.clearInterval(interval);
  seconds = 0;
  minutes = 0;
  hours = 0;

  document.getElementById("displayTime").innerHTML = "00:00:00";
  document.getElementById("startStop").innerHTML = "Start";
}

function setDraggable(canDrag) {

	//get all the termWidgets
	var terms = document.getElementsByClassName("termWidget");
	
	//loop thru termWidgets and change draggable property
	for (var i = 0; i < terms.length; i++) {
	  terms[i].setAttribute('draggable', canDrag);
	}
}