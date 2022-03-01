package com.teresol.dataaccess.ms.dataaccess_ms_crud.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teresol.dataaccess.ms.dataaccess_ms_crud.dto.StudentDto;
import com.teresol.dataaccess.ms.dataaccess_ms_crud.services.StudentService;

import org.jboss.logging.Logger;

@Path("/student")
public class StudentResource {
    @Inject
    Logger logger;

    @Inject
    StudentService studentService;

    @Path("/createStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentDto studentDto) {
        logger.info("Hittin  the end point from dataaccess service./student/createStudentWS");
        StudentDto std = studentService.createStudent(studentDto);
        logger.info("Returning : "+std);
        return Response.ok(std).build();
    }

    @Path("/updateStudent")
    @PUT
    public Response updateStudent(StudentDto studentDto) {
        StudentDto std = studentService.updateStudent(studentDto);
        return Response.ok(std).build();
    }

    @Path("/getAllStudent")
    @GET
    public Response getAllStudent() {
        return Response.ok(studentService.getAllStudents()).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") int id) {
        return Response.ok(studentService.getStudentById(id)).build();
    }

    @Path("/deleteStudent")
    @DELETE
    public Response deleteStudent(StudentDto studentDto){
        return Response.ok(studentService.deleteStudent(studentDto)).build();
    }

}
