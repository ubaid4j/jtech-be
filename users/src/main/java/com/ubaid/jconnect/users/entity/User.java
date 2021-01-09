package com.ubaid.jconnect.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private String email;
    private String password;
    private String imageURL;
    private Boolean isActive;
    private Boolean isLoggedIn;
    private Timestamp lastSeen;
    private Timestamp dateCreated;
    @Transient
    private Integer port;

    public User(String firstName, String midName, String lastName, String email, String password, String imageURL,
                Boolean isActive, Boolean isLoggedIn, Timestamp lastSeen, Timestamp dateCreated) {
        super();
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.imageURL = imageURL;
        this.isActive = isActive;
        this.isLoggedIn = isLoggedIn;
        this.lastSeen = lastSeen;
        this.dateCreated = dateCreated;
    }

}
