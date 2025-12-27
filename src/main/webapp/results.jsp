<%@ page import="java.util.List" %>
<%@ page import="com.example.bus.model.Schedule" %>
<%
    List<Schedule> schedules = (List<Schedule>) request.getAttribute("schedules");
%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Search Results</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="container">
    <h1>Available Schedules</h1>
    <c:if test="${empty schedules}">
      <p>No schedules found.</p>
    </c:if>
    <table>
      <tr><th>Schedule ID</th><th>Departure</th><th>Arrival</th><th>Date</th><th>Fare</th><th>Action</th></tr>
      <%
        if (schedules != null) {
            for (Schedule s : schedules) {
      %>
      <tr>
        <td><%= s.getScheduleId() %></td>
        <td><%= s.getDepartureTime() %></td>
        <td><%= s.getArrivalTime() %></td>
        <td><%= s.getTravelDate() %></td>
        <td><%= s.getFare() %></td>
        <td>
          <form action="book" method="post" style="display:inline">
            <input type="hidden" name="schedule_id" value="<%= s.getScheduleId() %>"/>
            Seat no: <input name="seat_no" value="1" size="2"/>
            <button type="submit">Book</button>
          </form>
        </td>
      </tr>
      <%
            }
        }
      %>
    </table>
    <p><a href="index.html">Back to Search</a></p>
  </div>
</body>
</html>
