package com.lytquest.bookapp.controller;

import com.lytquest.bookapp.model.Book;
import com.lytquest.bookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("books")
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book Added Successfully";
    }
    @GetMapping("books")
    public Set<Book> fetchBooks(){
        return bookService.fetchBooks();
    }

    @GetMapping("books/search")
    public Book getABook(@RequestParam String title){
        return bookService.fetchBook(title);
    }
    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Book Deleted Successfully";
    }
    @PutMapping("books/updates/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book newBook){
        bookService.updateBook(id, newBook);
        return "Book has been successfully updated";
    }
}
