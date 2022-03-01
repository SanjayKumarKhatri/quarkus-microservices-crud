package com.teresol.dataaccess.ms.dataaccess_ms_crud.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;

@RequestScoped
public class GlobalDBConnection {

    Connection connection=null;

        @Inject
        AgroalDataSource dataSource;

        public Connection getConnection() {
            try {
                connection= dataSource.getConnection();
                if(connection!=null){
                    System.out.println("............................"+connection);
                }               
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    
}
