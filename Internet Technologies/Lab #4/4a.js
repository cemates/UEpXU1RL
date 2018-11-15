// Function calculating the factorial of a number. Do this using recursion and iteration. 
// Create recursive function using function expression, iterative function using function declaration

var factorial_Iterative = function ( value ) {
	
	var result = 1;
	
	while ( value > 0 ) {
		
		result = result * value;
		value = value - 1;
	}
	
	return result;
}

var factorial_Recursive = function ( value ) {
	
	if ( value === 0 ) {
		
		return 1;
	}
	else {
		
		return value * factorial_Recursive( value - 1 );
	}

}

// Example
console.log(factorial_Iterative(5)); //120
console.log(factorial_Recursive(5)); //120
