package com.teresol.dataaccess.ms.dataaccess_ms_crud.querystores;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.teresol.dataaccess.ms.dataaccess_ms_crud.dto.StudentDto;

import org.jboss.logging.Logger;

@RequestScoped
public class UserTlQuery {
    @Inject
    Logger logger;

    public String createUser(StudentDto studentDto) {  
        logger.info(String.format("insert into user(userName,phoneNo) values('%s','%s')",studentDto.getUserName(),studentDto.getPhoneNo()));
        return String.format("insert into user(userName,phoneNo) values('%s','%s')",studentDto.getUserName(),studentDto.getPhoneNo());
        // String query = "insert into user(userName,phoneNo) values(" + studentDto.getUserName() + ","
        //         + studentDto.getPhoneNo() + ")";
  
        // return query;
    }

    public String updateUser(StudentDto studentDto){
       logger.info(String.format("Update user set userName='%s',phoneNo='%s' where id=%d",studentDto.getUserName(),studentDto.getPhoneNo(),studentDto.getId()));
        return String.format("Update user set userName='%s',phoneNo='%s' where id=%d",studentDto.getUserName(),studentDto.getPhoneNo(),studentDto.getId());
    }

    public String getAllUsers(){
        String sql = "Select * from user ";
        return sql;
    }

    public String getUserById(int id){
        return String.format("Select * from user where id = %d",id);
    }

    public String deleteUser(StudentDto studentDto){
        return String.format("Delete from user where id = %d",studentDto.getId());

    }







}
