"use strict";
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result["default"] = mod;
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
var User_1 = require("./User");
var password_1 = require("../password_hash/password");
var UUID = __importStar(require("uuid"));
var FileSystem = __importStar(require("fs"));
var Path = __importStar(require("path"));
var UserService = /** @class */ (function () {
    function UserService() {
        this.load();
    }
    UserService.prototype.create = function (username, password) {
        UserService.USERS.push(new User_1.User(UUID.v4.toString(), '', username, password));
        this.save();
    };
    UserService.prototype.checkLogin = function (user) {
        for (var _i = 0, _a = UserService.USERS; _i < _a.length; _i++) {
            var usr = _a[_i];
            if (usr.username === user.username) {
                if (password_1.Passwords.equal(usr.password, user.password)) {
                    return usr;
                }
            }
        }
        var nullUser = null;
        return nullUser;
    };
    UserService.prototype.load = function () {
        UserService.USERS = JSON.parse(FileSystem.readFileSync(Path.join(__dirname, '..', 'configs', 'user.json')).toString());
    };
    UserService.prototype.save = function () {
        FileSystem.writeFileSync(Path.join(__dirname, '..', 'configs', 'user.json'), JSON.stringify(UserService.USERS));
    };
    UserService.USERS = [];
    return UserService;
}());
exports.UserService = UserService;
