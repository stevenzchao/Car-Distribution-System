package com.stevezchao.carDistributionSystem.repo;

import com.stevezchao.carDistributionSystem.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}