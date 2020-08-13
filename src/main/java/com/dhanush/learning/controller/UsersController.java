package com.dhanush.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.learning.entity.Users;
import com.dhanush.learning.request.CreateUsersRequest;
import com.dhanush.learning.request.InQueryRequest;
import com.dhanush.learning.request.UpdateUsersRequest;
import com.dhanush.learning.response.UsersResponse;
import com.dhanush.learning.service.UsersService;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping("getAll")
	public List<UsersResponse> getAllUsers() {

		List<Users> usersList = usersService.getAllUsers();
		List<UsersResponse> usersResponseList = new ArrayList<UsersResponse>();

		usersList.stream().forEach(user -> {
			usersResponseList.add(new UsersResponse(user));
		});

		return usersResponseList;
	}

	@PostMapping("create")
	public UsersResponse createStudent(@Validated @RequestBody CreateUsersRequest createUsersRequest) {
		Users user = usersService.createUsers(createUsersRequest);
		return new UsersResponse(user);
	}

	@PutMapping("update")
	public UsersResponse updateUsers(@Validated @RequestBody UpdateUsersRequest updateUsersRequest) {
		Users user = usersService.updateStudent(updateUsersRequest);

		return new UsersResponse(user);
	}

	@DeleteMapping("delete")
	public String deleteUser(@RequestParam("id") long id) {
		return usersService.deleteUser(id);
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<UsersResponse> getByFirstName(@PathVariable String firstName) {
		List<Users> studentList = usersService.getByFirstName(firstName);

		List<UsersResponse> studentResponseList = new ArrayList<UsersResponse>();

		studentList.stream().forEach(user -> {
			studentResponseList.add(new UsersResponse(user));
		});

		return studentResponseList;

	}

	@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public UsersResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return new UsersResponse(usersService.getByFirstNameAndLastName(firstName, lastName));
	}

	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<UsersResponse> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
		List<Users> studentList = usersService.getByFirstNameOrLastName(firstName, lastName);

		List<UsersResponse> studentResponseList = new ArrayList<UsersResponse>();

		studentList.stream().forEach(user -> {
			studentResponseList.add(new UsersResponse(user));
		});

		return studentResponseList;
	}

	@GetMapping("getByFirstNameIn")
	public List<UsersResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {

		List<Users> studentList = usersService.getByFirstNameIn(inQueryRequest);

		List<UsersResponse> studentResponseList = new ArrayList<UsersResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new UsersResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("getAllWithPagination")
	public List<UsersResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<Users> userList = usersService.getAllUsersWithPagination(pageNo, pageSize);

		List<UsersResponse> userResponseList = new ArrayList<UsersResponse>();

		userList.stream().forEach(user -> {
			userResponseList.add(new UsersResponse(user));
		});

		return userResponseList;
	}

}
