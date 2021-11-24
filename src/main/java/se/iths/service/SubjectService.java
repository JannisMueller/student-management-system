package se.iths.service;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject findSubjectById (Long id){
        return entityManager.find(Subject.class, id);
    }

    public Subject createSubject (Subject subject){
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects(){
        return entityManager.createNamedQuery("subjectEntity.findAll",Subject.class)
                .getResultList();
    }

    public List<Subject> getAllSubjectsSortedByName(){
        return entityManager.createNamedQuery("subjectEntity.findAllOrderedByName",Subject.class)
                .getResultList();
    }

    public List<Subject> getSubjectByName(String name){
        return entityManager.createQuery("SELECT i FROM Subject i WHERE i.nameOfSubject = :name",Subject.class).setParameter("name", name)
                .getResultList();
    }


}
