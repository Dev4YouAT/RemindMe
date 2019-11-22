"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var express = require("express");
var user_service_1 = require("./user/user_service");
var User_1 = require("./user/User");
var userService = new user_service_1.UserService();
var app = express();
var PORT = 80;
app.use(express.json());
app.use(express.urlencoded({
    extended: true
}));
app.get('/test', function (req, res) {
    res.send('test');
});
app.post('/login', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;
    var user = userService.checkLogin(new User_1.User('', '', username, password));
    res.send(JSON.stringify(user));
});
app.listen(PORT, function () {
    console.log('Server running on port ' + PORT);
});
