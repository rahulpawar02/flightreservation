package com.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);  //here automatically query fire we need not write query
                                     //select email from user;  
}
