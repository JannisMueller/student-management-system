package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exceptionHandling.ApiInternalServerErrorException;
import se.iths.exceptionHandling.ApiNotFoundExceptions;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createNewStudent(Student student) {
        try {
            studentService.createNewStudent(student);
            return Response.ok(student).build();
        } catch (Exception e) {
            throw new ApiInternalServerErrorException("Oops...Something went wrong");
        }
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) {
        if (student == null) {
            throw new ApiNotFoundExceptions("Student not found!");
        } else {
            studentService.updateStudent(student);
            return Response.ok(student).build();
        }
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id ) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new ApiNotFoundExceptions("Student with ID " + id + " not in Database");
        } else {
            return Response.ok(foundStudent).build();
        }
    }

    @Path("lastname")
    @GET
    public Response getStudent(@QueryParam("lastName") String lastName) {
        List<Student> foundStudents = studentService.findStudentsByLastname(lastName);
        if (foundStudents.isEmpty()) {
            throw new ApiNotFoundExceptions("No students with last name" + lastName + " were not found in database.");
        } else {
            return Response.ok(foundStudents).build();
        }
    }

    @Path("")
    @GET
    public Response getAllStudents(){
        List<Student> foundStudents = studentService.getAllStudents();
        if(foundStudents.isEmpty()){
            throw new ApiNotFoundExceptions("No students are found in Database");
        } else {
        return Response.ok(foundStudents).build();
    }
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
            studentService.deleteStudent(id);
            return Response.accepted().build();
        }
    }

