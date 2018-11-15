// Function calculating nth number in Fibonacci sequence. 

function fib(n) {
  let arr = [0, 1];

  if (n <= 2) return 1;

  for (let i = 2; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
    // arr.push(arr[i-1] + arr[i-2])
  }

  return arr[n];
}

// Example
console.log(fib(10)); // 55