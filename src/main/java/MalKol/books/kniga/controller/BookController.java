package MalKol.books.kniga.controller;

import MalKol.books.kniga.controller.requests.BookRequest;
import MalKol.books.kniga.exceptions.AuthorNotFoundException;
import MalKol.books.kniga.model.Book;
import MalKol.books.kniga.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) throws AuthorNotFoundException {
        return ResponseEntity.ok(bookService.addBook(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/findByIdAuthor")
    public ResponseEntity<List<Book>> getBookByAuthorId(@RequestParam("id") Long id) throws AuthorNotFoundException {
        return ResponseEntity.ok(bookService.getBooksByAuthor(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> updatedBookById(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> updatedBookOptional = bookService.putBookById(id, updatedBook);
        return updatedBookOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }
}
