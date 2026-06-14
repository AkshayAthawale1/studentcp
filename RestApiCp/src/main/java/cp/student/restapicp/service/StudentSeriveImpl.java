package cp.student.restapicp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import cp.student.restapicp.domain.Student;
import cp.student.restapicp.exceptions.GlobalExceptionHandler;
import cp.student.restapicp.exceptions.StudentNotFountException;
import cp.student.restapicp.model.Studentvo;
import cp.student.restapicp.repository.StudentRepoitory;

@Service
public class StudentSeriveImpl implements StudentService {

	@Autowired
	private StudentRepoitory studentRepoitory;

	@Override
	public void saveStudentData(Studentvo studentvo) {
		Student student = new Student();
		BeanUtils.copyProperties(studentvo, student);
		studentRepoitory.saveAndFlush(student);
	}

	@Override
	public List<Student> getAllStudentData() {
		return studentRepoitory.findAll();
	}

	@Override
	public Student updateStudentById(Studentvo studentvo) {

		Student ss = studentRepoitory.findById(studentvo.getId()).orElse(null);
		ss.setEmail(studentvo.getEmail());
		ss.setName(studentvo.getName());
		ss.setNumber(studentvo.getNumber());
		return studentRepoitory.save(ss);

	}

	public String deleteStudentbyid(long id) {
		Student stId = studentRepoitory.findById(id)
				.orElseThrow(() -> new StudentNotFountException("Student with ID " + id + " not found"));
		studentRepoitory.delete(stId);
		return "Student with ID " + id + " has been removed successfully.";
	}

	@Override
	public void saveAllStudent(List<Studentvo> listOfStudent) {
		ArrayList<Student> allStudent = new ArrayList<>();
		for (Studentvo studentVo : listOfStudent) {
			Student student = new Student();
			BeanUtils.copyProperties(studentVo, student); // Copy individual object
			allStudent.add(student);
		}
		studentRepoitory.saveAllAndFlush(allStudent);

	}

	@Override
	public void saveOrUpdateStudent(Studentvo studentvo) {
	    Student student;

	    if (studentvo.getId() != null) {
	        Optional<Student> existing = studentRepoitory.findById(studentvo.getId());
	        System.out.print("dfdfd"+existing);
	       student = existing.orElseGet(Student::new);
	    } else {
	        student = new Student();
	    }

	    BeanUtils.copyProperties(studentvo, student);
	    studentRepoitory.save(student);
	}

	



	@Override
	public void saveCsvData() {

		String lineNo = "";
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("myCsvFile.csv");

			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			while ((lineNo = br.readLine()) != null) {
				String[] data = lineNo.split(",");
				Student student = new Student();
				student.setName(data[0]);
				student.setEmail(data[1]);
				student.setNumber(data[2]);
				studentRepoitory.save(student);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
