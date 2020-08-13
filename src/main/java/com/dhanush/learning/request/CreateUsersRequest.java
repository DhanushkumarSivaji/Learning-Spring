package com.dhanush.learning.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsersRequest {
	private String firstName;
	private String lastName;
	private String email;
}
