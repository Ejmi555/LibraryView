package pl.library.libraryview.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.library.libraryview.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book ORDER BY title")
    List<Book> findBooksOrderByTitle();

    @Query("FROM Book ORDER BY author")
    List<Book> findBooksOrderByAuthor();

    @Query("FROM Book ORDER BY bookId")
    List<Book> findBooksOrderByBookId();

    @Query("FROM Book WHERE title LIKE %:title% ORDER BY author")
    List<Book> findBooksByTitle(@Param("title") String title);

    @Query("FROM Book WHERE author = :author")
    List<Book> findBooksByAuthor(@Param("author") String author);
}
