/**
 * @author Hüseyin Cem Ateş
 * */


/*
Generalize the function from task 4, so that any numbers and words can be entered (subtitles separated by white characters), and their validity verified by the passed closure function. 
Let the function be called getData. 
Examples of calls: 

getData (Integer) {it> 0} // integers greater than 0 
println getData () {it.size ()> 3} // words longer than 3 (default type: String)
println getData () // any string (words) 
println getData (BigDecimal) // any numbers Task 
 */


package Task2

import javax.swing.JOptionPane


def getData(Class clas = String, Closure... closure){

	while(1){
		input = JOptionPane.showInputDialog("getData");

		if(input == null)
			break;

		boolean isOk = true;

		try{
			input = input.tokenize();

			input.each {
				it = it.asType(clas)
				println "it: ${it.class}"
				if(closure.length > 0 && !closure[0](it))
					throw new Exception();
			}

			break;
		}catch(Exception e){
			continue;
		}

		println "isOk: ${isOk}"
	}

	input
}

println getData(Integer) { it > 0 }            // integers greater than 0
println getData() { it.size() > 3 }   // words longer than 3 (default type: String)
println getData()                          // any subtitles (words)
println getData(BigDecimal)         