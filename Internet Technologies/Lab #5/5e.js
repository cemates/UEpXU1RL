// E)	Task D with classes 😉

class Student {
    constructor(id, name, surname, grades){
    this.id = id;
    this.name = name;
    this.surname = surname;
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
    get fullname() {
        return this.name + ' ' + this.surname;
    }
    set setFullname(name) {
        let words = name.split(' ');
        this.name = words[0];
        this.surname = words[1];
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