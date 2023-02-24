package com.example.neorisdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovementsController {

    @RequestMapping(value = "/movimientos", method = RequestMethod.GET)
    public String getUsers() { return "hello"; }
}
