package pl.library.libraryview.model;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor


public class Reader {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    private LocalDate registrationDate;
    private LocalDate resignationDate;

    @Override
    public String toString() {
        return "Reader {" +
                "id = " + id +
                ", first name = " + firstName +
                ", last name = " + lastName +
                ", address = " + address +
                ", telephone number = " + telephoneNumber +
                ", registration date = " + registrationDate +
                ", resignation date = " + resignationDate +
                '}';
    }
}
