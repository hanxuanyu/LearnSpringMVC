package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用RESTFul实现用户的增删改查操作
 * 请求路径：/user
 * 查询所有用户信息：/user       GET
 * 查询单个用户信息：/user/id    GET
 * 新增用户：       /user       POST
 * 删除用户：       /user/id    DELETE
 * 修改用户：       /user       PUT
 * date 2021/9/8 14:46
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable String id) {
        System.out.println("查询ID为" + id + "的用户的信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password) {
        System.out.println("添加用户信息：" + username + ", " + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息：" + username + ", " + password);
        return "success";
    }


}

