package com.stevezchao.carDistributionSystem.repo;

import com.stevezchao.carDistributionSystem.Entity.test.StudentPO;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentPO, Long> {

}
