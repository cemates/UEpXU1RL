/**
 * @author Hüseyin Cem Ateş
 * */

/*
In the list of words from http://www.puzzlers.org/pub/wordlists/unixdict.txt find all anagrams. 
a) write them out for all words in the order of the number of anagrams of a given word 
b) for the word given in the dialogue, write the anagrams in alphabetical order. 

Note: the list of words is only English. 

Help: 
loading entire text from URL: 
def txt = new URL (... address ...). Text 
list of lines: 
def llist = new URL (... address ...). ReadLines () 

anagrams = words consisting of from the same characters
 */
 
package Task8;

import javax.swing.JOptionPane


def alphabetize = {
	char[] chars = it.toCharArray()
	Arrays.sort(chars);

	new String(chars);
}


def anagramMap = new HashMap<String, TreeSet<String>>();

def lines = new URL("http://www.puzzlers.org/pub/wordlists/unixdict.txt").readLines();

lines.each{ word ->
	def alpha = alphabetize(word)

	def anagramSet = anagramMap.get(alpha, new TreeSet<String>())
	anagramSet << word;

	anagramMap[alpha] = anagramSet
};

anagramMap = anagramMap.sort({-it.value.size()})
anagramMap.each {key, val ->
	if(val.size() > 2)
		println "$key $val"
}

//b)
String input = JOptionPane.showInputDialog("Word to show angrams:");

def anagramsForWord = anagramMap.get(alphabetize(input));
anagramsForWord.remove(input)

println "======================================"
println "anagrams for $input: $anagramsForWord"