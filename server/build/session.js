"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Session = /** @class */ (function () {
    function Session() {
    }
    Session.init = function (users) {
        this.users = users.slice();
    };
    Session.add = function (user) {
        if (this.exists(user)) {
            return false;
        }
        this.users.push(user);
        return true;
    };
    Session.remove = function (user) {
        if (!this.exists(user)) {
            return false;
        }
        var index = this.getIndex(user);
        if (index == -1) {
            return false;
        }
        this.users.splice(index, 1);
        return true;
    };
    Session.exists = function (user) {
        return this.getIndex(user) != -1;
    };
    Session.getAll = function () {
        return this.users.slice();
    };
    Session.prototype.existsByUsername = function (username) {
        for (var i = 0; i < Session.users.length; i++) {
            if (Session.users[i].username === username) {
                return true;
            }
        }
        return false;
    };
    Session.getIndex = function (user) {
        for (var i = 0; i < this.users.length; i++) {
            if (this.users[i].equals(user)) {
                return i;
            }
        }
        return -1;
    };
    Session.users = [];
    return Session;
}());
exports.Session = Session;
