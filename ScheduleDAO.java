package com.example.bus.dao;

import com.example.bus.model.Schedule;
import com.example.bus.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    public List<Schedule> findByRouteAndDate(String origin, String destination, Date date) throws SQLException {
        String sql = "SELECT s.* FROM SCHEDULE s JOIN ROUTE r ON s.route_id=r.route_id "
                   + "WHERE r.origin=? AND r.destination=? AND s.travel_date=?";
        List<Schedule> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, origin);
            ps.setString(2, destination);
            ps.setDate(3, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setScheduleId(rs.getInt("schedule_id"));
                s.setBusId(rs.getInt("bus_id"));
                s.setRouteId(rs.getInt("route_id"));
                s.setTravelDate(rs.getDate("travel_date"));
                s.setDepartureTime(rs.getString("departure_time"));
                s.setArrivalTime(rs.getString("arrival_time"));
                s.setFare(rs.getDouble("fare"));
                list.add(s);
            }
        }
        return list;
    }
}
