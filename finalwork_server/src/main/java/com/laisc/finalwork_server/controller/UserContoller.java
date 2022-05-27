package com.laisc.finalwork_server.controller;

import com.laisc.finalwork_server.entity.ChangePw;
import com.laisc.finalwork_server.entity.User;
import com.laisc.finalwork_server.mapper.UserMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    UserMapper um;

    @ResponseBody
    @RequestMapping("/findAllUser")
    public String findAllUser() {
        List<User> a = um.findAllUser();
        System.out.println(a.toString());
        return a.toString();
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        List<User> a = um.checkUser(user);
        if (a.size() >= 1) {
            session.setAttribute("login", a.get(0).getId());
            return "成功登录";
        }
        return "用户名或密码错误";
    }

    @ResponseBody//无用，已弃用
    @RequestMapping("/login2")
    public String login2() {
        User a = um.checkUserOne(new User(11, "abc", "123", "", ""));
        System.out.println(a.toString());
        return a.toString();
    }

    @ResponseBody
    @RequestMapping("/getRole")
    public String getRole(HttpSession session) {
        Integer a = (Integer) session.getAttribute("login");
        String role = null;
        if (a != null) {
            role = um.findUserById(a).getRole();
        } else {
            role = "nologin";
        }

        return role;
    }

    @ResponseBody
    @RequestMapping("/getUsername")
    public String getUsername(HttpSession session) {
        Integer a = (Integer) session.getAttribute("login");
        String username = null;
        if (a != null) {
            username = um.findUserById(a).getUsername();
        } else {
            username = "nologin";
        }

        return username;
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(HttpSession session) {
        Integer a = (Integer) session.getAttribute("login");
        User user = null;
        if (a != null) {
            user = um.findUserWithNoPassword(a);
        } else {
            user = null;
        }

        return user;
    }

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello(HttpSession session) {
        String role = getRole(session);
        String username = getUsername(session);
        String myhello = "";

        if ("admin".equals(role)) {
            myhello = "欢迎，管理员：" + username;
        }
        if ("nologin".equals(role)) {
            myhello = "欢迎，游客：" + username;
        }
        if ("author".equals(role)) {
            myhello = "欢迎，作者：" + username;
        }
        if ("user".equals(role)) {
            myhello = "欢迎，用户：" + username;
        }
        return myhello;
    }

    @ResponseBody
    @RequestMapping("/userReg")
    public String userReg(@RequestBody User user) {
        int myinsert = um.insertUser(user);
        if (myinsert == 1) {
            return "成功！";
        }
        return "失败！";
    }

    @ResponseBody
    @RequestMapping("/findUserWithNoPassword")
    public String findUserWithNoPassword(HttpSession session, @RequestBody User user) {
        String role = getRole(session);
        String jsonstr;
        if ("admin".equals(role)) {
            User u = um.findUserWithNoPassword(user.getId());
            if (u != null) {
                JSONObject object = JSONObject.fromObject(u);
                jsonstr = object.toString();
            } else {
                u = new User(0, "nologin", "", "", "");
                JSONObject object = JSONObject.fromObject(u);
                jsonstr = object.toString();
            }
            return jsonstr;
        } else {
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/findAllUserWithNoPassword")
    public String findAllUserWithNoPassword(HttpSession session) {
        String role = getRole(session);
        String jsonstr = null;
        if ("admin".equals(role)||true) {
            List<User> u = um.findAllUserWithNoPassword();
            JSONArray jsonarray = JSONArray.fromObject(u);
            jsonstr = jsonarray.toString();
            return jsonstr;
        } else {

            return null;
        }
    }


    @ResponseBody
    @RequestMapping("/updateUserByAdmin")
    public String updateUserByAdmin(@RequestBody User user, HttpSession session) {
        String role = getRole(session);
        if ("admin".equals(role)) {
            int a = um.updateUser(user);
            if (a >= 1) {
                return "成功！";
            }
            return "失败！";
        } else {
            return "权限不足！";
        }
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user, HttpSession session) {
        Integer id = (Integer) session.getAttribute("login");

        user.setId(id);
        user.setUsername("");
        user.setPassword("");
        user.setRole(getRole(session));
        System.out.println(getRole(session));
        if (id!=null&&id>0) {
            int a = um.updateUser(user);
            if (a >= 1) {
                return "成功！";
            }
            return "失败！";
        } else {
            return "未登录！";
        }
    }


    @ResponseBody
    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestBody ChangePw changepw, HttpSession session) {
        int a = um.changeUserPassword(changepw);
        if(a>=1){
            return "成功！";
        }else{
            return "失败！";
        }
    }

    @ResponseBody
    @RequestMapping("/delUser")
    public String delUser(@RequestBody User user, HttpSession session) {

        String role = getRole(session);
        if("admin".equals(role)){
            int a = um.delUser(user.getId());
            if(a>=1){
                return "成功！";
            }else{
                return "失败！";
            }
        }else{
            return "权限不足！";
        }

    }



    @ResponseBody
    @RequestMapping("/logout")
    public String sessionLogout(HttpSession session, Model model) throws ServletException, IOException {
        session.invalidate();
        return "logout";
    }
}
