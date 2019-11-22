"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Passwords = /** @class */ (function () {
    function Passwords() {
    }
    Passwords.get = function (password) {
        var encrypted = new Buffer(password).toString('Base64');
        return encrypted;
    };
    Passwords.equal = function (password_1, password_2, isEncrpyted) {
        if (isEncrpyted === void 0) { isEncrpyted = true; }
        return isEncrpyted ? password_1 === password_2 : password_1 === this.get(password_2);
    };
    return Passwords;
}());
exports.Passwords = Passwords;
