package com.example.springdynamodbdocker.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@Data
@DynamoDBDocument
public class BookPublisher {
    private String name;
    private String address;
}
