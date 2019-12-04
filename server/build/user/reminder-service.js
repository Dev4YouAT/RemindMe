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
Object.defineProperty(exports, "__esModule", { value: true });
var session_1 = require("../session");
var ReminderService = /** @class */ (function (_super) {
    __extends(ReminderService, _super);
    function ReminderService() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ReminderService.prototype.create = function (reminder) {
    };
    ReminderService.prototype.get = function (userID) {
        var result = [];
        session_1.Session.reminders.forEach(function (r) {
            if (r.createdBy === userID) {
                result.push(r);
            }
        });
        return result;
    };
    ReminderService.prototype.update = function (reminder) {
    };
    ReminderService.prototype.delete = function (id) {
    };
    return ReminderService;
}(session_1.Session));
exports.ReminderService = ReminderService;
