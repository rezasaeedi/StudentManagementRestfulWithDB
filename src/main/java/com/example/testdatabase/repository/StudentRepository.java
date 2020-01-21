package com.example.testdatabase.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.testdatabase.model.Student;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query(value = "select e " +
            "from Student e " +
            "where e.stuID = :stuID")
    Optional<Student> findByStuID(@Param("stuID") String stuID);

    @Transactional
    void deleteByStuID(String stuID);
}
