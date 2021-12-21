package com.servlet;

import com.google.gson.Gson;
import com.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{

    protected void javascriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("AJAX请求过来了");

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("jQueryAjax == AJAX请求过来了");

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("jQueryAjax == AJAX请求过来了");

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("jQueryAjax == AJAX请求过来了");

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void getJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("getJSON == AJAX请求过来了");

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("jQuerySerialize == AJAX请求过来了");

        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));

        Person person = new Person(1,"巨魔叔叔");
        //客户端和服务器不在一台电脑上用Json字符串传输
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
}
