/**
 * @author Hüseyin Cem Ateş
 * */

/*
Sort the list of numbers in descending order. 
a) write your own comparator 
b) look in the Collections class and see if there is something interesting about the reverse sorting order 
 */

package Task8;

def nums = [4, 2, 10, 8, 5, 1, -5, 2, -4]

def comp = [compare: {a, b -> -1 * a.compareTo(b)}] as Comparator

nums.sort(comp)
println nums
