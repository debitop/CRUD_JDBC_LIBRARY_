package controller;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Actions.*;

public class StudentController extends HttpServlet {
    private String LIST_STUDENT = "listStudent.jsp";
    private String EDIT_STUDENT = "editStudent.jsp";
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
            req.setAttribute("student",student);
            view=EDIT_STUDENT;
        }
        else if (action.equalsIgnoreCase(DELETE.name())){
            int id = Integer.parseInt(req.getParameter("studId"));
            studentDao.delStudent(id);
            req.setAttribute("students", studentDao.listStudent()); //students - in JSP
            view = LIST_STUDENT;
        }
        else throw new RuntimeException();
        req.getRequestDispatcher(view).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
