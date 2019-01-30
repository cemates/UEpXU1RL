/**
 * @author Hüseyin Cem Ateş
 * */

/*
Subtitles entered in subsequent dialogs have the form:   position = cost. Sum up all costs for the same items (e.g. milk, bread).
 */
package Task5
import javax.swing.JOptionPane;


def map = [:]

while(input = JOptionPane.showInputDialog("item=cost")){
	def tokens = input.tokenize("=")

	if(map[tokens[0]] == null)
		map[tokens[0]] = 0

	map[tokens[0]] += Integer.parseInt(tokens[1])
}

println map