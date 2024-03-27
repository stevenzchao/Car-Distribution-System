package com.stevezchao.carDistributionSystem.repo;

import com.stevezchao.carDistributionSystem.Entity.test.CoursePO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CoursePO, Long> {
}