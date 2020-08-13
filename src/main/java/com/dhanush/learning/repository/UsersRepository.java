package com.dhanush.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhanush.learning.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findByFirstName(String firstName);

	Users findByFirstNameAndLastName(String firstName, String lastName);

	List<Users> findByFirstNameOrLastName(String firstName, String lastName);

	List<Users> findByFirstNameIn(List<String> firstNames);
}
