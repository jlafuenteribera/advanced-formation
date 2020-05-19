package wear.clothes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("")
    public ResponseEntity<?> demo() {
        return new ResponseEntity<>(System.getenv(), HttpStatus.OK);
    }

}
