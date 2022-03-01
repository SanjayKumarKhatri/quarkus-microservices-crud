package com.teresol.core.api.core_api_crudService.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.teresol.core.api.core_api_crudService.dto.StudentDto;
import com.teresol.core.api.core_api_crudService.webclient.ClientStudentService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@RequestScoped
public class StudentService {
    @Inject
    @RestClient
    ClientStudentService clientStudentService;

    public StudentDto  createStudent(StudentDto studentDto) {
        return clientStudentService.createStudent(studentDto);

    }

    public StudentDto updateStudent(StudentDto studentDto){
        return clientStudentService.updateStudent(studentDto);
    }

    public List<StudentDto> getAllStudents(){
        return clientStudentService.getAllStudents();
    }

    public StudentDto getStudentById(int id){
        return clientStudentService.getStudentById(id);

    }

    public StudentDto deleteStudent(StudentDto studentDto){
        return clientStudentService.deleteStudent(studentDto);
    }

}
