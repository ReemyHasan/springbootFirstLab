package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping (value = "/Persons")
public class PersonController {

    @Autowired
    private personService PersonRepo;
    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return PersonRepo.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPersons(){
        return PersonRepo.getPersonList();
    }

    @GetMapping(value = "/{personID}")
    public Person getPerson(@PathVariable("personID") String ID){
        return PersonRepo.getPerson(ID);
    }

    @PutMapping(value = "/{personID}")
    public Person UpdatePerson(@PathVariable("personID") String ID,@RequestBody Person person){
        return PersonRepo.UpdatePersonInfo(ID,person);

    }
    @DeleteMapping(value = "/{personID}")
    public void DeletePerson(@PathVariable("personID") String ID){
        PersonRepo.deletePerson(ID);
    }


    /*Delete All People controller function */
    @DeleteMapping
    public void DeleteAllPerson(){

        PersonRepo.deleteAllPerson();
    }


}
