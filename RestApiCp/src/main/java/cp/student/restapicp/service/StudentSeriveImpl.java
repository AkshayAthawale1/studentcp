package cp.student.restapicp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cp.student.restapicp.domain.Student;
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
		studentRepoitory.deleteById(id);
		return "id removed " + id;
	}

}
