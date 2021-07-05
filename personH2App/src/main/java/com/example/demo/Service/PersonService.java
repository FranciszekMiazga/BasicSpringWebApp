package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.PersonRepository;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> person1 = personRepository.findPersonByLastName(person.getLastName());
        if(person1.isPresent()){
            throw new IllegalStateException("last name taken");
        }
        personRepository.save(person);
    }

    public void deleteStudent(Long personId) {
        boolean exists=personRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("Student with id "+personId+" does not exist");
        }
        personRepository.deleteById(personId);
    }
}
