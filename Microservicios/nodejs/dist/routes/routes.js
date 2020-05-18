"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const controller_1 = require("../controllers/controller");
class Routes {
    constructor() {
        this.controller = new controller_1.Controller();
        this.router = express_1.Router();
        this.routes();
    }
    routes() {
        this.router.route('/').get(this.controller.demo);
    }
}
exports.Routes = Routes;
