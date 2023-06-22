package cp.student.restapicp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cp.student.restapicp.domain.Student;
import cp.student.restapicp.model.Studentvo;

@Service
public interface StudentService {

	void saveStudentData(Studentvo studentvo);
	
	List<Student> getAllStudentData();
	
	public Student updateStudentById(Studentvo studentvo);
	
	
}
