package com.example.demo.DataAccess;

import com.example.demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDA extends MongoRepository<Person, String> {

//    @Override
//    List<Person> findAll();

}
