package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 * date 2021/9/9 10:23
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class TestController {
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testException() {
        // 模拟异常
        System.out.println(10 / 0);
        return "success";
    }
}
