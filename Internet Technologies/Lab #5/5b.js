// B) Implement a constructor function, creating objects representing students 
// they should include first and last name, id, array with grades 
// (without subject names, just grades) , a method printing first and last name and grade average of a student

function Student(id, name, surname, grades){
    this.id = id,
    this.name = name,
    this.surname = surname,
    this.grades = grades,
    this.getAverage = function(){
        var temp = 0;
        for (var g in grades){
            temp = temp + parseInt(g);
        }
        
        return temp / grades.length 
    },
    this.getInfo = function(){
        return this.name + " " + this.surname;
    }

}

var grd = [5,3,2,1];
var std = new Student(1,"Cem","Ates", grd);

console.log(std.getInfo());
console.log(std.getAverage());