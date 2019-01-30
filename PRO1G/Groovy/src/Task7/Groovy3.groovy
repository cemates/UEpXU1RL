/**
 * @author Hüseyin Cem Ateş
 * */

/*
List the full names of all html files from the specified directory and any of its subdirectories as: 
1 name 
2 name 
Eg 
1 D: \ docs \ api \ allclasses-frame.html 
2 D: \ docs \ api \ allclasses-noframe.html 
3 D : \ docs \ api \ constant-values.html 
4 D: \ docs \ api \ deprecated-list.html 
5 D: \ docs \ api \ help-doc.html 
6 D: \ docs \ api \ index-files \ index -1.html 
7 D: \ docs \ api \ index-files \ index-10.html 
8 D: \ docs \ api \ index-files \ index-11.html 
9 D: \ docs \ api \ index-files \ index-12.html 
10 D: \ docs \ api \ index-files \ index-13.html 
... 
....
 */

package Task7;

def dir = new File(System.getProperty("user.home") + "/Desktop")

int counter = 1;
dir.eachFileRecurse {
	if(it.name.endsWith(".html")){
		println counter++ + " " + it
	}
}