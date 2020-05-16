package com.calarix.data.jpa.projection;

import com.calarix.data.jpa.projection.classes.PersonDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class JpaProjectionTest {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;

    @Before
    public void insertData(){

        Address address = new Address("CA",
                "city 1", "street 1", "90001");
        Person person = new Person("John", "Doe",null);
        person.setAddress(address);
        personRepository.save(person);
    }

    @Test
    public void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {
        AddressView addressView = addressRepository.getAddressByState("CA").get(0);
        assertThat(addressView.getZipCode()).isEqualTo("90001");


       // no works
        /*
        List<PersonView> personList = personRepository.findBy();
        assertThat(personList.size()).isEqualTo(1);
        assertThat(personList.get(0).getAddress()).isNotNull();*/

        // no works
        PersonView personView = addressView.getPerson();
        assertThat(personView).isNotNull();
        assertThat(personView.getFirstName()).isEqualTo("John");
        assertThat(personView.getLastName()).isEqualTo("Doe");
    }

    @Test
    public void whenUsingDynamicProjections_thenObjectWithRequiredPropertiesIsReturned() {
        Person person = personRepository.findByFirstName("John", Person.class);

        PersonView personView = personRepository.findByFirstName("John", PersonView.class);

        PersonDTO personDto = personRepository.findByFirstName("John", PersonDTO.class);

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(personView.getFirstName()).isEqualTo("John");
        assertThat(personDto.getFirstName()).isEqualTo("John");
    }


}
