package dev.patika.gittigidiyorhomework02.dao;

import dev.patika.gittigidiyorhomework02.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student>{

    private EntityManager entityManager;

    //TODO op
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student s",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = this.findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
