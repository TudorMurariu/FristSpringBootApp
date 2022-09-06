package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getALlPeople();
        /*
            Test
        List<Person> l = new ArrayList<>();
        l.add(new Person(UUID.randomUUID(),"Ana"));
        l.add(new Person(UUID.randomUUID(),"Andrei"));
        l.add(new Person(UUID.randomUUID(),"Matei"));
        return l;*/
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") UUID id){
        return personService.selectPerson(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id,@RequestBody Person person){
        return personService.updatePersonById(id, person);
    }
}
