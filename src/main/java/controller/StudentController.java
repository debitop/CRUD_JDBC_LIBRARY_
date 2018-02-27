package controller;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.Actions.*;

public class StudentController extends HttpServlet {
    private static final String LIST_STUDENT = "/listStudent.jsp";
    private static final String EDIT_STUDENT = "/editStudent.jsp";
    private StudentDao studentDao;

    public StudentController() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";
        if (action.equalsIgnoreCase(LIST.name())) {
            req.setAttribute("students", studentDao.listStudent()); //students - in JSP
            view = LIST_STUDENT;
        } else if (action.equalsIgnoreCase(CREATE.name())) {
            view = EDIT_STUDENT;
        } else if (action.equalsIgnoreCase(EDIT.name())) {
            int id = Integer.parseInt(req.getParameter("studId"));
            Student student = studentDao.getStudentById(id);
            req.setAttribute("student", student);
            view = EDIT_STUDENT;
        } else if (action.equalsIgnoreCase(DELETE.name())) {
            int id = Integer.parseInt(req.getParameter("studId"));
            studentDao.delStudent(id);
            req.setAttribute("students", studentDao.listStudent()); //students - in JSP
            view = LIST_STUDENT;
        } else {
            throw new RuntimeException();
        }
        req.getRequestDispatcher(view).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstname(req.getParameter("firstname"));
        student.setLastname(req.getParameter("lastname"));
        student.setTel(req.getParameter("tel"));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dob"));
            student.setDob(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String studId = req.getParameter("studId");
        if (studId == null || studId.isEmpty()) {
            studentDao.addStudent(student);
        } else {
            student.setId(Integer.parseInt(studId));
            studentDao.editStudent(student);
        }
        req.setAttribute("students", studentDao.listStudent());
        req.getRequestDispatcher(LIST_STUDENT).forward(req, resp);

    }
}
