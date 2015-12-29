package com.boxfish.lhb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by boxfish on 15/12/28.
 */

@Controller
public class UserInfoController {

    @RequestMapping("/me")
    @ResponseBody
    public String getInfo(Principal principal) {
        System.err.println(String.format("%s access \"\\me\" ", principal.getName()));
        return String.format("Hello, %s! WelCome to OAuth2 World!",principal.getName());
    }
}
