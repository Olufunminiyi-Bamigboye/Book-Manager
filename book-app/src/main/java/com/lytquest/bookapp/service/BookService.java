package com.lytquest.bookapp.service;

import com.lytquest.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service

public class BookService {
    private Set<Book> bookDatabase = new HashSet<>(); // initialize empty book database

    public void addBook(Book book) {
        if (book != null) {
            bookDatabase.add(book);
        }
    }

    public Set<Book> fetchBooks() {
        return bookDatabase;
    }

    public Book fetchBook(String title) {
        Book result = null;
        for(Book book : bookDatabase) {
            if (book.getTitle().equalsIgnoreCase(title)){
                result = book;
            }
        }
        return result;

//        Book result2 = bookDatabase.stream()
//                .filter(book->book.getTitle().equals(title))
//                .findFirst()
//                .get()
    }

    public Book deleteBook(int id) {
        Book bookToBeDeleted = null;
        for (Book book : bookDatabase) {    //book is being iterated thru the bookdatabase
            if (book.getId() == id) {       // if the book Id from d bookdatabase is equal to the id passed, that is the book
                bookToBeDeleted = book;     // this means, bookToBeDeleted equals to that book
                bookDatabase.remove(bookToBeDeleted);   // then bookToBeDeleted should be removed from the bookDatabase
                break;
            }
        }
        return bookToBeDeleted;
    }
    public Book updateBook(int id, Book newBook){
        Book uploadedBook = null;
        for(Book book : bookDatabase){
            if (book.getId() == id){
                uploadedBook = book;
                break;
            }
        }

        uploadedBook.setTitle(newBook.getTitle());
        uploadedBook.setAuthor(newBook.getAuthor());
        uploadedBook.setIsbn(newBook.getIsbn());
        uploadedBook.setPublished(newBook.isPublished());

        return uploadedBook;
    }

}

