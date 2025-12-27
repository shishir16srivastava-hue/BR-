<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Error</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="container">
    <h1>Error Occurred</h1>
    <p><%= request.getAttribute("error") %></p>
    <p><a href="index.html">Return Home</a></p>
  </div>
</body>
</html>
