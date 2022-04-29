package pl.library.libraryview.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "isbn", nullable = false)
    private Long isbn;
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    }

