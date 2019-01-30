/**
 * @author Hüseyin Cem Ateş
 * */
/*
File MenuPl.txt contains a menu in the form: 
name_date price 

Prices are in PLN. 
Use the input file to create a MenuEur.txt file that has the same form but with prices in EUR. 
 */
package Task7;

def menuPlFile = new File("MenuPl.txt")
def menuEurFile = new File("MenuEur.txt")
double rateEur = 4.34


menuPlFile.eachLine {line ->
	def tmp = line.tokenize()

	def cashInEur = (tmp[1] as double) * rateEur

	menuEurFile << tmp[0] + "\t" + cashInEur + "\n"
}