import { Routes } from "./routes/routes";
import express from "express";

class App {
  public app: express.Application;

  public constructor() {
    this.app = express();
    this.config();
    this.routes();
  }

  private config(): void {
    this.app.set('port', 8080);
  }

  private routes(): void {
    this.app.use('/', new Routes().router);
  }
}

export default new App().app;
