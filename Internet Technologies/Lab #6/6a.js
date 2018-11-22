// console.log('test');

var button = document.getElementById("converter");
var output = document.getElementById("result");
var celsButton = document.getElementById("cels");
var farButton = document.getElementById("far");

var goButton = document.getElementById("clickConverter");




goButton.addEventListener("click", check);

	
function check(){
	var celsButton = document.getElementById("cels");
	var farButton = document.getElementById("far");
	var temp = button.value;

	console.log("TemP: ", temp);



	if (celsButton.checked) {
		console.log("CELS");
		toCelsius(temp);
	}else if (farButton.checked) {
		console.log("FAHR");
		toFahrenheit(temp);
	}else{
		console.log("CelsChecked?", celsButton.checked);
		console.log("FahrChecked?", farButton.checked);

		alert("please choose a scale");
	}
};




	function toCelsius(myTemp) {

			var celsTemp = (myTemp - 32) / 1.8;  
			console.log(celsTemp);
			output.innerHTML = celsTemp.toString();
			colorChange(celsTemp);
			
	};

	function toFahrenheit(myTemp) {
		
		var farTemp = (myTemp * 1.8) + 32;
		console.log(farTemp);
		output.innerHTML = farTemp.toString();
		colorChange(farTemp);

		
	};

function colorChange(myTemp) {

if (myTemp < 32){
	output.setAttribute("class", "cold");
}
else if (myTemp > 90){
	output.setAttribute("class", "warm");
}
else {
	output.setAttribute("class", "normal"); 
}

};



var clearField = document.getElementById("reset");

clearField.addEventListener("click", clearTheField);

function clearTheField() {
	output.innerHTML = " ";
	button.value = " ";
	celsButton.checked = false;
	farButton.checked = false;
};


























