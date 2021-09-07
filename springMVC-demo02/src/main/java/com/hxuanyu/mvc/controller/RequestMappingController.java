package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * description:  TODO
 * date:    2021/9/7 10:06
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/testRequestMapping", "test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username", "password"}
    )
    public String testParams() {
        return "success";
    }

    @RequestMapping("/**/testAnt")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("testRest/{id}/{username}")
    public String testRest(
            @PathVariable("id") String id,
            @PathVariable("username") String username
    ) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        return "success";
    }
}
