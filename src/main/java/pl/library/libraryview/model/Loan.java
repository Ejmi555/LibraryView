package pl.library.libraryview.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book_loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @OneToOne
    private Book borrowedBook;
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @OneToOne
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