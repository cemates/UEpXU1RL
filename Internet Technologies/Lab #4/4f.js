// Write a JavaScript function that accepts a number as a parameter and check the number is prime or not

function check_prime(n)
{

  if (n===1)
  {
    return false;
  }
  else if(n === 2)
  {
    return true;
  }else
  {
    for(var x = 2; x < n; x++)
    {
      if(n % x === 0)
      {
        return false;
      }
    }
    return true;  
  }
}
//Examples
console.log(check_prime(37)); //true
console.log(check_prime(4)); //false