package net.dev.art.core.libs.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMysqlConnection {

    public void open() throws SQLException;

    public void close() throws SQLException;

    public ResultSet query(String sql, String... placeholders) throws SQLException;

}
