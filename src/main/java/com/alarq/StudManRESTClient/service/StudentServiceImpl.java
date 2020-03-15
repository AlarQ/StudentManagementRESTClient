package com.alarq.StudManRESTClient.service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alarq.StudManRESTClient.entity.Student;

@Service
public class StudentServiceImpl implements StudentService  {

	@Autowired
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	public StudentServiceImpl(
		RestTemplate theRestTemplate,
		@Value("${crm.rest.url.student}") String theUrl) 
	{
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url.student="
		 + crmRestUrl);
	}
	
	@Override
	public List<Student> get() {

		ResponseEntity<List<Student>> responseEntity =
		restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
		 new ParameterizedTypeReference<List<Student>>() {});
		List<Student> students = responseEntity.getBody();
		logger.info("in getStudents(): students" + students);
		return students;
	}

	@Override
	public void save(Student student) {
		logger.info("in saveStudent(): Calling REST API "
				+ crmRestUrl);
				int studentId = student.getId();
				if (studentId == 0) {
				restTemplate.postForEntity(crmRestUrl, student,
				 String.class);
				} else {
				restTemplate.put(crmRestUrl, student);
				}
				logger.info("in saveStudent(): success");		
	}

	@Override
	public Student get(int id) {
		logger.info("in getStudent(): Calling REST API "
				 + crmRestUrl);
				Student student =
				restTemplate.getForObject(crmRestUrl + "/" + id,
				 Student.class);
				return student;	}

	@Override
	public void delete(int id) {
		logger.info("in deleteStudent(): Calling REST API "
				+ crmRestUrl);
				restTemplate.delete(crmRestUrl + "/" + id);
				logger.info("in deleteStudent(): deleted student theId=\"\r\n" + 
						+ id);
	}
}
