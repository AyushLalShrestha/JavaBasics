package com.als.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private Connection conn = null;
    PreparedStatement stmt = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/tbl_students", "root", "");
    }

    public PreparedStatement initStatement(String sql) throws ClassNotFoundException, SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public ResultSet executeQuery() throws ClassNotFoundException, SQLException {
        return stmt.executeQuery();
    }

    public int executeUpdate() throws ClassNotFoundException, SQLException {
        return stmt.executeUpdate();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

}