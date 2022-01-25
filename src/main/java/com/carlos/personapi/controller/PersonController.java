package com.carlos.personapi.controller;

import com.carlos.personapi.dto.response.MessageResponseDTO;
import com.carlos.personapi.entities.Person;
import com.carlos.personapi.repositories.PersonRepository;
import com.carlos.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person)
    {
        return personService.createPerson(person);
    }
}
