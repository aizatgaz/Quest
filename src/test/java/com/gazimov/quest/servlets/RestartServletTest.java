package com.gazimov.quest.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

class RestartServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    private RestartServlet restartServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        restartServlet = new RestartServlet();
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        when(session.getAttribute("name")).thenReturn("John");
        when(session.getAttribute("ipAddress")).thenReturn("1");
        when(session.getAttribute("gameCounter")).thenReturn("2");

        restartServlet.doGet(request, response);

        verify(request, times(3)).getSession();
        verify(session, times(3)).getAttribute(any());
        verify(session, times(3)).setAttribute(anyString(), any());
        verify(response).sendRedirect("/logic");
    }

}