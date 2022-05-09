package pl.library.libraryview.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.library.libraryview.model.Book;
import pl.library.libraryview.model.Loan;
import pl.library.libraryview.model.Reader;
import pl.library.libraryview.repository.LoanRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
    }

    public Loan addLoan(Book book, Reader reader) {
        if (!book.getIsAvailable()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        Loan loan = Loan.builder()
                .book(book)
                .reader(reader)
                .loanDate(LocalDate.now())
                .build();
        return loanRepository.save(loan);
    }

    public List<Loan> getLoans() { return loanRepository.getAllOrderByLoanDate();}

    public List<Loan> findAll() { return loanRepository.findAll();}
}

