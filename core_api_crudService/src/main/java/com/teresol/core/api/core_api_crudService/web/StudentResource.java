package com.teresol.core.api.core_api_crudService.web;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.teresol.core.api.core_api_crudService.dto.StudentDto;
import com.teresol.core.api.core_api_crudService.services.StudentService;

@Path("/student")
public class StudentResource {

    @Inject
    StudentService studentService;

    @Path("/createStudent")
    @POST
    public Response createStudent(StudentDto studentDto) {
        return Response.ok(studentService.createStudent(studentDto)).build();

    }

    @Path("/updateStudent")
    @PUT
    public Response updateStudent(StudentDto studentDto){
        return Response.ok(studentService.updateStudent(studentDto)).build();

    }

    @Path("/getAllStudent")
    @GET
    public Response getAllStudent(){
        return Response.ok(studentService.getAllStudents()).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") int id){
        return Response.ok(studentService.getStudentById(id)).build();
    }

    @Path("/deleteStudent")
    @DELETE
    public Response deleteStudent(StudentDto studentDto){
        return Response.ok(studentService.deleteStudent(studentDto)).build();
    }

}
