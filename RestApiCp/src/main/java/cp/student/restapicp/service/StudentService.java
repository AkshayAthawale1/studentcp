package cp.student.restapicp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cp.student.restapicp.domain.Student;
import cp.student.restapicp.model.Studentvo;

@Service
public interface StudentService {

	void saveStudentData(Studentvo studentvo);

	void saveAllStudent(List<Studentvo> listOfStudent);

	List<Student> getAllStudentData();

	Student updateStudentById(Studentvo studentvo);
	
	void saveOrUpdateStudent(Studentvo studentvo);

	void saveCsvData();
}
