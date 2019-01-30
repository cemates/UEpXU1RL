/**
 * @author Hüseyin Cem Ateş
 * */

/*
Provide iteration on Iterable with the help of the eachTuple method, which allows operation of the given closure for subsequent ones n-kach elemntow. The number n should be from the number of closure arguments. 
The "flat" script definition could be used, for example, yes 

def list = (1..40) 

eachTuple (list) {e1, e2, e3, e4 -> 
  println "$ e1 $ e2 $ e3 $ e4" 
} 

def s = 'asia has cat and dog' 

def out = new StringBuffer () 
eachTuple (s) {a, b -> 
  out << b <<

1 2 3 4 
5 6 7 8 
9 10 11 12 
13 14 15 16 
17 18 19 20 
21 22 23 24 
25 26 27 28 
29 30 31 32 
33 34 35 36 
37 38 39 40 
saaim aokati p as Task 
 */

package Task2


def eachTuple(def source, Closure c){
	int numberOfParam = c.maximumNumberOfParameters;

	def list = []

	counter = 1;

	source.each {
		if(counter % maximumNumberOfParameters == 0){
			counter = 0;
			c(list)
		}

		list << it
		println it
		counter++
	}

	//	for(int i = 0; i < source; i += numberOfParam){
	//		println i
	//	}
}


def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
	println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) { a,b ->
	out << b << a
}
println out

//It Prints:
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16
//17 18 19 20
//21 22 23 24
//25 26 27 28
//29 30 31 32
//33 34 35 36
//37 38 39 40
//saaim  aokati p as