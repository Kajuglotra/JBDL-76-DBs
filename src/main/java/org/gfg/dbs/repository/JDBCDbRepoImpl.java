package org.gfg.dbs.repository;

import org.gfg.dbs.entity.Person;
import org.gfg.dbs.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCDbRepoImpl implements DbRepo{

    private Connection connection; // null

    public JDBCDbRepoImpl(Connection connection){
        this.connection = connection;
        createTable();
    }
    @Override
    public List<Person> getPersonData() {
        List<Person> list = new ArrayList<>();
        try {
            ResultSet set = connection.createStatement().executeQuery("select * from person");
            // mapping Object relational mapping
            while(set.next()){
                list.add(new Person(set.getString(1), set.getInt(2)));
            }
            return  list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addPerson(String  name, int id) {
        try {
            return connection.createStatement().executeUpdate("insert into person(name, id) VALUES ('"+ name + "'," + id + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addPersonWithPreparedStatement(String name, int id) {
        try{
            boolean currentAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement("insert into person(name, id) VALUES(?, ?)");
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, id);
            int output =  prepareStatement.executeUpdate();
            int a = 2/id;
            connection.commit();
            connection.setAutoCommit(currentAutoCommit);
            return output;
        }catch (ArithmeticException ex){
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex.getMessage());
        } catch(SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    public void createTable(){
        try{
            connection.createStatement().execute("create table if not exists person (name varchar(25), id int)");
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
// databases:  i need to make a connection from my application to mysql databases
// jdbc connection ?

// database data exchange
// connection
// create statement : queries
// execute your queries into underlying database
// 1) return u the no. of rows that has been manipulated : 10
// update table set name = "venkat"  where id =2 ; // all row : 10 , 0

// prepared statement