package com.gazimov.quest.servlets;

import java.io.*;

import com.gazimov.quest.DB.QuestDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    //Счетчик кол-ва игр
    private int gameCounter = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        QuestDB quest = new QuestDB();

        //Получаем значение, на которую нажал пользователь
        String pressedButton = null;
        if (request.getParameter("button") != null) {
            pressedButton = request.getParameter("button");
        }

        //Стартовый вопрос и последующие, в зависимости от того на какую кнопку нажмёт пользователь
        String question = "Ты потерял память. Принять вызов НЛО?";
        if (pressedButton != null) {
            question = quest.getAnswers().get(pressedButton);
        }

        //Занесение в сессию объектов @question и @question побольше)
        session.setAttribute("question", question);
        session.setAttribute("bigQuestion", quest.getLongQuests().get(question));

        //Создание кнопок, которые дают пользователю выбор, они заключены в try-catch блок, так как метод getQuest возвращает мапу
        //содержащую null значение, при победе или поражении, кнопки не появляются.
        //(от этого можно избавиться, но пора переходить на другой проект)
        String buttonOne = null;
        String buttonTwo = null;
        try {
            buttonOne = quest.getQuests().get(question).getString1();
            buttonTwo = quest.getQuests().get(question).getString2();
        } catch (Exception e) {}

        //Проверка на победу, поражение или продолжение квеста
        if (question.contains("Поражение")) {
            session.setAttribute("buttonOne", "lose");
            session.setAttribute("buttonTwo", "lose");
        } else if (question.contains("Победа")) {
            session.setAttribute("buttonOne", "win");
            session.setAttribute("buttonTwo", "win");
        } else {
            session.setAttribute("buttonOne", buttonOne);
            session.setAttribute("buttonTwo", buttonTwo);
        }

        response.sendRedirect("/game.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        //Получение имени, ip адреса и количества сыгранных игр
        session.setAttribute("name", req.getParameter("name"));
        session.setAttribute("ipAddress", req.getRemoteAddr());
        session.setAttribute("gameCounter", gameCounter);

        resp.sendRedirect("/logic");
    }
}