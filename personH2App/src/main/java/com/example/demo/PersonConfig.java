package com.example.demo;

import com.example.demo.Models.Person;
import com.example.demo.Repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args->{
            Person jan=new Person(
                    "Jan",
                    "Kowalski",
                    LocalDate.of(2000, Month.APRIL,5
                    ));
            Person maria=new Person(
                    "Maria",
                    "Nowak",
                    LocalDate.of(2004, Month.DECEMBER,22
                    ));
            repository.saveAll(List.of(maria,jan));
        };
    }
}
