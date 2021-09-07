package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.table.TableColumn;

/**
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        // 返回视图名称
        return "index";
    }

    private String t;



    public int test(String str, int a){

        return 0;
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}


