"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Controller {
    async demo(req, res) {
        res.status(200).json(process.env);
    }
}
exports.Controller = Controller;
