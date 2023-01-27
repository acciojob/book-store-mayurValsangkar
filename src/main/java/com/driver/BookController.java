package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable String id){
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> bookList = bookService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("author") String author){
        List<Book> bookList = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(bookList, HttpStatus.CREATED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam("genre") String genre){
        List<Book> bookList = bookService.findBooksByGenre(genre);
        return  new ResponseEntity<>(bookList, HttpStatus.CREATED);
    }

    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book removed from data base", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Data base cleard", HttpStatus.CREATED);
    }
}
