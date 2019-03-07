package com.deadk.awsproject.dao;

import org.springframework.data.repository.CrudRepository;
import com.deadk.awsproject.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}