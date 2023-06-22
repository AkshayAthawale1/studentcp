package cp.student.restapicp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentId")
	private long id;
	
	@Column(name="studentName")
	private String name;
	
	@Column(name="studentEmail")
	private String email;

	@Column(name="studentNumber")	
	private String number;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, String email, String number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}
	
	
	
}
