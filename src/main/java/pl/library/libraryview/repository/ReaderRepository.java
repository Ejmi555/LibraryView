package pl.library.libraryview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.library.libraryview.model.Reader;
import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    @Query("FROM Reader ORDER BY firstName")
    List<Reader> findAllOrderByFirstName();

    @Query("FROM Reader ORDER BY readerId")
    List<Reader> getAllOrderById();

    @Query("FROM Reader ORDER BY lastName")
    List<Reader> findAllOrderByLastName();

    @Query("FROM Reader ORDER BY readerId")
    List<Reader> findAllOrderByReaderId();

    @Query("FROM Reader WHERE lastName = :lastName")
    List<Reader> findAllByLastName(@Param("lastName") String lastName);

    @Query("FROM Reader ORDER BY lastName")
    List<Reader> getAllOrderByLastName();

    @Query("FROM Reader WHERE firstName = :firstName AND lastName = :lastName ORDER BY readerId")
    List<Reader> findAllByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
