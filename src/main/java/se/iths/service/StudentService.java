package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createNewStudent(Student student){
        entityManager.persist(student);
    }

    public void updateStudent (Student student){
        entityManager.merge(student);
    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentsByLastname(String lastname){
        List<Student> foundStudents = entityManager.createQuery("SELECT x from Student x WHERE x.lastName = lastname",Student.class).getResultList();
        return foundStudents;

    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT x from Student x",Student.class).getResultList();
    }

    public void deleteStudent(Long id){
        Student foundStudent = findStudentById(id);
        entityManager.remove(foundStudent);
    }


}
