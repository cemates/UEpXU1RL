var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');
var jsonParser = bodyParser.json();


router.get('/form', (req, res) => {
    res.render('calcForm');
});

router.post('/calc',jsonParser, (req, res) => {
    console.log(req.body);
    let result = 0;
    let value1 = parseInt(req.body.value1);
    let value2 = parseInt(req.body.value2);
    switch (req.body.operator) {
        case '+':
            result = value1 + value2;
            break;
        case '-':
            result = value1 - value2;
            break;
        case '/':
            result = value1 / value2;
            break;
        case '*':
            result = value1 * value2;
            break;
    } 
    res.json({result: 'Result = ' + result});
});


router.post('/calcJson',jsonParser, (req, res) => {
    let result = 0;
    let value1 = parseInt(req.body.value1);
    let value2 = parseInt(req.body.value2);
    switch (req.body.operator) {
        case '+':
            result = value1 + value2;
            break;
        case '-':
            result = value1 - value2;
            break;
        case '/':
            result = value1 / value2;
            break;
        case '*':
            result = value1 * value2;
            break;
    } 
    res.setHeader('Content-type', 'application/json');
    res.json({result: result});
});

module.exports = router;