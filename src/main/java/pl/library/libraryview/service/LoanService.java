package pl.library.libraryview.service;

import org.springframework.web.bind.annotation.RestController;
import pl.library.libraryview.repository.LoanRepository;

@RestController
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
    }
}
