package com.example.bus.servlet;

import com.example.bus.dao.ScheduleDAO;
import com.example.bus.model.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    private ScheduleDAO dao = new ScheduleDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin");
        String destination = req.getParameter("destination");
        String dateStr = req.getParameter("travel_date");
        try {
            Date date = Date.valueOf(dateStr);
            List<Schedule> schedules = dao.findByRouteAndDate(origin, destination, date);
            req.setAttribute("schedules", schedules);
            req.getRequestDispatcher("/results.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
