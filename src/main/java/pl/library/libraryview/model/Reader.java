package pl.library.libraryview.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private int readerId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    @Column(name = "resignation_date")
    private LocalDate resignationDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reader")
    private List<Loan> loans;

}
