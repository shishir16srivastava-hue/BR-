package com.example.bus.servlet;

import com.example.bus.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        int userId = 1; // demo user

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement(
                  "INSERT INTO bookings(schedule_id, user_id) VALUES (?,?)");
            ps.setInt(1, scheduleId);
            ps.setInt(2, userId);
            ps.executeUpdate();

            req.getRequestDispatcher("confirmation.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("error.jsp")
               .forward(req, resp);
        }
    }
}
