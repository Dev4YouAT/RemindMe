"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Reminder = /** @class */ (function () {
    function Reminder(id, createdBy, createdOn, name, imageName, birthdate, gender) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.name = name;
        this.imageName = imageName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    return Reminder;
}());
exports.Reminder = Reminder;
