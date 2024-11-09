package org.gfg.dbs.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbConnection {

    @Bean
    public Connection getConnection(){
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
//    @Bean
//    public DataSource getDataSource(){
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.driverClassName("com.mysql.cj.jdbc.Driver");
//        builder.url("jdbc:mysql://localhost:3306/JBDL_76_DB");
//        builder.username("root");
//        builder.password("rootroot");
//        return builder.build();
//    }

}
// finally is associated with try
// once try is done
// finally will get executed after try ?
// hikari
