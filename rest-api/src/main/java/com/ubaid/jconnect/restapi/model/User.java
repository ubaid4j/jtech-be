package com.ubaid.jconnect.restapi.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Long id;
	private String firstName;
	private String midName;
	private String lastName;
	private String imageURL;
	private Integer port;
	private Boolean isActive;
	private Timestamp lastSeen;

	@JsonIgnore
	private String email;
	@JsonIgnore
	private String password;
}
