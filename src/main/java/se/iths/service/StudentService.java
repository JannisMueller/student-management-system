package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
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
        if(foundStudent == null){
            throw new EntityNotFoundException();
        } else{
            entityManager.remove(foundStudent);
        }

    }


}
