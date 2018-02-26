package dao;

import model.Book;
import model.Student;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    void delBook(int bookid);
    void editBook(Book book);
    List listBookById(int userId);
    Book getBookById(int bookid);
}
