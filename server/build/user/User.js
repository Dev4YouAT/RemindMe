"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var password_1 = require("../password_hash/password");
var User = /** @class */ (function () {
    function User(id, notificationID, username, password, isEncrypted) {
        if (isEncrypted === void 0) { isEncrypted = false; }
        this.id = id;
        this.notificationID = notificationID;
        this.username = username;
        this.password = !isEncrypted ? password_1.Passwords.get(password) : password;
    }
    return User;
}());
exports.User = User;
