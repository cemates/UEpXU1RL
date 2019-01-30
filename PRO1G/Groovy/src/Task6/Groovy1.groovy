/**
 * @author Hüseyin Cem Ateş
 * */

/*
For the following definitions lists: 
def list1 = ['a', 'b', 'c'] 
def list2 = [1, 8, 23] 

using the each (Closure) method 
a) list all elements (2 p. ), 
b) create new lists of lists11 and lists12 containing doubled values ​​of original lists (3 p.). 
*/

package Task6;

def list1 = ['a', 'b', 'c']
def list2 = [1, 8, 23]

list1.each{ println it }

list2.each{ println it }

def list11 = []
def list12 = []

list1.each{ list11 << it * 2 }

list2.each{ list12 << it * 2 }

println list11
println list12
