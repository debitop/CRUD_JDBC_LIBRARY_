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

        if (action.equalsIgnoreCase(LIST.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            req.setAttribute("books", bookDao.listBookById(studId));
            view = LIST_BOOK;
        } else if (action.equalsIgnoreCase(DELETE.name())) {
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            int studId = Integer.parseInt(req.getParameter("studId"));
            bookDao.delBook(bookId);
            req.setAttribute("books", bookDao.listBookById(studId));
            view = LIST_BOOK;
        } else if (action.equalsIgnoreCase(CREATE.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            req.setAttribute("studId", studId);
            view = EDIT_BOOK;
        } else if (action.equalsIgnoreCase(EDIT.name())) {
            int studId = Integer.parseInt(req.getParameter("studId"));
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            Book book = bookDao.getBookById(bookId);
            book.setUserid(studId);
            req.setAttribute("book", book);
            view = EDIT_BOOK;

        }
req.getRequestDispatcher(view).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        String studId = req.getParameter("studId");
        book.setUserid(Integer.parseInt(studId));
        book.setAuthor(req.getParameter("author"));
        book.setTitle(req.getParameter("title"));
        String bookId = req.getParameter("bookId");
        if (bookId == null || bookId.isEmpty()) {

            bookDao.addBook(book);
        } else {
            book.setId(Integer.parseInt(bookId));
            bookDao.editBook(book);
        }
        req.setAttribute("books",bookDao.listBookById(Integer.parseInt(studId)));
        req.getRequestDispatcher(LIST_BOOK).forward(req,resp);
    }
}
