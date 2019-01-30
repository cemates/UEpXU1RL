/**
 * @author Hüseyin Cem Ateş
 * */

/*
Print a list of numbers sorted in ascending order. From the input list,   create a separate list of numbers less than zero . 

Help: use sort and findAll Task 
 */

package Task8;

import javax.swing.JOptionPane

def nums = JOptionPane.showInputDialog("List:").tokenize()*.toInteger()
println "Before sorting: " +  nums
nums.sort()
println "After sorting: " + nums

def selectedNums = nums.findAll {it < 0}

println "Smaller than 0: $selectedNums"