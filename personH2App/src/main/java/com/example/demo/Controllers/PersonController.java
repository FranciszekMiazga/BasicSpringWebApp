package com.example.demo.Controllers;

import com.example.demo.Models.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/person")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }
    @PostMapping
    public void addNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }
    @DeleteMapping(path="{personId}")
    public void deletePerson(@PathVariable("personId")Long personId){
        personService.deleteStudent(personId);
    }
}
