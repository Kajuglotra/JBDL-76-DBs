package org.gfg.dbs.repository;

import org.gfg.dbs.entity.Person;

import java.util.List;

public interface DbRepo {

    List<Person> getPersonData();

    int addPerson(String  name, int id );

    int addPersonWithPreparedStatement(String  name, int id);
}
