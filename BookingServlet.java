package com.example.bus.servlet;

import com.example.bus.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "BookingServlet", urlPatterns = {"/book"})
public class BookingServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        int scheduleId = Integer.parseInt(req.getParameter("schedule_id"));
        int seatNo = Integer.parseInt(req.getParameter("seat_no"));
        int userId = 1; // demo user (in real app, get from session)
        String sql = "INSERT INTO SEAT_RESERVATION(schedule_id,user_id,seat_number) VALUES(?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, scheduleId);
            ps.setInt(2, userId);
            ps.setInt(3, seatNo);
            ps.executeUpdate();
            resp.sendRedirect(req.getContextPath() + "/confirmation.jsp");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
