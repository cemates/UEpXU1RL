// c)	Create a prototype of a student object using initializer. 
// The object should contain an array with list of courses each student should take. 
// Write a function creating new objects based on this prototype, setting their first and last name and id properties.


var student = {
    courses : ["BYT", "TIN", "PRI"] 
}
    function createStudent(in_name, in_surname, in_id){
    stud = Object.create(student);
    stud.name = in_name;
    stud.surname = in_surname;
    stud.id = in_id;
    return stud;
}

var test = createStudent("ab", "cb", 1);
console.log(test.courses);
