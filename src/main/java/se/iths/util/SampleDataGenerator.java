package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData(){
        Teacher teacher1 = new Teacher("Pontus",
                "Redig",
                "pontus@iths.se",
                "01234567");

        Teacher teacher2 = new Teacher("David",
                "Andersson",
                "david@iths.se",
                "0133334347");

        Student student1 = new Student("Gustav",
                "Berggren",
                "gusti@hotmail.com",
                "0123864");

        Student student2 = new Student("Valter",
                "Berggren",
                "valter@hotmail.com",
                "098761256");

        Subject subject1 = new Subject("Java 1");
        Subject subject2 = new Subject("Database 2");
        Subject subject3 = new Subject("Frontend");
        Subject subject4 = new Subject("Backend");
        Subject subject5 = new Subject("App Development");
        Subject subject6 = new Subject("Computer Science");

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher1.addSubject(subject3);

        teacher2.addSubject(subject4);
        teacher2.addSubject(subject5);
        teacher2.addSubject(subject6);

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);
        student1.addSubject(subject5);

        student2.addSubject(subject2);
        student2.addSubject(subject4);
        student2.addSubject(subject6);
        student2.addSubject(subject1);
        student2.addSubject(subject5);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

        entityManager.persist(student1);
        entityManager.persist(student2);

    }


}
