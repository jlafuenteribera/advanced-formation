import { Router } from 'express';
import { Controller } from '../controllers/controller';

export class Routes {
  public router: Router;
  private controller: Controller = new Controller();

  public constructor() {
    this.router = Router();
    this.routes();
  }

  private routes(): void {
    this.router.route('/').get(this.controller.demo);
  }
}
