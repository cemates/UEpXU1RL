// Write a JavaScript function which accepts an argument and returns the type

function detect_data_type(value)
{
var dtypes = [Function, RegExp, Number, String, Boolean, Object], x, len;
    
if (typeof value === "object" || typeof value === "function") 
    {
     for (x = 0, len = dtypes.length; x < len; x++) 
     {
            if (value instanceof dtypes[x])
            {
                return dtypes[x];
            }
      }
    }
    
    return typeof value;
}

// Examples 

console.log(detect_data_type(7)); // number
console.log(detect_data_type('Hello, World!')); // string
console.log(detect_data_type(true)); // boolean