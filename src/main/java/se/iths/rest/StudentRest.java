package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("student")
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createNewStudent(Student student) throws SQLException {
        studentService.createNewStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @PUT
    public Response updateStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.")
                    .build());

        } else {
            studentService.updateStudent(foundStudent);
            return Response.ok(foundStudent).build();
        }
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id ) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.").build());
        } else {
            return Response.ok(foundStudent).build();
        }
    }

    @Path("{lastname}")
    @GET
    public Response getStudent(@QueryParam("lastname") String lastname) {
        List<Student> foundStudents = studentService.findStudentsByLastname(lastname);

        if (foundStudents.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Item with ID " + lastname + " was not found in database.").build());
        } else {
            return Response.ok(foundStudents).build();
        }
    }

    @Path("")
    @GET
    public Response getAllStudents(){
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        studentService.deleteStudent(id);
        return Response.accepted().build();
    }


}
