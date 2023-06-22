package cp.student.restapicp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import cp.student.restapicp.domain.Student;
import cp.student.restapicp.model.Studentvo;
import cp.student.restapicp.service.StudentSeriveImpl;

@RestController
@RequestMapping("api/v1/")
public class StudentController {

	@Autowired
	private StudentSeriveImpl studentSeriveImpl;
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	
	@GetMapping("hi")
	public String gt() {
		logger.info("[get message] info message");
		logger.debug("[get message] debug message");
		logger.warn("[get message] warn message");
		logger.error("[get message] error messag");
		System.out.println(10/0);
		return "hello";
	}

	@PostMapping("/student/save")
	public ResponseEntity<String> saveStudentData(@RequestBody Studentvo studentvo) {
		studentSeriveImpl.saveStudentData(studentvo);
		return new ResponseEntity<String>("Record Inserted", HttpStatus.OK);
	}

	@GetMapping("/student/getallstudents")
	public List<Student> GetAllStudents() {
		return studentSeriveImpl.getAllStudentData();
	}
 
	@PutMapping("student/update")
	public ResponseEntity<Student> updateEmplyee(@RequestBody Studentvo studentvo) {
		studentSeriveImpl.updateStudentById(studentvo);
		return new ResponseEntity<Student>(HttpStatus.OK); 

	}

	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		studentSeriveImpl.deleteStudentbyid(id);
		return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);

	}

}
