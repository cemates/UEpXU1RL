// F) Create class Person with first and last name, as well as getter and setter for full name. 
// Rewrite Student class from task E to extend class Person
class Person {
    constructor(name, surname) {
        this.name = name;
        this.surname = surname;
    }
  get fullname() {
        return this.name + ' ' + this.surname;
    }
    set setFullname(name) {
        let words = name.split(' ');
        this.name = words[0];
        this.surname = words[1];
    }
}

class Student extends Person{
    constructor(id, name, surname, grades){
    super(name, surname);
    this.id = id;
    this.grades = grades;
    }
    info() {
        var temp = 0;
        for (var g in this.grades){
            temp = temp + parseInt(g);
        }
        var avg = temp / this.grades.length;
        console.log(this.name + ' ' + this.surname + ' ' + avg);

    }
  
  get averageGrade() {
        var temp = 0;
        for (var g in this.grades){
            temp = temp + parseInt(g);
        }
        
        return temp / this.grades.length;
    }

}
let student = new Student(1, 'Cem', 'Ates', [5, 3, 2, 1]);
student.info();
console.log(student.fullname);
student.setFullname = 'Huseyin Cem Ates';
console.log(student.fullname);
console.log(student.averageGrade);