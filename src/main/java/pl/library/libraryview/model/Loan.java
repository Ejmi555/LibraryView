package pl.library.libraryview.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

public class Loan {

    private int loanId;
    private Book borrowedBook;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Reader borrowingReader;


    @Override
    public String toString() {
        return "Loan {" +
                "loan id = " + loanId +
                ",\n borrowed Book = " + borrowedBook +
                ",\n loan date = " + loanDate +
                ",\n return date = " + returnDate +
                ",\n borrowing reader = " + borrowingReader +
                "\n}\n";
    }
}