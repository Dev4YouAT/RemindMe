"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ex = require("express");
var App = /** @class */ (function () {
    function App() {
        this.express = ex();
        this.mountRoutes();
    }
    App.prototype.mountRoutes = function () {
        var router = ex.Router();
        router.get('/', function (req, res) {
            res.json({
                message: 'Hello World!'
            });
        });
        this.express.use('/', router);
    };
    return App;
}());
exports.default = new App().express;
