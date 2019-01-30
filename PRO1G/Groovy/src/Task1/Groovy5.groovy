/**
 * @author Hüseyin Cem Ateş
 * */

/*
Write a program that converts numbers into their verbal counterparts. 
For example, after entering the number 147, we should get one - four - seven. (5) 
 */

package Task1

import javax.swing.JOptionPane

def map = [:]

while(input = JOptionPane.showInputDialog("item=cost")){
	def tokens = input.tokenize("=")

	if(map[tokens[0]] == null)
		map[tokens[0]] = 0

	map[tokens[0]] += Integer.parseInt(tokens[1])
}

println map