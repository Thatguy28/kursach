package MalKol.books.kniga.service;

import MalKol.books.kniga.exceptions.BookNotFoundException;
import MalKol.books.kniga.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MalKol.books.kniga.controller.requests.ReviewRequest;
import MalKol.books.kniga.model.Book;
import MalKol.books.kniga.repository.ReviewRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final BookService bookService;

    @Override
    public Review addReview(ReviewRequest review) throws BookNotFoundException {
        Optional<Book> book = bookService.getBookById(review.getBookId());
        if (book.isPresent()) {
            return reviewRepository.save(
                    new Review(
                            null,
                            book.get(),
                            review.getReviewText(),
                            new Date()
                    )
            );
        }
        else {
            throw new BookNotFoundException(review.getBookId());
        }
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByBook(long id) throws BookNotFoundException {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return reviewRepository.findAllByBook(book.get());
        }
        else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Optional<Review> putReviewById(Long id, Review updatedReview) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review reviewToUpdate = existingReview.get();
            if (updatedReview.getReviewText() != null) {
                reviewToUpdate.setReviewText(updatedReview.getReviewText());
            }
            reviewRepository.save(reviewToUpdate);
        }
        return existingReview;
    }

    @Override
    public void deleteReviewById (Long id){
        reviewRepository.deleteById(id);
    }

}
