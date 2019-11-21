"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var hash = require('password-hash');
var Passwords = /** @class */ (function () {
    function Passwords() {
    }
    Passwords.get = function (password) {
        return hash.generate(password);
    };
    Passwords.equal = function (password_1, password_2) {
        return password_1 === password_2;
    };
    return Passwords;
}());
exports.Passwords = Passwords;
