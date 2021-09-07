package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 * date 2021/9/7 16:36
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class ScopController {
    @RequestMapping("/testRequestByServletApi")
    public String testRequestByServletApi(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello");
        return "success";
    }
}
