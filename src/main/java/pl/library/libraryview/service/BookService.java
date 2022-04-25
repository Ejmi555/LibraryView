package pl.library.libraryview.service;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.library.libraryview.repository.BookRepository;
import pl.library.libraryview.model.Book;

import java.util.Optional;

@RestController
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        if (ObjectUtils.isEmpty(book.getAuthor()) || ObjectUtils.isEmpty(book.getTitle())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        book.setAvailable(true);
        return bookRepository.save(book);
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books/{bookId}")
    public Book borrowBook(@PathVariable Integer bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Book book = optionalBook.get();
        book.setAvailable(false);
        return bookRepository.save(book);
    }

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
