package com.teresol.core.api.core_api_crudService.dto;

public class StudentDto {

    private int id;
    private String userName;
    private String phoneNo;

    public StudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", phoneNo=" + phoneNo + ", userName=" + userName + "]";
    }

}
