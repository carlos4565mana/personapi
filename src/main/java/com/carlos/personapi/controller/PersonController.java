package com.carlos.personapi.controller;

import com.carlos.personapi.entities.Person;
import com.carlos.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public String createPerson(@RequestBody Person person)
    {
        personRepository.save(person);
        return "API test";
    }
}
