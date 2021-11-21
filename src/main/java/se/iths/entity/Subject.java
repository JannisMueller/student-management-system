package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @ManyToOne
    private Student student;


    public Subject() {
    }

    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    @JsonbTransient
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonbTransient
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
