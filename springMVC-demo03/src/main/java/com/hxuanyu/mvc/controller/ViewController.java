package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图测试
 * date 2021/9/8 10:36
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}
