/**
 * @author Hüseyin Cem Ateş
 * */
/*
a) Write a regular expression, which can be used to find any number in the text real. 
b) use them to process text containing (among others) subtitles in the form of a PLN numberin such a way as to convert these fragments into EUR (at the current exchange rate)
 */

package Task6;

def text = "This product cost 23 PLN, when you buy 3 you need to pay 60 PLN for it."

def regex = "(\\d+) PLN"
def matcher = text =~ regex

text = text.replaceAll(regex) { all, value ->
	String.format("%.2f", value.toBigDecimal() / 4.32) + " EUR"
}

println text