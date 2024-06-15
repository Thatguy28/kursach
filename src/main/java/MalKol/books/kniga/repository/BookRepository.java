package MalKol.books.kniga.repository;

import MalKol.books.kniga.model.Author;
import MalKol.books.kniga.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);
}
