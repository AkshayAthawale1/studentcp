package cp.student.restapicp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cp.student.restapicp.customeProperties.CustomeProperties;
import cp.student.restapicp.domain.Student;
import cp.student.restapicp.model.Studentvo;
import cp.student.restapicp.service.StudentSeriveImpl;

@RestController
@RequestMapping("api/v1/")
public class StudentController {

	@Autowired
	private StudentSeriveImpl studentSerive;
	
	@Autowired
	private CustomeProperties customeProperties;

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@PostMapping("/student/save")
	public ResponseEntity<String> saveStudentData(@RequestBody Studentvo studentvo) {
		studentSerive.saveStudentData(studentvo);
		return new ResponseEntity<String>("Record Inserted", HttpStatus.OK);
	}

	@PostMapping("/student/saveAll")
	public ResponseEntity<String> saveStudentData(@RequestBody List<Studentvo> listStudent) {
		studentSerive.saveAllStudent(listStudent);
		return new ResponseEntity<String>("Inserted List Of Student", HttpStatus.OK);
	}

	@GetMapping("/student/getallstudents")
	public List<Student> GetAllStudents() {
//		System.out.println("the app name is" + appName);
		System.out.println("custome properties fb "+customeProperties.getFeedback());
		System.out.println("custome properties msg "+customeProperties.getMessage());

		return studentSerive.getAllStudentData();
	}

	@PutMapping("student/update")
	public ResponseEntity<Student> updateEmplyee(@RequestBody Studentvo studentvo) {
		studentSerive.updateStudentById(studentvo);
		return new ResponseEntity<Student>(HttpStatus.OK);

	}

	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		studentSerive.deleteStudentbyid(id);
		return new ResponseEntity<String>("Record of id : " + id + " deleted successfully", HttpStatus.OK);

	}

	@PostMapping("/saveOrUpdate")
	public ResponseEntity<String> saveOrUpdateUser(@RequestBody Studentvo student) {
		studentSerive.saveOrUpdateStudent(student);
		return new ResponseEntity<>("Record Inserted", HttpStatus.CREATED);
	}

	@PostMapping("/saveFromCsv")
	public ResponseEntity<String> saveCsvData() {
		studentSerive.saveCsvData();
		return new ResponseEntity<>("Record Inserted", HttpStatus.CREATED);
	}
}
