package MalKol.books.kniga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MalKol.books.kniga.controller.requests.BookRequest;
import MalKol.books.kniga.exceptions.AuthorNotFoundException;
import MalKol.books.kniga.model.Author;
import MalKol.books.kniga.model.Book;
import MalKol.books.kniga.repository.BookRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Override
    public Book addBook(BookRequest book) throws AuthorNotFoundException {
        Optional<Author> author = authorService.getAuthorById(book.getAuthorId());
        if (author.isPresent()) {
            return bookRepository.save(
                    new Book(
                            null,
                            author.get(),
                            book.getBookName(),
                            book.getBookDesc(),
                            book.getNumberPage(),
                            book.getScore(),
                            book.getPublisher(),
                            new Date()
                    )
            );
        } else {
            throw new AuthorNotFoundException(book.getAuthorId());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> putBookById(Long id, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            if (updatedBook.getBookName() != null) {
                bookToUpdate.setBookName(updatedBook.getBookName());
            }
            if (updatedBook.getBookDesc() != null) {
                bookToUpdate.setBookDesc(updatedBook.getBookDesc());
            }
            if (updatedBook.getAuthor() != null) {
                bookToUpdate.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getNumberPage() != null) {
                bookToUpdate.setNumberPage(updatedBook.getNumberPage());
            }
            if (updatedBook.getScore() != null) {
                bookToUpdate.setScore(updatedBook.getScore());
            }
            if (updatedBook.getPublisher() != null) {
                bookToUpdate.setPublisher(updatedBook.getPublisher());
            }
            bookRepository.save(bookToUpdate);
        }
        return existingBook;
    }

    @Override
        public List<Book> getBooksByAuthor ( long id) throws AuthorNotFoundException {
            Optional<Author> author = authorService.getAuthorById(id);
            if (author.isPresent()) {
                return bookRepository.findAllByAuthor(author.get());
            } else {
                throw new AuthorNotFoundException(id);
            }
        }

        @Override
        public Optional<Book> getBookById (Long id){
            return bookRepository.findById(id);
        }

        @Override
        public void deleteBookById (Long id){
            bookRepository.deleteById(id);
        }

}
