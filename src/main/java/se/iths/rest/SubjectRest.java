package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("")
    @GET
    public Response getAllSubjects(){
        List<Subject> subjectList = subjectService.getAllSubjects();

        return Response.ok(subjectList).build();
    }

    @Path("getByName/{name}")
    @GET
    public Response getSubjectById(@PathParam("name") String name){
        List <Subject> foundSubject = subjectService.getSubjectByName(name);
        return Response.ok(foundSubject).build();
    }

    @Path("ordered")
    @GET
    public Response getAllSubjectsOrderedByName(){
        List<Subject> subjectListOrderedByName = subjectService.getAllSubjectsSortedByName();
        return Response.ok(subjectListOrderedByName).build();
    }

    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id")Long id){
        Subject foundSubject = subjectService.findSubjectById(id);
        return Response.ok(foundSubject).build();
    }

    @Path("")
    @POST
    public Response createSubject(Subject subject){
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }
}
