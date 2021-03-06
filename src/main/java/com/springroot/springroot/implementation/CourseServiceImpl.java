package com.springroot.springroot.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springroot.springroot.entities.Course;
import com.springroot.springroot.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(11, "Spring Boot", "Requisites of Spring Boot"));
		list.add(new Course(12, "Spring Boot API Creation", "Requisites of Spring Boot and creating API"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public Course deleteCourse(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
			return null;
	}

}
