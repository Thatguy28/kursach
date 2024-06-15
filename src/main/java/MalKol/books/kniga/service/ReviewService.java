package MalKol.books.kniga.service;

import MalKol.books.kniga.exceptions.BookNotFoundException;
import MalKol.books.kniga.model.Review;
import MalKol.books.kniga.controller.requests.ReviewRequest;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Review addReview(ReviewRequest review) throws BookNotFoundException;

    List<Review> getAllReviews();

    List<Review> getReviewsByBook(long id) throws BookNotFoundException;

    Optional<Review> getReviewById(Long id);

    Optional<Review> putReviewById(Long id, Review updatedReview);

    void deleteReviewById(Long id);
}
