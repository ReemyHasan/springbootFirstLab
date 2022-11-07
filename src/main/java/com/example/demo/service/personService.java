package com.example.demo.service;

import com.example.demo.DataAccess.PersonDA;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class personService {

    @Autowired
    private PersonDA personDA;
    private int personID = 1;
//    private List<Person> personList = new CopyOnWriteArrayList<>();

    public Person addPerson(Person person){
//        person.setId(personID);
//        personID++;
//        personList.add(person);
        return personDA.save(person);
//        return person;
    }

    public List<Person> getPersonList() {
        return personDA.findAll();
//        return personList;
    }
    public Person getPerson(String ID){
//        return personList
//                .stream().filter(
//                        c-> c.getId() == ID
//                ).findFirst()
//                .get();
        Optional<Person> optionalPerson = personDA.findById(ID);
        if(!optionalPerson.isPresent())
            throw new PersonNotFoundException("Person with ordered ID is Not Found");
        return optionalPerson.get();
    }
    public Person UpdatePersonInfo(String ID, Person person){
        person.setId(ID);
//        personList.stream()
//                .forEach(
//                        c-> {
//                            if(c.getId() == ID)
//                            {
//                                c.setFirstName(person.getFirstName());
//                                c.setLastName(person.getLastName());
//                                c.setAge(person.getAge());
//                            }
//                        }
//                );
//        person.setId(ID);
        personDA.save(person);
        return person;

    }
    public void deletePerson(String ID){
//        personList.stream()
//                .forEach(
//                        c->{
//                            if(c.getId() == ID)
//                                personList.remove(c);
//                        }
//                );
        personDA.deleteById(ID);

    }
    /*Delete All people from database Function */
    public void deleteAllPerson(){

        personDA.deleteAll();

    }
}
