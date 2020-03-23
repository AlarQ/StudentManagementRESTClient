package com.alarq.StudManRESTClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alarq.StudManRESTClient.entity.Course;
import com.alarq.StudManRESTClient.entity.Student;
import com.alarq.StudManRESTClient.exceptions.StudentNotFoundException;
import com.alarq.StudManRESTClient.service.CourseService;
import com.alarq.StudManRESTClient.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showStudentslist(Model model)
	{
		System.out.println("in student controller");
		List<Student> students = studentService.get();
		model.addAttribute("students",students);
		System.out.println(students.get(0).getStudentDetails());
		return "students-list";
	}
	
	@GetMapping("/showAddForm")
	public String showFormAdd(Model model)
	{
		Student student = new Student();
		model.addAttribute("student",student);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.save(student);
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id,Model model)
	{
		Student student = studentService.get(id);
		model.addAttribute("student",student);
		
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id)
	{
		studentService.delete(id);
		return "redirect:/student/list";
	}
	
	@GetMapping("/showDetails")
	public String showDetails(Model model, @RequestParam("id") int id)
	{
		Student student = studentService.get(id);
		if(student == null)
			throw new StudentNotFoundException("SSS");
				//	+ id + " not found");
		
		model.addAttribute("student",student);
		
		List<Course> allCourses = courseService.getCourses();
		model.addAttribute("allCourses",allCourses);
		
		List<Course> courses = student.getCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("course", new Course());
		return "student-details";
	}
	
	@PostMapping("/addCourseToStudent")
	public String addCourseToStudent(@RequestParam("studentId") int studentId,@ModelAttribute("course") Course course)
	{
		System.out.println(course.getId());
		Course course1 = courseService.getCourse(course.getId());
		Student student = studentService.get(studentId);
		System.out.println(student);
		System.out.println(course1);
		student.addCourse(course1);
		courseService.saveCourse(course1);
	
		studentService.save(student);
		return "redirect:/student/list";
	}
}
