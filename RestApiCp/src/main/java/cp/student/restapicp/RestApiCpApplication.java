package cp.student.restapicp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableSwagger2
@ComponentScan
public class RestApiCpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCpApplication.class, args);
	}

}
