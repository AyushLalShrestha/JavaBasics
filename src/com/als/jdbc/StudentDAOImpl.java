package com.als.jdbc;s

import com.als.jdbc.StudentDAO;
import com.als.jdbc.DBConnection;
import com.als.jdbc.Student;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    DBConnection db = new DBConnection();

    @Override
    public int insert(Student s) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Student s) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getById(String id) throws SQLException, ClassNotFoundException {
        Student s = null;
        db.open();
        PreparedStatement stmt = db.initStatement("Select * from tbl_students where student_id = ?");
        stmt.setString(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            s = new Student();
            s.setStudentId(rs.getString("student_id"));
            s.setStudentName(rs.getString("student_name"));
            s.setContactNo(rs.getString("contact"));
            s.setAddress(rs.getString("address"));
            s.setEmail(rs.getString("email"));
            s.setFathersName(rs.getString("fathers_name"));
            s.setFaculty(rs.getString("faculty"));
            s.setPercentage(rs.getInt("percentage_so_far"));
            return s;
        }

        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

}