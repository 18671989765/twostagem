package com.susanna.config;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.susanna.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private ConnectionUtil(){}
    private static ConnectionUtil instance = new ConnectionUtil();
    public static ConnectionUtil getInstance(){
        return instance;
    }

    /**
     * 让当前线程与数据库链接进行绑定
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {

         Connection connection= threadLocal.get();
        if(null == connection){
            Connection connection1 = DruidUtils.getInstance().getConnection();
            threadLocal.set(connection1);
            return connection1;
        }
        return  connection;
    }


}
