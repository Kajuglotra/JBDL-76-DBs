package org.gfg.dbs.repository;

import org.gfg.dbs.entity.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPersonRepository extends JpaRepository<MyPerson, Integer> {
}
// not using any bean annotation

// spring boot project
