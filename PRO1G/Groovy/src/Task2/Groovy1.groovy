/**
 * @author Hüseyin Cem Ateş
 * */
/*
Write a function that finds the maximum from the passed list of objects (numbers, subtitles) and returns the maximum value and list items on which this value is located. Use eachWithIndex structure. 

Help: we return the list in the form [maxValue, [ind1. ind2, ... indN]] 

The following program using our maximum function:
(maxVal, indList) = maximum ([5, 3, 5, 5, 1, 5]) 
println "Maximum: $ maxVal" 
println "Indexes: $ indList" 

(maxVal, indList) = maximum (['a', ' c ',' c ',' c ',' b ']) 
println "Maximum: $ maxVal" 
println "Indexes: $ indList"
he should lead:

Maximum: 5
Indexes: [0, 2, 3, 5]
Maximum: c
Indexes: [1, 2, 3]

*/

package Task2


def maximum(list){
	def max = list[0]

	for(int i = 1; i < list.size; i++){
		max = (max < list[i])? list[i] : max
	}

	def indexes = []

	list.eachWithIndex {elem, index -> if(max == elem) indexes.add(index)}

	[max, indexes]
}

(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5])
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"