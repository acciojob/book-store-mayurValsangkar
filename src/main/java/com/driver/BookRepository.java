package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private HashMap<Integer, Book> db = new HashMap<>();
    private int id = 1;

    public BookRepository(){

    }

    public Book save(Book book){
        book.setId(id++);
        db.put(book.getId(), book);
        return book;
    }

    public Book findBookById(int id){
        if(db.containsKey(id)){
            return db.get(id);
        }
        return null;
    }

    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<>();
        for(Book book : db.values()){
            bookList.add(book);
        }
        return bookList;
    }

    public void deleteBookById(int id){
        if(db.containsKey(id)){
            db.remove(id);
        }
    }

    public void deleteAll(){
        db.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> bookList = new ArrayList<>();
        for(Book book : db.values()){
            if(book.getAuthor().equals(author)){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = new ArrayList<>();
        for(Book book : db.values()){
            if(book.getGenre().equals(genre)){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
