package employe.management.systeme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection conn;
    Statement statement;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionemployee", "root", "");
            System.out.println(conn);
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return statement;
    }
}
