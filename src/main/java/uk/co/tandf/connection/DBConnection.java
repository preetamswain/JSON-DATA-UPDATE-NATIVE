package uk.co.tandf.connection;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;

    public Connection getDBConnection() {
        Connection connection = null;
        try {
            //System.out.println("Connection: "+db_url);
            connection = DriverManager.getConnection(db_url, db_user, db_pwd);
            //System.out.println("is connected to db :"+!connection.isClosed());
        } catch (SQLException e) {
            System.out.println("SQLException in DB connection");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}
