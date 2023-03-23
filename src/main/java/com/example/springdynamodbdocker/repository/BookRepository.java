package com.example.springdynamodbdocker.repository;

import com.example.springdynamodbdocker.model.Book;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
