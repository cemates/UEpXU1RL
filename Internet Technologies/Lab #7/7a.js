var http = require('http');
let url = require('url');

function writeHeader(resp) {
  var a = '<!DOCTYPE html><html><head><style>p {font-size: 50px; display: flex; justify-content: center; align-items: center;}</style></head><body><p>';
  resp.write(a);
}

function writeEnd(resp) {
  var b = '</p></body></html>';
  resp.write(b);
}

function splitUrl(reqUrl) {
  let parts = url.parse(reqUrl, true);
  let operator = parts.pathname;
  let query = parts.query;
  console.log(query);
  return {
    operator: operator,
    values: query
  }
}
let operators = {
  '/add': {
    op: '+',
    calc: function(a, b){
      return a + b;
    }
  },
  '/mul': {
    op: 'x',
    calc: function(a, b){
      return a * b;
    }
  },
  '/div': {
    op: '/',
    calc: function(a, b){
      return a / b;
    }
  },
  '/sub': {
    op: '-',
    calc: function(a, b){
      return a - b;
    }
  }
};

function validateQuery(urlSplitted) {
  var query = {
    valid: true
  };
  if (!(urlSplitted.operator in operators)) {
    query.valid = false;
  } else {
    query.operator = urlSplitted.operator;
  }
  var myReg = /^[0-9]+$/;
  if (myReg.test(urlSplitted.values.val1) && myReg.test(urlSplitted.values.val2)) {
    query.value1 = parseInt(urlSplitted.values.val1);
    query.value2 = parseInt(urlSplitted.values.val2);
  } else {
    query.valid = false;
  }
  return query;
}

function calcQuery(query) {
  if (query.valid === false) {
  } else {
    return (query.value1 + ' ' + operators[query.operator].op + ' ' + query.value2 + ' = ' + (operators[query.operator]).calc(query.value1, query.value2));
  }
}
http.createServer(function(req, resp) {
  if (req.url === '/favicon.ico') {
    resp.writeHead(200, {
      'Content-Type': 'image/x-icon'
    });
    resp.end();
    return;
  }
  writeHeader(resp);
  var urlSplitted = splitUrl(req.url);
  let query = validateQuery(urlSplitted);
  resp.write(calcQuery(query));
  writeEnd(resp);
  resp.end();
}).listen(8000, "localhost");
