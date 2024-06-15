package MalKol.books.kniga.controller;

import MalKol.books.kniga.controller.requests.MarkRequest;
import MalKol.books.kniga.exceptions.MarkNotFoundException;
import MalKol.books.kniga.model.Mark;
import MalKol.books.kniga.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/marks")
public class MarkController {

    private final MarkService markService;

    @PostMapping
    public ResponseEntity<Mark> addMark(@RequestBody MarkRequest markRequest) throws MarkNotFoundException {
        return ResponseEntity.ok(markService.addMark(markRequest));
    }

    @GetMapping
    public ResponseEntity<List<Mark>> getAllMarks() {
        return ResponseEntity.ok(markService.getAllMarks());
    }

    @GetMapping("/findByIdBook")
    public ResponseEntity<List<Mark>> getMarkByBookId(@RequestParam("id") Long id) throws MarkNotFoundException {
        return ResponseEntity.ok(markService.getMarksByBook(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Mark> updatedMarkById(@PathVariable Long id, @RequestBody Mark updatedMark) {
        Optional<Mark> updatedMarkOptional = markService.putMarkById(id, updatedMark);
        return updatedMarkOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMarkById(@PathVariable Long id) {
        markService.deleteMarkById(id);
        return ResponseEntity.ok().build();
    }
}
