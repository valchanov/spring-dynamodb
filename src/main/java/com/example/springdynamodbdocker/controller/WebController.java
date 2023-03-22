package com.example.springdynamodbdocker.controller;

import com.example.springdynamodbdocker.model.Person;
import com.example.springdynamodbdocker.model.PersonRepository;
import com.example.springdynamodbdocker.model.PrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class WebController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public ResponseEntity getPerson(@PathVariable("id") String id,
                                    @RequestParam(value = "creationDate", required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate) {

        if (creationDate == null) {
            List<Person> people = personRepository.findById(id);
            return ResponseEntity.ok(people);
        }

        return getByPrimaryKey(id, creationDate);
    }

    @PostMapping("/person")
    public ResponseEntity addPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    private ResponseEntity<?> getByPrimaryKey(String id) {
        Optional<Person> mayBePerson = personRepository.findById(id);

        if (mayBePerson.isPresent()) {
            return ResponseEntity.ok(mayBePerson.get());
        }
        return ResponseEntity.notFound()
                .build();
    }
}
