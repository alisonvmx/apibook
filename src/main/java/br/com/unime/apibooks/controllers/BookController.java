package br.com.unime.apibooks.controllers;

import br.com.unime.apibooks.entities.Book;
import br.com.unime.apibooks.exceptions.BookNotFoundException;
import br.com.unime.apibooks.exceptions.TableEmptyException;
import br.com.unime.apibooks.requests.BookRequest;
import br.com.unime.apibooks.services.BookService;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookRequest>> getAllUsers() throws TableEmptyException {
        List<BookRequest> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRequest> findById(@PathVariable Long id) throws BookNotFoundException {
        BookRequest book = bookService.getOne(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookRequest> saveBook(@RequestBody BookRequest bookRequest) {
        BookRequest createdBook = bookService.createBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

}
