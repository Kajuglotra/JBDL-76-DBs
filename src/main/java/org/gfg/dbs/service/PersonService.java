package org.gfg.dbs.service;

import jakarta.transaction.Transactional;
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
import java.util.UUID;

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
    @Transactional
    public int addPersonWithJPA(String name, int id) {
//        MyPerson p= MyPerson.builder().age(3).build();
        String id1 = UUID.randomUUID().toString();
        MyPerson p = repository.save(new MyPerson(name));
        System.out.println(p);
        repository.getById(p.getId());
        return 1;
    }
}
// factory design pattern
