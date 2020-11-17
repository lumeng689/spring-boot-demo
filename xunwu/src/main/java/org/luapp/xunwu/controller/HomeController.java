package org.luapp.xunwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 86150
 * @create: 2020/11/15
 **/
@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
