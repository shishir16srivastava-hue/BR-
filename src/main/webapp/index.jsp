<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Bus Reservation - Search</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="container">
    <h1>Search Buses</h1>
    <form action="search" method="post">
      <label>Origin<input name="origin" required></label>
      <label>Destination<input name="destination" required></label>
      <label>Travel Date<input name="travel_date" type="date" required></label>
      <button type="submit">Search</button>
    </form>
    <p class="hint">Default demo user id = 1 is used for bookings. Create users via SQL if needed.</p>
  </div>
</body>
</html>
