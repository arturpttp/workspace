package net.dev.art.core.libs.mysql;

import java.sql.Connection;

public class MysqlObject {

    public MysqlConnection mysql;
    private Connection connection;

    public MysqlObject(MysqlConnection mysql) {
        this.mysql = mysql;
        this.connection = mysql.connection;
    }


    public Connection getConnection() {
        return connection;
    }

    public MysqlObject setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }
}
