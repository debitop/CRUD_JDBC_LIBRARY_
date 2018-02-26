package dao.impl;

import dao.StudentDao;
import model.Student;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private Connection connection;

    public StudentDaoImpl() {
        connection = DbUtil.getConnection();
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO students(firstname, lastname, tel, dob) VALUES (?,?,?,?)");
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setString(3, student.getTel());
            ps.setDate(4, (Date) student.getDob());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public void delStudent(int studid) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, studid);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public void editStudent(Student student) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("UPDATE students SET firstname=?,lastname=?,tel=?,dob=? ");
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setString(3, student.getTel());
            ps.setDate(4, (Date) student.getDob());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public List listStudent() {
        List<Student> list = new ArrayList<Student>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student student = new Student();
                student.setFirstname(rs.getString("firsname"));
                student.setLastname(rs.getString("lastname"));
                student.setTel(rs.getString("tel"));
                student.setDob(rs.getDate("dob"));
                list.add(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    ;

    public Student getStudentById(int studid) {
        Student student = new Student();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id=?");
            ps.setInt(1, studid);
            ResultSet rs = ps.executeQuery();

            student.setFirstname(rs.getString("firsname"));
            student.setLastname(rs.getString("lastname"));
            student.setTel(rs.getString("tel"));
            student.setDob(rs.getDate("dob"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    ;
}
