package br.com.unime.apibooks.services;

import br.com.unime.apibooks.entities.Book;
import br.com.unime.apibooks.exceptions.BookNotFoundException;
import br.com.unime.apibooks.exceptions.TableEmptyException;
import br.com.unime.apibooks.repositories.BookRepository;
import br.com.unime.apibooks.requests.BookRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookRequest> getAll() {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            throw new TableEmptyException("No data registered");
        }
        return books.stream()
                .map(order-> new ModelMapper().map(order, BookRequest.class))
                .collect(Collectors.toList());
    }

    public BookRequest getOne(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bookOptional.get(), BookRequest.class);
    }

    public BookRequest createBook(BookRequest bookRequest) {
        Book book = new ModelMapper().map(bookRequest, Book.class);
        Book savedOrder = bookRepository.save(book);

        return new ModelMapper().map(savedOrder, BookRequest.class);
    }

}
