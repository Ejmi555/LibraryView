package pl.library.libraryview.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {

    private int id;
    private String title;
    private String author;
    private Long isbn;

    @Override
    public String toString() {
        return "Book {" +
                "id = " + id +
                ", title = " + title +
                ", author = " + author +
                ", isbn = " + isbn +
                '}';
    }
}
