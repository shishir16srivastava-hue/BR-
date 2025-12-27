Bus Reservation - Runnable Maven WAR project (demo)

How to run (local dev):
1. Install Java 11+ and Maven.
2. Install MySQL and create database:
   - Edit create_tables.sql if needed.
   - Run: mysql -u root -p < create_tables.sql
   - (Optional) Insert a demo user: 
     INSERT INTO USER (name,email,phone,password_hash,role) VALUES ('Demo User','demo@example.com','9999999999','passhash', 'CUSTOMER');

3. Configure DB credentials:
   - Edit src/main/java/com/example/bus/util/DBUtil.java and set USER and PASS.

4. Build:
   cd /path/to/bus-reservation
   mvn clean package

5. Deploy:
   - Copy target/bus-reservation.war into Tomcat's webapps directory and start Tomcat.
   - Visit: http://localhost:8080/bus-reservation/

Notes:
- This is a demo skeleton. For production, add password hashing, sessions, input validation, and security.
