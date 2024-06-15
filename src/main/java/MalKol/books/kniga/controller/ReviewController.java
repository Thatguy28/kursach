package MalKol.books.kniga.controller;

import MalKol.books.kniga.exceptions.BookNotFoundException;
import MalKol.books.kniga.model.Review;
import MalKol.books.kniga.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MalKol.books.kniga.controller.requests.ReviewRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest) throws BookNotFoundException {
        return ResponseEntity.ok(reviewService.addReview(reviewRequest));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/findByIdBook")
    public ResponseEntity<List<Review>> getReviewByBookId(@RequestParam("id") Long id) throws BookNotFoundException {
        return ResponseEntity.ok(reviewService.getReviewsByBook(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Review> updatedReviewById(@PathVariable Long id, @RequestBody Review updatedReview) {
        Optional<Review> updatedReviewOptional = reviewService.putReviewById(id, updatedReview);
        return updatedReviewOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok().build();
    }

}
