package pl.library.libraryview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.library.libraryview.repository.BookRepository;
import pl.library.libraryview.model.Book;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book addBook(String title, String author, Long isbn) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .isAvailable(true)
                .build();
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public Optional<Book> updateBook(int bookId, String title, String author, Long isbn) {
        Book book = Book.builder()
                .bookId(bookId)
                .title(title)
                .author(author)
                .isbn(isbn)
                .build();
        return bookRepository.findById(bookId).map(savedBook -> bookRepository.save(book));
    }
}
