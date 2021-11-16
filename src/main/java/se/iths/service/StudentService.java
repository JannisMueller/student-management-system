package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
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

    public List<Student> findStudentsByLastname(String lastname){
        List<Student> foundStudents = entityManager.createQuery("SELECT x from Student x WHERE x.lastName = lastname",Student.class).getResultList();
        return foundStudents;

    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT x from Student x",Student.class).getResultList();
    }

    public void deleteStudent(Long id){
        Student foundStudent = findStudentById(id);
        if(foundStudent == null){
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Item with ID " + id + " was not found in database.").build());
        } else{
            entityManager.remove(foundStudent);
        }

    }


}
