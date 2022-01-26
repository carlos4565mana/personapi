package com.carlos.personapi.services;

import com.carlos.personapi.dto.mapper.PersonMapper;
import com.carlos.personapi.dto.request.PersonDTO;
import com.carlos.personapi.dto.response.MessageResponseDTO;
import com.carlos.personapi.entities.Person;
import com.carlos.personapi.exception.PersonNotFoundException;
import com.carlos.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO)
    {
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person =  verifyIfExists(id);.
        return personMapper.toDTO(person);
    }

    private Person verifyIfExists(Long id) throws  PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
    }

    public void delete(Long id) throws PersonNotFoundException{
        verifyIfExists(id);
        personRepository.deleteById(id);
    }
}
/*
 sem map struct
 Person personToSave = Person
                .builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .birthDate(personDTO.getBirthDate())
                .phones(personDTO.getPhones())
                .build();

 */
 /*Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }*/