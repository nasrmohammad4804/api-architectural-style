package com.nasr.grpcserver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import static com.nasr.grpcserver.domain.User.*;

@Entity
@Table(name = TABLE_NAME)
@Data
public class User {

    public static final String TABLE_NAME = "user_table";
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String nationalCode;

}
