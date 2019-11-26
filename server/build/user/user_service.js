"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result["default"] = mod;
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
var password_1 = require("../password_hash/password");
var UUID = __importStar(require("uuid"));
var FileSystem = __importStar(require("fs"));
var Path = __importStar(require("path"));
var session_1 = require("../session");
var user_1 = require("./user");
var UserService = /** @class */ (function (_super) {
    __extends(UserService, _super);
    function UserService() {
        var _this = _super.call(this) || this;
        _this.load();
        return _this;
    }
    UserService.prototype.create = function (username, password) {
        if (this.existsByUsername(username)) {
            var nullResult = null;
            return nullResult;
        }
        var user = new user_1.User(UUID.v4.toString(), '', username, password);
        session_1.Session.users.push(user);
        this.save();
        return user;
    };
    UserService.prototype.checkLogin = function (user) {
        for (var _i = 0, _a = session_1.Session.users; _i < _a.length; _i++) {
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
        session_1.Session.users = JSON.parse(FileSystem.readFileSync(Path.join(__dirname, '..', 'configs', 'user.json')).toString());
    };
    UserService.prototype.save = function () {
        FileSystem.writeFileSync(Path.join(__dirname, '..', 'configs', 'user.json'), JSON.stringify(session_1.Session.users));
    };
    return UserService;
}(session_1.Session));
exports.UserService = UserService;
