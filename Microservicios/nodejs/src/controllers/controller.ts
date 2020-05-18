import { Request, Response } from "express";

export class Controller {
  public async demo(req: Request, res: Response): Promise<void> {
    res.header("Content-Type",'application/json');
    res.status(200).send(JSON.stringify(process.env, null, 4));
  }
}
