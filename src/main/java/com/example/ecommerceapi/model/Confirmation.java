package com.example.ecommerceapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "confirmation_db")
public class Confirmation {
    @Id
    private String id;

    private String email;
    private String phoneno;
    @Indexed(name = "CreatedDateIndx", expireAfter = "10m")
    private Date createdAt = Date.from(Instant.now());

}
