package com.stevezchao.carDistributionSystem.repo;

import com.stevezchao.carDistributionSystem.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}