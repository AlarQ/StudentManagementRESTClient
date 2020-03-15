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
import com.alarq.StudManRESTClient.service.CourseService;
import com.alarq.StudManRESTClient.service.StudentService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showStudentslist(Model model)
	{
		System.out.println("in course controller");
		List<Course> courses = courseService.getCourses();
		for(Course c : courses)
			System.out.println(c);
		model.addAttribute("courses",courses);
		
		return "course-list";
	}
	
	@GetMapping("/showAddForm")
	public String showFormAdd(Model model)
	{
		Course course = new Course();
		model.addAttribute("course",course);
		return "course-form";
	}

	@PostMapping("/saveCourse")
	public String saveStudent(@ModelAttribute("course") Course course)
	{
		courseService.saveCourse(course);
		return "redirect:/course/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id,Model model)
	{
		Course course = courseService.getCourse(id);
		model.addAttribute("course",course);
		
		return "course-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id)
	{
		courseService.deleteCourse(id);
		return "redirect:/course/list";
	}
}
