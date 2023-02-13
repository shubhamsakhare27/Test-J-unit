package com.TestExample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.TestExample.controller.StringController;
import com.TestExample.model.Student;
import com.TestExample.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestExampleApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StringController studentController;

	@Test
	public void testEndpointMethod() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8087/endpoint", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("shubham", response.getBody());
	}

	@Test
	public void testGetData() {

		ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8087/endpoint2", Student.class);
		Student student = new Student();
		student.setId(1);
		student.setName("shubham");
		student.setDomain("IT");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1, response.getBody().getId());
		assertEquals("shubham", response.getBody().getName());
		assertEquals("IT", response.getBody().getDomain());
	}

	@Test
	public void testAll() {
		List<Student> stuList = Arrays.asList(new Student(1, "A", "IT"), new Student(2, "B", "ETC"),
				new Student(3, "C", "ME")

		);

		when(studentRepository.findAll()).thenReturn(stuList);
		ResponseEntity<List<Student>> entity = studentController.endpointMethod3();
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(stuList, entity.getBody());
		assertNotNull(entity.getBody());

	}

}



