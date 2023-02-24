package com.example.neorisdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @RequestMapping(value = "/cuenta", method = RequestMethod.GET)
    public String getUsers() { return "hello"; }
}
