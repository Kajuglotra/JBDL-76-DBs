package org.gfg.dbs.service;

import org.gfg.dbs.entity.Person;
import org.gfg.dbs.repository.DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private DbRepo dbRepo;

    public List<Person> getPersonInfo() {
        return dbRepo.getPersonData();
    }

    public int addPerson(String name, int id) {
//        return dbRepo.addPerson(name, id);
        return dbRepo.addPersonWithPreparedStatement(name,id);
    }
}
