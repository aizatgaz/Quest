package com.gazimov.quest.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {

    //Просто рестарт игры
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String ipAddress = (String) session.getAttribute("ipAddress");

        String name = (String) session.getAttribute("name");

        int gameCounter = Integer.parseInt(String.valueOf(session.getAttribute("gameCounter")));
        gameCounter++;

        req.getSession().invalidate();

        session = req.getSession();

        session.setAttribute("ipAddress", ipAddress);
        session.setAttribute("name", name);
        session.setAttribute("gameCounter", gameCounter);
        resp.sendRedirect("/logic");
    }
}
