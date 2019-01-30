/**
 * @author Hüseyin Cem Ateş
 * */

/*
 Write the function List apply (List l, Closure c), which each element of the list l transforms by means of cl is a list of transformed values. Test for different lists and different closures 
 */

package Task2

List apply(List l, Closure c){
	List list = [];

	l.each {list += c(it)};

	list
}

List l = [1, 2, 3, 23, 2];
println apply(l) {it * 2}