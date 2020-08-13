package com.dhanush.learning.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUsersRequest {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
