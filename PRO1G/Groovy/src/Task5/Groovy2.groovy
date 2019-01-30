/**
 * @author Hüseyin Cem Ateş
 * */

/*
Write the function String reverseWords (String s) returning a string consisting of words in the string reverse order. 
For example, reverseWords ("ala ma kota") returns "cat ma ala" 
 */

package Task5;

String reverseWords(String s){

	def words = s.tokenize()

	return words[-1..0]
}

def letters = "abc def ghi"

println reverseWords(letters)
println reverseWords(/ala ma kota/)