package com.dhanush.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.learning.entity.Users;
import com.dhanush.learning.repository.UsersRepository;
import com.dhanush.learning.request.CreateUsersRequest;
import com.dhanush.learning.request.UpdateUsersRequest;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	public Users createUsers(CreateUsersRequest createUsersRequest) {
		Users user = new Users(createUsersRequest);

		user = usersRepository.save(user);

		return user;
	}

	public Users updateStudent(UpdateUsersRequest updateUsersRequest) {
		Users user = usersRepository.findById(updateUsersRequest.getId()).get();

		if (updateUsersRequest.getFirstName() != null && !updateUsersRequest.getFirstName().isEmpty()) {
			user.setFirstName(updateUsersRequest.getFirstName());
		}

		if (updateUsersRequest.getLastName() != null && !updateUsersRequest.getLastName().isEmpty()) {
			user.setLastName(updateUsersRequest.getLastName());
		}

		if (updateUsersRequest.getEmail() != null && !updateUsersRequest.getEmail().isEmpty()) {
			user.setEmail(updateUsersRequest.getEmail());
		}

		user = usersRepository.save(user);

		return user;

	}

	public String deleteUser(long id) {
		usersRepository.deleteById(id);
		return "User has been deleted successfully";
	}

}
