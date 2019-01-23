const express = require("express");
const cors = require('cors');
const mysql = require('mysql');

const app = express();

const SELECT_ALL_STUDENTS_QUERY = 'SELECT * FROM students';

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'HelloWorld',
    database: 'react_js'
});

connection.connect(err => {
    if(err) {
        return err;
    }
});

// console.log(connection);

app.use(cors());

app.get('/', (req, res) => {
 res.send('Go to /class to see students')
 // res.json(class);
});

app.get('/class/add', (req, res) => {
    const { name, s_id } = req.query;
    // console.log(name, s_id);
    const INSERT_CLASS_QUERY = 'INSERT INTO react_js.students (name, s_id) VALUES("${name}", ${s_id})';
    connection.query(INSERT_CLASS_QUERY, (err, results) => {
        if(err) {
            return res.send(err)
        }
        else {
            return res.send('Successfully added new student')
        }
    });
    //res.send('adding new student');
});

app.get('/class', (req, res) => {
    connection.query(SELECT_ALL_STUDENTS_QUERY, (err, results) => {
        if(err) {
            return res.send(err)
        }
        else {
            return res.json({
                data: results
            })
        }
     });
});

app.listen(3000, () => {
    console.log('Class server listening on port 3000')
});