package pl.library.libraryview;

import pl.library.libraryview.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import pl.library.libraryview.model.Book;
import pl.library.libraryview.model.Loan;
import pl.library.libraryview.model.Reader;
import pl.library.libraryview.service.BookService;
import pl.library.libraryview.service.LoanService;
import pl.library.libraryview.service.ReaderService;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class LibraryController {

    private final BookService bookService;
    private final LoanService loanService;
    private final ReaderService readerService;


    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        if (ObjectUtils.isEmpty(book.getAuthor()) || ObjectUtils.isEmpty(book.getTitle())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        book.setIsAvailable(true);
        return bookService.saveBook(book);
    }


    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable("bookId") Integer bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/books/{bookId}")
    public Book borrowBook(@PathVariable("bookId") Integer bookId) {
        Optional<Book> optionalBook = bookService.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Book book = optionalBook.get();
        book.setIsAvailable(false);
        return bookService.saveBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("bookId") Integer bookId) {
        Optional<Book> optionalBook = bookService.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Book book = optionalBook.get();
        bookService.deleteBook(book);
    }

    @DeleteMapping("/readers/{readerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReaderById(@PathVariable("readerId") Integer readerId) {
        Optional<Reader> optionalReader = readerService.findById(readerId);
        if (optionalReader.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Reader reader = optionalReader.get();
        readerService.deleteReader(reader);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/readers")
    public List<Reader> getAllReaders() {
        return readerService.findAll();
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanService.findAll();
    }

    @PostMapping("/readers/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addReader(ModelMap model,
                                  @RequestParam(name = "firstName") String firstName,
                                  @RequestParam(name = "lastName") String lastName,
                                  @RequestParam(name = "address") String address,
                                  @RequestParam(name = "telephoneNumber", required = false) String telephoneNumber) {
        model.addAttribute(
                "reader",
                readerService.addReader(firstName, lastName, address, telephoneNumber));
        return new ModelAndView("operationSuccess");

    }

    @PostMapping("/books/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addBook(ModelMap model,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "author") String author,
                                @RequestParam(name = "isbn") Long isbn) {
        model.addAttribute(
                "book",
                bookService.addBook(title, author, isbn));
        return new ModelAndView("operationSuccess");
    }

    @PostMapping("/readers")
    @ResponseStatus(HttpStatus.CREATED)
    public Reader addReader(@RequestBody Reader reader) {
        if (ObjectUtils.isEmpty(reader.getFirstName()) || ObjectUtils.isEmpty(reader.getLastName()) || ObjectUtils.isEmpty(reader.getAddress())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return readerService.saveReader(reader);
    }

    @GetMapping("/books/find/title")
    public ModelAndView findBookByTitle(ModelMap model, @RequestParam(name = "title") String title) {
        model.addAttribute("books", bookService.findBooksByTitle(title));
        return new ModelAndView("bookList");
    }

    @GetMapping("/book")
    public ModelAndView findBookById(ModelMap model, @RequestParam(name = "id") Integer bookId) {

        model.addAttribute("book", bookService.findById(bookId));
        return new ModelAndView("book");
    }

    @GetMapping("/readers/find/name")
    public ModelAndView findReadersByFullName(ModelMap model,
                                              @RequestParam(name = "firstName") String firstName,
                                              @RequestParam(name = "lastName") String lastName) {
        model.addAttribute(
                "readers",
                readerService.findReadersByFullName(firstName, lastName));
        return new ModelAndView("readerList");
    }

    @PostMapping("/loans/lend")
    public String addLoan(ModelMap model,
                          @RequestParam(name = "bookId") Integer bookId,
                          @RequestParam(name = "readerId") Integer readerId) {
        model.addAttribute(
                "loan",
                loanService.addLoan(
                        bookService.findById(bookId).orElseThrow(ResourceNotFoundException::new),
                        readerService.getReader(readerId).orElseThrow(ResourceNotFoundException::new)));
        return "operationSuccess";
    }

    @GetMapping("books/update")
    public String updateBookForm(ModelMap model,
                                 @RequestParam(name = "bookId") Integer bookId) {
        model.addAttribute("book",
                bookService.findById(bookId).orElseThrow(ResourceNotFoundException::new));
        return "updateBookData";
    }

    @PutMapping("/books/update/data")
    public String updateBook(ModelMap model,
                             @RequestParam(name = "bookId") Integer bookId,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "author") String author,
                             @RequestParam(name = "isbn") Long isbn) {
        model.addAttribute(
                "book",
                bookService.updateBook(bookId, title, author, isbn));
        return "operationSuccess";
    }

    @GetMapping("readers/update")
    public String updateReaderForm(ModelMap model,
                                   @RequestParam(name = "readerId") Integer readerId) {
        model.addAttribute("reader",
                readerService.getReader(readerId).orElseThrow(ResourceNotFoundException::new));
        return "updateReaderData";
    }

    @PutMapping("/readers/update/data")
    public String updateReader(ModelMap model,
                               @RequestParam(name = "readerId") Integer readerId,
                               @RequestParam(name = "firstName") String firstName,
                               @RequestParam(name = "lastName") String lastName,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "telephoneNumber") String telephoneNumber) {
        model.addAttribute(
                "reader",
                readerService.updateReader(readerId, firstName, lastName, address, telephoneNumber));
        return "operationSuccess";
    }

    @GetMapping("books/find/all")
    public ModelAndView getAllBooks(ModelMap model) {
        model.addAttribute("books", bookService.findAll());
        return new ModelAndView("bookList");
    }

    @GetMapping("readers/find/all")
    public ModelAndView getAllReadersByLastName(ModelMap model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return new ModelAndView("readerList");
    }

    @GetMapping("loans/find/all")
    public ModelAndView getAllLoans(ModelMap model) {
        model.addAttribute("loans", loanService.getLoans());
        return new ModelAndView("loanList");
    }
}