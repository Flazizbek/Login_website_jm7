package org.example.homework_jm7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.homework_jm7.user.User;
import org.example.homework_jm7.user.UserService;

import java.io.IOException;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("signup".equals(req.getParameter("action"))) {
            try {
                User user = UserService.add(
                        req.getParameter("username"),
                        req.getParameter("email"),
                        req.getParameter("password")
                );
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/menu.jsp");
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/auth.jsp?action=signup").forward(req, resp);
            }
        } else if ("signin".equals(req.getParameter("action"))) {
            try {
                User user = UserService.getByEmail(
                        req.getParameter("email"),
                        req.getParameter("password")
                );
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/menu");
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/auth.jsp?action=signin").forward(req, resp);
            }
        }
    }
}
