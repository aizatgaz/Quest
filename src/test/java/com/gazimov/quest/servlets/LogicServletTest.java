package com.gazimov.quest.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import java.io.IOException;


class LogicServletTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    private LogicServlet logicServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        logicServlet = new LogicServlet();
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGet() throws IOException {
        logicServlet.doGet(request, response);

        // Проверяем, что были вызваны ожидаемые методы
        verify(request, times(1)).getSession();
        verify(request, times(1)).getParameter("button");
        verify(session, times(4)).setAttribute(anyString(), any());

        // Можно добавить дополнительные проверки значений атрибутов сессии и т.д.
    }

    @Test
    public void testDoPost() throws IOException {
        when(request.getParameter("name")).thenReturn("John");

        logicServlet.doPost(request, response);

        // Проверяем, что были вызваны ожидаемые методы
        verify(request, times(1)).getSession();
        verify(request, times(1)).getParameter("name");
        verify(session, times(3)).setAttribute(anyString(), any());
        verify(response, times(1)).sendRedirect("/logic");

        // Можно добавить дополнительные проверки значений атрибутов сессии и т.д.
    }
}