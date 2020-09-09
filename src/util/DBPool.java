package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBPool
{
    private static DBPool dbPool;
    private ComboPooledDataSource dataSource;

    static
    {
        dbPool = new DBPool();
    }

    public DBPool()
    {
        try
        {
            dataSource = new ComboPooledDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("alizcry");
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/planmng?autoReconnect=true&useUnicode=true&characterEncoding=utf-8");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setInitialPoolSize(2);
            dataSource.setMinPoolSize(1);
            dataSource.setMaxPoolSize(10);
            dataSource.setMaxStatements(50);
            dataSource.setMaxIdleTime(60);
        }
        catch (PropertyVetoException e)
        {
            throw new RuntimeException(e);
        }
    }

    public final static DBPool getInstance()
    {
        return dbPool;
    }

    public final  Connection getConnection()
    {
        try
        {
            return dataSource.getConnection();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("connect error", e);
        }
    }

    public static void main(String[] args) throws SQLException
    {
        Connection con = null;
        try
        {
            con = DBPool.getInstance().getConnection();
            java.sql.ResultSet rs = con.createStatement().executeQuery("select id from tbl_logger_visit");
            while (rs.next())
                System.out.println(rs.getString(1));
        }
        catch (Exception e)
        {
        }
        finally
        {
            if (con != null)
                con.close();
        }
    }
}

