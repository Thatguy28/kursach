package MalKol.books.kniga.repository;

import MalKol.books.kniga.model.Book;
import MalKol.books.kniga.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBook(Book book);
}
