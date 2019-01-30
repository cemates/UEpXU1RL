/**
 * @author Hüseyin Cem Ateş
 * */

/*
 The software company runs projects in: 
Groovy, Grails, Java, JEE 
The Projects.txt file contains information about the composition of each project in the form of: 
project name <TAB> Surname name (1) <TAB> Surname (2) < TAB> 
itp. Create files: 
ProjektyDuze.txt - containing a list of projects in which> more than 3 people 
Programis.txt - containing a list of programmers in the form: 
name of the name <tab> proj1 <tab> proj2 <tab> etc. Task 
 */

package Task7;

file = new File("Projects.txt")

def projectMap = [:]
def personProjectMap = [:]
def bigProjectsList = []

file.eachLine { line ->

	def splittedLine = line.split("\t")

	splittedLine[1..-1].each {
		def list = projectMap[splittedLine[0]]

		if(list == null)
			projectMap[splittedLine[0]] = (list = [])
		list << it

		list = personProjectMap[it]

		if(list == null)
			personProjectMap[it] = (list = [])

		list << splittedLine[0]
	}
}

println projectMap
println personProjectMap

def largeProjectsFile = new File("LargeProjects.txt")

projectMap.each {key, value ->
	if(value.size() > 3){
		largeProjectsFile.withPrintWriter { writer -> writer.println key }
	}
}

def programmersFile = new File("Programmers.txt")

programmersFile.withPrintWriter { writer ->
	personProjectMap.each { key, value ->
		writer.print(key + "\t")

		value.each {
			writer.print(it + "\t")
		}
		writer.println()
	}
}