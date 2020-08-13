package com.dhanush.learning.response;

import com.dhanush.learning.entity.Users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UsersResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	public UsersResponse(Users user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();

	}
}
