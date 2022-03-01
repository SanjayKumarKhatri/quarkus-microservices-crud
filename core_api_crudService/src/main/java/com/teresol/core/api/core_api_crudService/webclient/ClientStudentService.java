package com.teresol.core.api.core_api_crudService.webclient;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.teresol.core.api.core_api_crudService.dto.StudentDto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/student")
@RegisterRestClient(configKey = "dataaccess_ms_crud")
public interface ClientStudentService {
    
    @Path("/createStudent")
    @POST
    public StudentDto createStudent(StudentDto studentDto);

    @Path("/updateStudent")
    @PUT
    public StudentDto updateStudent(StudentDto studentDto);

    @Path("/getAllStudent")
    @GET
    public List<StudentDto> getAllStudents();

    @Path("{id}")
    @GET
    public StudentDto getStudentById(@PathParam("id")int id);

    @Path("/deleteStudent")
    @DELETE
    public StudentDto deleteStudent(StudentDto studentDto);
    
    
}
