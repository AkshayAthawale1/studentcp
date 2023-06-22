package cp.student.restapicp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cp.student.restapicp.domain.Student;

@Repository
public interface StudentRepoitory extends JpaRepository<Student, Long>{

}
