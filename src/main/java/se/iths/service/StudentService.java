package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exceptionHandling.ApiNotFoundExceptions;

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

    public void updateStudent (Student student, Long id) {
        Student foundStudent = findStudentById(id);
        if (foundStudent != null) {
            entityManager.merge(student);
        } else {
            throw new ApiNotFoundExceptions("Student with ID " + id + " not in Database");
        }
    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentsByLastname(String lastName){
        return entityManager.createQuery(
                "SELECT x from Student x WHERE x.lastName LIKE :lastName",Student.class)
                .setParameter("lastName",lastName)
                .getResultList();

    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT i from Student i",Student.class).getResultList();
    }

    public void deleteStudent(Long id){
        Student foundStudent = findStudentById(id);
        if (foundStudent == null) {
            throw new ApiNotFoundExceptions("Student with ID " + id + " not in Database");
        } else {
            entityManager.remove(foundStudent);
        }

    }


}
