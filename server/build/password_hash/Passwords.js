"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var hash = require('password-hash');
var Passwords = /** @class */ (function () {
    function Passwords() {
    }
    Passwords.get = function (password) {
        return hash.generate(password);
    };
    Passwords.equal = function (passwordPlain, passwordEncrypted) {
        return hash.generate(passwordPlain) === passwordPlain;
    };
    return Passwords;
}());
exports.Passwords = Passwords;
