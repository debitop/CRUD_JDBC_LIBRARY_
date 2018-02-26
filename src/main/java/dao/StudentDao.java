package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    void delStudent(int studid);
    void editStudent(Student student);
    List listStudent();
    Student getStudentById(int studid);

}
