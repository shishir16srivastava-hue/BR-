package com.example.bus.dao;

import com.example.bus.model.Schedule;
import com.example.bus.util.DBUtil;

import java.sql.*;
import java.util.*;

public class ScheduleDAO {

    public List<Schedule> search(
            String origin, String destination, String date)
            throws Exception {

        List<Schedule> list = new ArrayList<>();

        String sql =
          "SELECT * FROM schedules WHERE origin=? AND destination=? AND travel_date=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, origin);
            ps.setString(2, destination);
            ps.setDate(3, Date.valueOf(date));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Schedule s = new Schedule();
                s.setId(rs.getInt("id"));
                s.setBusName(rs.getString("bus_name"));
                s.setSeats(rs.getInt("seats"));
                s.setFare(rs.getDouble("fare"));
                list.add(s);
            }
        }
        return list;
    }
}
