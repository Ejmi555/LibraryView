package pl.library.libraryview.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.library.libraryview.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book ORDER BY title")
    List<Book> findAllOrderByTitle();

    @Query("FROM Book ORDER BY author")
    List<Book> findAllOrderByAuthor();

    @Query("FROM Book ORDER BY bookId")
    List<Book> findAllOrderByBookId();

    @Query("FROM Book WHERE title = :title")
    List<Book> findAllByTitle(@Param("title") String title);

    @Query("FROM Book WHERE author = :author")
    List<Book> findAllByAuthor(@Param("author") String author);
}
