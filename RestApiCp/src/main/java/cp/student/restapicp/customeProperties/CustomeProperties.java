package cp.student.restapicp.customeProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:new.properties")
public class CustomeProperties {

	@Value("${custom.message}")
	private String message;

	public String getMessage() {
		return message;
	}

	@Value("${custom.feedback}")
	private String feedback;

	public String getFeedback() {
		return feedback;
	}
}
