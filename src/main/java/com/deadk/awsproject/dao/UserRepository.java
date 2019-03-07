package com.deadk.awsproject.dao;

import org.springframework.data.repository.CrudRepository;

import com.deadk.awsproject.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}