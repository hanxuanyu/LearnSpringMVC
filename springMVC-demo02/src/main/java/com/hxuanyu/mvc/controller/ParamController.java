package com.hxuanyu.mvc.controller;

import com.hxuanyu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * TODO
 * date 2021/9/7 14:16
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletApi(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "   " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "host", required = false, defaultValue = "localhost") String host,
            @CookieValue("JSESSIONID") String cookie
    ) {
        System.out.println("username :" + username + "\npassword : " + password + "\nhobby : " + Arrays.toString(hobby));
        System.out.println("host: " + host);
        System.out.println("cookie: " + cookie);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

}
