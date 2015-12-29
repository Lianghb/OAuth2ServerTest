package com.boxfish.lhb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by boxfish on 15/12/29.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {

        return "login";

    }
}
