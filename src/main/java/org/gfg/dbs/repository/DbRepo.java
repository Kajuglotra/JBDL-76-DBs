package org.gfg.dbs.repository;

import org.gfg.dbs.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DbRepo {

    List<Person> getPersonData();

    int addPerson(String  name, int id );

    int addPersonWithPreparedStatement(String  name, int id);
}
