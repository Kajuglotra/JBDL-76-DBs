package org.gfg.dbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbConnection {

    @Bean
    public Connection connection(){
        Connection connection = null;
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBDL_76_DB", "root", "rootroot");
            return connection;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("finally is getting executed");
        }

    }
}
// finally is associated with try
// once try is done
// finally will get executed after try ?

