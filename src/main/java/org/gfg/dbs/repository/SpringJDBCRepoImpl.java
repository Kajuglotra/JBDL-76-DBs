package org.gfg.dbs.repository;

import org.gfg.dbs.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpringJDBCRepoImpl implements DbRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Person> getPersonData() {

        return jdbcTemplate.query("select * from person", new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//              return Person.builder().id(rs.getInt(2)).name(rs.getString(1)).build();
              return new Person(rs.getString(1), rs.getInt(2));
            }
        });

    }

    @Override
    public int addPerson(String name, int id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name", name);
        source.addValue("id", id);
        return namedParameterJdbcTemplate.update("insert into person (name, id) VALUES (:name, :id)", source);
    }

    @Override
    public int addPersonWithPreparedStatement(String name, int id) {
        return 0;
    }
}
// ORM ?

