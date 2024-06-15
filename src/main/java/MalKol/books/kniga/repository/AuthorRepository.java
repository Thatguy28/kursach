package MalKol.books.kniga.repository;

import MalKol.books.kniga.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
