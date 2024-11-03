package org.gfg.dbs.service;

import org.gfg.dbs.entity.MyPerson;
import org.gfg.dbs.entity.Person;
import org.gfg.dbs.repository.DbRepo;
import org.gfg.dbs.repository.JDBCDbRepoImpl;
import org.gfg.dbs.repository.MyPersonRepository;
import org.gfg.dbs.repository.SpringJDBCRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

//    @Autowired
//    @Qualifier(value = "")
//    private DbRepo dbRepo;
//    JpaRepository

    @Autowired
    private SpringJDBCRepoImpl springJDBCRepoImpl;

    @Autowired
    private JDBCDbRepoImpl jdbcDbRepo;

    @Autowired
    private MyPersonRepository repository;


    public List<Person> getPersonInfo() {
        return springJDBCRepoImpl.getPersonData();
    }

    public int addPerson(String name, int id) {
//        return dbRepo.addPerson(name, id);
        DbRepo repo = decideRepo("springjdbc");
        return repo.addPerson(name,id);
    }

    private DbRepo decideRepo(String springjdbc) {
        if(springjdbc.equalsIgnoreCase("springjdbc"))
            return springJDBCRepoImpl;
        else{
            return jdbcDbRepo;
        }
    }

    public int addPersonWithJPA(String name, int id) {
        MyPerson p= MyPerson.builder().age(3).build();
//        MyPerson p = repository.save(new MyPerson(id, name));
        System.out.println(p);
        return 1;
    }
}
// factory design pattern
