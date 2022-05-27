package com.laisc.finalwork_server.controller;

import com.laisc.finalwork_server.entity.Article;
import com.laisc.finalwork_server.entity.User;
import com.laisc.finalwork_server.mapper.ArticleMapper;
import com.laisc.finalwork_server.mapper.UserMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleMapper am;
    @Autowired
    UserMapper um;

    @ResponseBody
    @RequestMapping("/findAllArticle")
    public String findAllArticle() {
        List<Article> a = am.findAllArticle();
        System.out.println(a.toString());

        JSONArray jsonarray = JSONArray.fromObject(a);
        String jsonstr = jsonarray.toString();

        return jsonstr;
    }


    @ResponseBody
    @RequestMapping("/findArticleById")
    public String findArticleById(@RequestBody Article article) {
        List<Article> a = am.findArticleById(article.getId());
        System.out.println(a.toString());
        String jsonstr;
        if (a.size() >= 1) {

            JSONObject object = JSONObject.fromObject(a.get(0));
            jsonstr = object.toString();
        } else {
            Article ae = new Article(0, "err", "err");
            JSONObject object = JSONObject.fromObject(ae);
            jsonstr = object.toString();
        }
        return jsonstr;
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
    @RequestMapping("/addArticle")
    public String addArticle(@RequestBody Article article, HttpSession session) {

        String role = getRole(session);
        if ("admin".equals(role) || "author".equals(role)) {
            int myinsert = am.insertArticle(article);
            if (myinsert == 1) {
                return "成功！";
            }
            return "失败！";
        }else{
            return "权限不足！";
        }
    }

    @ResponseBody
    @RequestMapping("/updateArticle")
    public String updateArticle(@RequestBody Article article, HttpSession session) {
        String role = getRole(session);
        if ("author".equals(role) || "admin".equals(role)) {
            int myinsert = am.updateArticle(article);
            if (myinsert == 1) {
                return "成功！";
            }
            return "失败！";
        } else {
            return "权限不足！";
        }
    }

    @ResponseBody
    @RequestMapping("/delArticle")
    public String delArticle(@RequestBody Article article, HttpSession session) {

        String role = getRole(session);
        if ("author".equals(role) || "admin".equals(role)) {
            int mydel = am.delArticle(article.getId());
            if (mydel == 1) {
                return "成功！";
            }
            return "失败！";
        } else {
            return "权限不足！";
        }
    }

}
