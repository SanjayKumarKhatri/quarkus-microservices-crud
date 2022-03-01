package com.teresol.dataaccess.ms.dataaccess_ms_crud.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.teresol.dataaccess.ms.dataaccess_ms_crud.connection.GlobalDBConnection;
import com.teresol.dataaccess.ms.dataaccess_ms_crud.dto.StudentDto;
import com.teresol.dataaccess.ms.dataaccess_ms_crud.querystores.UserTlQuery;

@RequestScoped
public class StudentService {

    @Inject
    GlobalDBConnection dbConnection;

    @Inject
    StudentDto studentDto;

    @Inject
    UserTlQuery userTlQuery;

    
    public StudentDto createStudent(StudentDto studentDto) {

    
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(userTlQuery.createUser(studentDto));

            if (i > 0) {
                return studentDto;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
        /*
         * connection = dbConnection.getConnection();
         * PreparedStatement preparedStatement =
         * connection.prepareStatement(userTlQuery.createUser(studentDto));
         * int result = preparedStatement.executeUpdate();
         * return result;
         */
    }

    public StudentDto updateStudent(StudentDto studentDto){
        
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(userTlQuery.updateUser(studentDto));

            if(i > 0){
                return studentDto;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return null;
    }

    public List<StudentDto> getAllStudents(){

      List<StudentDto> studentList =  new ArrayList<>();

        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(userTlQuery.getAllUsers());
            StudentDto studentDto = null;

            while(resultSet.next()){
                studentDto = new StudentDto();
                studentDto.setId(resultSet.getInt("id"));
                studentDto.setUserName(resultSet.getString("userName"));
                studentDto.setPhoneNo(resultSet.getString("phoneNo"));
                studentList.add(studentDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return studentList;
    }

    public StudentDto getStudentById(int id){

        StudentDto studentDto = null;

        try {

            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(userTlQuery.getUserById(id));

        while(resultSet.next()){
            studentDto = new StudentDto();
            studentDto.setId(resultSet.getInt("id"));
            studentDto.setUserName(resultSet.getString("userName"));
            studentDto.setPhoneNo(resultSet.getString("phoneNo"));
        }  
            
        } catch (Exception e) {
           e.printStackTrace();
        }

        return studentDto;

    }

    public StudentDto deleteStudent(StudentDto studentDto){
        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            int result  = statement.executeUpdate(userTlQuery.deleteUser(studentDto));

            if(result > 0){
                return studentDto;

            }
            
        } catch (Exception e) {
          e.printStackTrace();
        }

        return null;

    }

}
