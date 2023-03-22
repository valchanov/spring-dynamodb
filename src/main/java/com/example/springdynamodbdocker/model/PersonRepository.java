package com.example.springdynamodbdocker.model;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PersonRepository extends CrudRepository<Person, PrimaryKey> {
}
