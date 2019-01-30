/**
 * @author Hüseyin Cem Ateş
 * */
/*
Write a function String join (List l, String sep) returning a string containing list elements l separated by separators sep. 
 */
package Task5

String join(List l, String sep){
	StringBuilder strBuilder = new StringBuilder()

	l.each { elem ->
		strBuilder << elem
		strBuilder << sep
	}

	strBuilder.toString()[0..-2]
}

def list = ["a", "b", "c", "d"]

println join(list, "-")