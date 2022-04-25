package pl.library.libraryview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.library.libraryview.model.Reader;
import java.util.List;


public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    @Query("FROM Reader ORDER BY firstName")
    List<Reader> findAllOrderByFirstName();

    @Query("FROM Reader ORDER BY lastName")
    List<Reader> findAllOrderByLastName();

    @Query("FROM Reader ORDER BY readerId")
    List<Reader> findAllOrderByReaderId();

    @Query("FROM Reader WHERE lastName = :lastName")
    List<Reader> findAllByLastName(@Param("lastName") String lastName);
}
