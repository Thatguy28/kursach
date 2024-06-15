package MalKol.books.kniga.service;

import MalKol.books.kniga.exceptions.MarkNotFoundException;
import MalKol.books.kniga.model.Mark;
import MalKol.books.kniga.controller.requests.MarkRequest;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    Mark addMark(MarkRequest mark) throws MarkNotFoundException;

    List<Mark> getAllMarks();

    List<Mark> getMarksByBook(long id) throws MarkNotFoundException;

    Optional<Mark> getMarkById(Long id);

    void deleteMarkById(Long id);

    Optional<Mark> putMarkById(Long id, Mark updatedMark);
}
