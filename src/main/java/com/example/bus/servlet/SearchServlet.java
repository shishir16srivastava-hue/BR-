package com.example.bus.servlet;

import com.example.bus.dao.ScheduleDAO;
import com.example.bus.model.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private ScheduleDAO scheduleDAO;

    @Override
    public void init() {
        scheduleDAO = new ScheduleDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String travelDateStr = request.getParameter("travel_date");

        if (origin == null || destination == null || travelDateStr == null ||
            origin.isEmpty() || destination.isEmpty()) {

            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            Date travelDate = Date.valueOf(travelDateStr);
            List<Schedule> schedules =
                    scheduleDAO.search(origin, destination, travelDate);

            request.setAttribute("schedules", schedules);
            request.getRequestDispatcher("results.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error fetching bus schedules");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
