package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 * date 2021/9/8 18:54
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class EmployeeController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
