package com.calarix.data.jpa.projection;

import com.calarix.data.jpa.projection.classes.PersonDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<PersonView> findBy();
    <T> T findByFirstName(String firstName, Class<T> type);

}
