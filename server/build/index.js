"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var express = require("express");
var app = express();
var PORT = 80;
app.use(express.json());
app.use(express.urlencoded({
    extended: true
}));
app.get('/', function (req, res) {
    res.send('');
});
app.post('/login', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;
    console.log("here");
    res.send('true');
});
app.listen(PORT, function () {
    console.log('Server running on port 3000');
});
