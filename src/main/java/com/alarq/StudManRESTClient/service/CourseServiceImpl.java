package com.alarq.StudManRESTClient.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alarq.StudManRESTClient.entity.Course;
import com.alarq.StudManRESTClient.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class CourseServiceImpl implements CourseService{

		@Autowired
		private RestTemplate restTemplate;
		private String crmRestUrl;
		private Logger logger = Logger.getLogger(getClass().getName());

		public CourseServiceImpl(
			RestTemplate theRestTemplate,
			@Value("${crm.rest.url.course}") String theUrl) 
		{
			restTemplate = theRestTemplate;
			crmRestUrl = theUrl;
			logger.info("Loaded property: crm.rest.url="
			 + crmRestUrl);
		}
		
		@Override
		public List<Course> getCourses() {
			System.out.println("in getCourses(): Calling REST API "
					+ crmRestUrl);

			ObjectMapper objectMapper = new ObjectMapper();
			logger.info("in getCourses(): courses");
			ResponseEntity<List<Course>> responseEntity =
			restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
			 new ParameterizedTypeReference<List<Course>>() {});
			List<Course> courses = responseEntity.getBody();
			logger.info("in getCourses(): courses" + courses);
			System.out.println("****************");
			courses.forEach(c -> System.out.println(c));
			return courses;
		}

		@Override
		public void saveCourse(Course student) {
			logger.info("in saveCourse(): Calling REST API "
					+ crmRestUrl);
					int studentId = student.getId();
					if (studentId == 0) {
					restTemplate.postForEntity(crmRestUrl, student,
					 String.class);
					} else {
					restTemplate.put(crmRestUrl, student);
					}
					logger.info("in saveCourse(): success");		
		}

		@Override
		public Course getCourse(int id) {
			logger.info("in getCourse(): Calling REST API "
					 + crmRestUrl);
					// make REST call
					Course course =
					restTemplate.getForObject(crmRestUrl + "/" + id,
					 Course.class);
					return course;	}

		@Override
		public void deleteCourse(int id) {
			logger.info("in deleteCourse(): Calling REST API "
					+ crmRestUrl);
					// make REST call
					restTemplate.delete(crmRestUrl + "/" + id);
					logger.info("in deleteCourse(): deleted course theId=\"\r\n" + 
							+ id);
		}
}