package pl.library.libraryview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.library.libraryview.model.Loan;


import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Query("FROM Loan ORDER BY borrowingReader")
    List<Loan> findAllOrderByBorrowingReader();

    @Query("FROM Loan ORDER BY borrowedBook")
    List<Loan> findAllOrderByBorrowedBook();

    @Query("FROM Loan ORDER BY loanId")
    List<Loan> findAllOrderByLoanId();

    @Query("FROM Loan WHERE returnDate = :returnDate")
    List<Loan> findAllByReturnDate(@Param("returnDate") LocalDate returnDate);
}