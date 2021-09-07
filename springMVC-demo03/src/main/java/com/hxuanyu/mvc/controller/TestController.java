package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 * date 2021/9/7 16:28
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
