package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Response createNewStudent(Student student){
        entityManager.persist(student);

        return Response.ok(student).build();
    }


}
