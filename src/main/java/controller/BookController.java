package controller;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Actions.*;

public class BookController extends HttpServlet {
    private static final String LIST_BOOK = "listBook.jsp";
    private static final String EDIT_BOOK = "editBook.jsp";
    private BookDao bookDao;

    public BookController() {
        bookDao = new BookDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";

        if (action.equalsIgnoreCase(LIST_BY_ID.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            req.setAttribute("books", bookDao.listBookById(studId));
            view = "LIST_BOOK";
        } else if (action.equalsIgnoreCase(DELETE.name())) {
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            int studId = Integer.parseInt(req.getParameter("studId"));
            bookDao.delBook(bookId);
            req.setAttribute("books", bookDao.listBookById(studId));
            view = "LIST_BOOK";
        } else if (action.equalsIgnoreCase(CREATE.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            req.setAttribute("studId", studId);
            view = "EDIT_BOOK";
        } else if (action.equalsIgnoreCase(EDIT.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            Book book = bookDao.getBookById(bookId);
            book.setUserid(studId);
            req.setAttribute("book", book);
            view = "EDIT_BOOK";
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
