package com.example.demo.service;

import com.example.demo.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{





    List<Course> list;
    public CourseServiceImpl()
    {
        	list=new ArrayList<>();
		list.add(new Course(145,"Java core","this contains basic of Java"));
        list.add(new Course(149,"Java spring boot","this contains info abt spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        // TODO Auto-generated method stub
        return list;

    }

    @Override
    public Course getCourse(long courseId) {
        // TODO Auto-generated method stub
        Course c=null;
        for(Course course:list)
        {
        	if(course.getId()==courseId)
        	{
        	c=course;
        		break;
        	}
        	}

        	return c;

    }

    @Override
    public Course addCourse(Course course) {
		list.add(course);
		return course;
        // TODO Auto-generated method stub


    }

    @Override
    public Course updateCourse(Course course) {
        // TODO Auto-generated method stub
		list.forEach(e -> {

			if(e.getId()==course.getId())
			{
				e.setDescription(course.getDescription());
				e.setTitle(course.getTitle());
			}

		});
		return course;

    }

    @Override
    public Course deleteCourse(long courseId) {
        // TODO Auto-generated method stub
		Course c=null;
		int i=0;
		for(Course course:list)
		{

			if(course.getId()==courseId)
			{
				c=course;
				list.remove(i);
				break;
			}
			i++;

		}


		return c;


    }

}
