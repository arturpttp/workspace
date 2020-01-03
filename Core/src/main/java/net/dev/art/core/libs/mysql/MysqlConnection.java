package net.dev.art.core.libs.mysql;

import net.dev.art.core.libs.CoreLib;

import java.sql.*;

public class MysqlConnection implements CoreLib, IMysqlConnection {

    public String user, host, port, password, db, url;
    public Connection connection;
    public boolean opened = false;

    public MysqlConnection() {

    }

    public MysqlConnection(String user, String host, String password, String db) {
        this(user, host, "3306", password, db);
    }

    public MysqlConnection(String db) {
        this("root", "localhost", "3306", "", db);
    }

    public MysqlConnection(String user, String host, String port, String password, String db) {
        this.user = user;
        this.host = host;
        this.port = port;
        this.password = password;
        this.db = db;
        this.url = "jdbc:mysql://"+host+":"+port+"/"+db;
    }

    public void open() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            console("§cNão foi possivel encontrar o driver do Mysql!");
        }

        this.connection = DriverManager.getConnection(url, user, password);
        opened = true;
    }

    public void close() throws SQLException {
        if (!connection.isClosed() && connection != null) {
            connection.close();
            connection = null;
            opened = false;
        }
    }

    @Override
    public ResultSet query(String sql, String... placeholders) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);
        if (placeholders.length > 0) {
            int x = 0;
            for (String s : placeholders) {
                stmt.setString(x, s);
                x++;
            }
        }
        stmt.executeQuery();
        return stmt.getResultSet();
    }

    public String getUser() {
        return user;
    }

    public MysqlConnection setUser(String user) {
        this.user = user;
        return this;
    }

    public String getHost() {
        return host;
    }

    public MysqlConnection setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPort() {
        return port;
    }

    public MysqlConnection setPort(String port) {
        this.port = port;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MysqlConnection setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDb() {
        return db;
    }

    public MysqlConnection setDb(String db) {
        this.db = db;
        return this;
    }
}
