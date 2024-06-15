package MalKol.books.kniga.service;

import MalKol.books.kniga.controller.requests.BookRequest;
import MalKol.books.kniga.exceptions.AuthorNotFoundException;
import MalKol.books.kniga.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book addBook(BookRequest book) throws AuthorNotFoundException;

    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(long id) throws AuthorNotFoundException;

    Optional<Book> putBookById(Long id, Book updatedBook);

    Optional<Book> getBookById(Long id);

    void deleteBookById(Long id);
}
