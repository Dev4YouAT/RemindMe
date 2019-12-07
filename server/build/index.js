"use strict";
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result["default"] = mod;
    return result;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var express = require("express");
var path = __importStar(require("path"));
var fs_1 = __importDefault(require("fs"));
var user_service_1 = require("./user/user_service");
var user_1 = require("./user/user");
var session_1 = require("./session");
var base_reponse_1 = require("./model/base-reponse");
var reminder_service_1 = require("./user/reminder-service");
var userService = new user_service_1.UserService();
var reminderService = new reminder_service_1.ReminderService();
var app = express();
var PORT = 80;
var USERS_CONFIG_PATH = path.join(__dirname, 'configs', 'user.json');
var REMINDERS_CONFIG_PATH = path.join(__dirname, 'configs', 'reminders.json');
session_1.Session.init(JSON.parse(fs_1.default.readFileSync(USERS_CONFIG_PATH).toString()), JSON.parse(fs_1.default.readFileSync(REMINDERS_CONFIG_PATH).toString()));
app.use(express.json());
app.use(express.urlencoded({
    extended: true
}));
app.get('/reminders', function (req, res) {
    var id = req.query.id;
    res.send(JSON.stringify(reminderService.get(id)));
});
app.post('/login', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;
    var user = userService.checkLogin(new user_1.User('', '', username, password, true));
    res.send(JSON.stringify(user));
});
app.post('/register', function (req, res) {
    var username = req.body.username;
    var password = req.body.password;
    var user = userService.create(username, password, true);
    res.send(JSON.stringify(user == null ? new base_reponse_1.BaseResponse('') : new base_reponse_1.BaseResponse(user.id)));
});
app.listen(PORT, function () {
    console.log('Server running on port ' + PORT);
});
