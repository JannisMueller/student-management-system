package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
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
    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
    private List <Student> students = new ArrayList<>();

    public Subject() {
    }

    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(List<Student> student) {
        this.students = student;
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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Subject )) return false;
        return subjectId != null && subjectId.equals(((Subject) obj).getSubjectId());
    }
}
