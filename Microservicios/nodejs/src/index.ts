import app from "./app";

app.listen(app.get("port"), "0.0.0.0", (): void => {
  console.log("Puerto: " + app.get("port"));
});
