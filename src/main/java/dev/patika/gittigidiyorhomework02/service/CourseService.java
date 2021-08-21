package dev.patika.gittigidiyorhomework02.service;

import dev.patika.gittigidiyorhomework02.dao.CourseDAO;
import dev.patika.gittigidiyorhomework02.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements BaseService<Course>{

    private CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return (Course) courseDAO.update(course);
    }
}
