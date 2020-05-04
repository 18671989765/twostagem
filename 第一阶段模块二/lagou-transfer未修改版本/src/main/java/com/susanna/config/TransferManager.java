package com.susanna.config;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * 进行实物管理
 */
public class TransferManager {

    public static void  begin() throws SQLException {
        ConnectionUtil.getInstance().getConnection().setAutoCommit(false);
    }


    public static void  rollback() throws SQLException {
        ConnectionUtil.getInstance().getConnection().rollback();

    }


    public static void  commit() throws SQLException {
        ConnectionUtil.getInstance().getConnection().commit();

    }
}
