/**
 * @author Hüseyin Cem Ateş
 * */

/*
Create a sorted set of words from the file. The words are to be ordered according to their length, if the length is the same, use the alphabetical order. 

Help : 
use TreeSet with properly defined comparator 
 */
 
package Task8;

def file = new File("toSort.txt")

def comp = [compare: {a, b ->
		if(a.size().compareTo(b.size()) == 0){
			return a.compareTo(b)
		} else{
			return a.size().compareTo(b.size())
		}
	}] as Comparator

def treeSet = new TreeSet(comp)

file.eachLine {line ->
	line.tokenize().each {treeSet << it}
}

println treeSet