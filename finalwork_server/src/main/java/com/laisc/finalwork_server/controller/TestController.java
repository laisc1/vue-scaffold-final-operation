package com.laisc.finalwork_server.controller;

import com.laisc.finalwork_server.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @ResponseBody
    @RequestMapping("/login")
    public String sessionLogin(HttpSession session){
        session.setAttribute("test","12345");
        session.setAttribute("login",1);
        return "login";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String sessionLogout(HttpSession session, Model model)throws ServletException, IOException {
        session.invalidate();
        return "logout";
    }

    @ResponseBody
    @RequestMapping("/getinfo")
    public String getSession(HttpSession session, Model model)throws ServletException, IOException {
        String a = (String) session.getAttribute("test");
        Integer b = (Integer) session.getAttribute("login");
        return b.toString();
    }
}
