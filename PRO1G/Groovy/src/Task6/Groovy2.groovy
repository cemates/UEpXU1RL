/**
 * @author Hüseyin Cem Ateş
 * */

/*
A software company runs projects in: 
Groovy, Grails, Java, JEE 
. Each project is assigned programmers, as shown in the following map: 

def pmap = [Groovy: ['Asia', 'Jan'], 
                     Grails: [' Asia ',' Jan ',' Stefan ',' Mirek '], 
                     Java: [' Asia ',' Stefan ',' Mirek '],


Print: 
a) how many people work in each project (3 p) 
b) projects that have more than two programmers (3p) 
c) in which projects individual programmers take part (6th floor) 
*/

package Task6;

def pmap = [ Groovy: ['Asia', 'Jan'],
	Grails: [
		'Asia',
		'Jan',
		'Stefan',
		'Mirek'
	],
	Java: ['Asia', 'Stefan', 'Mirek'],
	JEE: [
		'Slawek',
		'Stefan',
		'Janusz' ]
]

println "project -> how many people"

pmap.each{ key, val ->
	println key + " " + val.size()
}

println "========================"
println "project people > 2"

pmap.each{
	if(it.value.size() > 2)
		println it.key
}

println "========================"
def personProjectsMap = [:]

pmap.each{ key, value ->
	value.each {
		def list = personProjectsMap[it]
		
		if(!list)
			personProjectsMap[it] = (list = [])
			
		list << key
	}
}

println personProjectsMap