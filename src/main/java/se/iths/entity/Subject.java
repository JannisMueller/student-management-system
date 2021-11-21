package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NamedQuery(name="subjectEntity.findByName", query= "SELECT i FROM Subject i WHERE i.nameOfSubject = :name")
@NamedQuery(name = "subjectEntity.findAll", query = "SELECT i from Subject i")
@NamedQuery(name = "subjectEntity.findAllOrderedByName", query = "SELECT i FROM Subject i ORDER BY i.nameOfSubject")
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId;
    @NotEmpty
    private String nameOfSubject;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    //To-do bis jetzt wird immer nur ein Student geholt, will aber eine Liste mit Studenten

    public Subject() {
    }


    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    //@JsonbTransient
    public Student getStudent() {
        return student;
    }
    //@JsonbTransient
    public void setStudent(Student student) {
        this.student = student;
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }
}
