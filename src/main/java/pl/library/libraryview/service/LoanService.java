package pl.library.libraryview.service;

import org.springframework.stereotype.Service;
import pl.library.libraryview.repository.LoanRepository;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
    }


}
