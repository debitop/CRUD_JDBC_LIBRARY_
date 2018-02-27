package dao.impl;

import dao.BookDao;
import model.Book;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection connection;

    public BookDaoImpl() {
        connection = DbUtil.getConnection();
    }


    public void addBook(Book book) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO books(userid, author, title) VALUES (?,?,?)");
            ps.setInt(1, book.getUserid());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getTitle());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public void delBook(int bookid) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, bookid);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public void editBook(Book book) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET userid=?,author=?,title=?");
            ps.setInt(1, book.getUserid());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getTitle());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;

    public List listBookById(int userId) {
        List<Book> list = new ArrayList<Book>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE userid=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setUserid(rs.getInt("userid"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    ;

    public Book getBookById(int bookid){
        Book book = new Book();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE id=?");
            ps.setInt(1,bookid);
            ResultSet rs=ps.executeQuery();
            book.setUserid(rs.getInt("userid"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    };
}
