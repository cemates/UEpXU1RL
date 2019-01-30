/**
 * @author Hüseyin Cem Ateş
 * */

/*
Calculate the number of occurrences of each word in the file. 
List the words in alphabetical order along with the number of occurrences of each word. 
Notes: 
a) What are the words? - include punctuation marks (+1 p.) 
b) What is alphabetical? - take into account the alphabetical order for a given language (+2 p.) 

Help : 
use TreeMap 
tokenize (sep) allows you to specify a set of separators
We compile an alphabetical comparator for a given language by: Collator.getInstance (new Locale) Task 
 */

package Task8;

import java.text.Collator

def treeMap = new TreeMap(Collator.getInstance(new Locale("PL")))

def file = new File("task8_5.txt")

file.eachLine{line ->
	line.tokenize(' \t+=*/~\\\'"[]{}()@!,;,.?:').each { word ->
		int count = treeMap.get(word, 0)
		treeMap[word] = count + 1
	}
}

println treeMap