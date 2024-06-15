package MalKol.books.kniga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MalKol.books.kniga.model.Author;
import MalKol.books.kniga.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> putAuthorById(Long id, Author updatedAuthor) {
        Optional<Author> existingAuthor = authorRepository.findById(id);
        if (existingAuthor.isPresent()) {
            Author authorToUpdate = existingAuthor.get();
            if (updatedAuthor.getName() != null) {
                authorToUpdate.setName(updatedAuthor.getName());
            }
            if (updatedAuthor.getSurname() != null) {
                authorToUpdate.setSurname(updatedAuthor.getSurname());
            }
            authorRepository.save(authorToUpdate);
        }
        return existingAuthor;
    }

    @Override
    public void deleteAuthorById (Long id){
        authorRepository.deleteById(id);
    }
}
