package cp.student.restapicp.exceptions;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFountException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFound(StudentNotFountException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", ZonedDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", "/api/v1/student/delete/{id}");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<String> StudentNotFoundException(StudentNotFountException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.OK);
	}
}

