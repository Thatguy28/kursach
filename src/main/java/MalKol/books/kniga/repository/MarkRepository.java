package MalKol.books.kniga.repository;

import MalKol.books.kniga.model.Book;
import MalKol.books.kniga.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByBook(Book book);

    List<Mark> findMarksByBookId(Long bookId);

    Mark findMarksByBookIdAndUserId(long bookId, Long userId);
}
