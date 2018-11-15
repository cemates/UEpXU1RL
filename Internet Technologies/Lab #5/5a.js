// a)	Use object initializer to create an object, it should have at least 2-3 fields and 2-3 methods. 
// Write a function accepting the object as a parameter and printing all its properties and their types

var person = {
    name: "Cem",
    surname: "Ates",
    year_of_birth: 1995,
    getInfo() {
        return this.name + " " + this.surname + ", born " + this.year_of_birth;
    },
    isOlder(age) {
        cdate = new Date();
        temp = cdate.getFullYear() - this.year_of_birth;
        return temp > age;
    }
};

console.log(person.getInfo());
console.log(person.isOlder(21));
