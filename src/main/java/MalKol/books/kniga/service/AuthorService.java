package MalKol.books.kniga.service;

import MalKol.books.kniga.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Optional<Author> putAuthorById(Long id, Author updatedAuthor);

    void deleteAuthorById(Long id);
}
