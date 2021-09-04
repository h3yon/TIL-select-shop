package com.sparta.week02.controller;

import com.sparta.week02.domain.Person.Person;
import com.sparta.week02.domain.Person.PersonRepository;
import com.sparta.week02.domain.Person.PersonRequestDto;
import com.sparta.week02.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/persons")
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @PostMapping("")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @GetMapping("")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @PutMapping("/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        return personService.updatePerson(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }



}
