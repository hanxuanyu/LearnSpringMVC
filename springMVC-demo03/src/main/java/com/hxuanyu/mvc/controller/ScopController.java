package com.hxuanyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("testRequestScope", "hello, ModelAndView");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "data from model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "data from map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "data from model map");
        return "success";
    }

    @RequestMapping("testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello session");

        return "success";
    }

    @RequestMapping("testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello application");
        return "success";
    }
}
