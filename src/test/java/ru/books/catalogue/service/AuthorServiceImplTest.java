package ru.books.catalogue.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import MalKol.books.kniga.model.Author;
import MalKol.books.kniga.repository.AuthorRepository;
import MalKol.books.kniga.service.AuthorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void testAddAuthor() {
        Author author = new Author(null, "Any", "Smit");
        Mockito.when(authorRepository.save(author)).thenReturn(author);

        Author addedAuthor = authorService.addAuthor(author);

        assertEquals(author, addedAuthor);
    }

    @Test
    public void testGetAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(null, "Jane", "Cord"));
        authors.add(new Author(1L, "Michael", "Jackson"));
        Mockito.when(authorRepository.findAll()).thenReturn(authors);

        List<Author> allAuthors = authorService.getAllAuthors();

        assertEquals(2, allAuthors.size());
    }

    @Test
    public void testGetAuthorById() {
        Long authorId = 1L;
        Author author = new Author(1L, "Michail", "Sonson");
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        Optional<Author> retrievedAuthor = authorService.getAuthorById(authorId);

        assertEquals(author, retrievedAuthor.get());
    }
}