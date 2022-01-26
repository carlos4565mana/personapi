package com.carlos.personapi.dto.mapper;


import com.carlos.personapi.dto.request.PersonDTO;
import com.carlos.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public class PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target ="birthDate", source = "birthDate", dateFormat = "dd-mm-yyyy");
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}
