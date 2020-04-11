package com.als.jdbc;


public class Student {
    private String studentId, studentName, contactNo, address, email, fathersName, faculty;
    private float percentage;

    public Student() {
    }

    public Student(String studentId, String studentName, String contactNo, String address, String email, String fathersName, String faculty, float percentage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.address = address;
        this.email = email;
        this.fathersName = fathersName;
        this.faculty = faculty;
        this.percentage = percentage;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }


}