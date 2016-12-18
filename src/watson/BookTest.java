package watson;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BookTest {
    
    Book book = new Book("Moby Dick"); 
    Book book2 = new Book("");
    Book book3 = new Book("12345");
    Review review = new Review("the book is ok");
    Review review2 = new Review("the book is bad");
    Review review3 = new Review("the book is good");
//    Review review4 = new Review("");
//    Review review5 = new Review(null);
    ArrayList<Review> reviews = new ArrayList<Review>();
    ArrayList<Review> reviews1 = new ArrayList<Review>();


    @Test
    public final void testBook() {
        assertEquals("Test equality of book title", book.getTitle(), "Moby Dick"); 
        assertNotEquals("Test capitals of title as this method shouldn't handle that", book.getTitle(), "moby dick"); 
        assertNotEquals("Test equality of book against ", book.getTitle(), "dsf Dick"); 
        assertNotEquals("Test equality of book", book.getTitle(), ""); 
        assertNotEquals("Test equality of book", book2.getTitle(), "Moby Dick");
        assertNotEquals("Test equality of book", book3.getTitle(), "Moby Dick"); 
        assertEquals("Test equality of book", book2.getTitle(), ""); 
        assertEquals("Test equality of book", book3.getTitle(), "12345"); 
    }

    @Test
    public final void testAddReview() {
        book.addReview(review);
        reviews.add(review);
        reviews1.add(review2);
        assertEquals("Testing that review was added", book.getReviews(), reviews);
        assertNotEquals("Testing that review wasn't added", book.getReviews(), reviews1);

        reviews.add(review3);
        book.addReview(review3);
        assertEquals("Testing that review was added", book.getReviews(), reviews);
//        assertEquals("testing that rewviews were added to")
        

    }

    @Test
    public final void testGetTitle() {
        assertEquals("Test equality of book title", book.getTitle(), "Moby Dick"); 
        assertNotEquals("Test capitals of title as this method shouldn't handle that", book.getTitle(), "moby dick"); 
        assertNotEquals("Test equality of book against ", book.getTitle(), "dsf Dick"); 
        assertNotEquals("Test equality of book", book.getTitle(), ""); 
        assertNotEquals("Test equality of book", book2.getTitle(), "Moby Dick");
        assertNotEquals("Test equality of book", book3.getTitle(), "Moby Dick"); 
        assertEquals("Test equality of book", book2.getTitle(), ""); 
        assertEquals("Test equality of book", book3.getTitle(), "12345"); 
        
    }

    @Test
    public final void testGetReviews() {
        book.addReview(review);
        book.addReview(review2);
        book2.addReview(review3);
        book2.addReview(review2);
        reviews.add(review);
        reviews.add(review2);
        reviews1.add(review3);
        reviews1.add(review2);
        assertEquals("Test get reviews of book", book.getReviews(), reviews);
        assertNotEquals("Test get reviews of book", book2.getReviews(), reviews);
        assertEquals("Test get reviews of book2", book2.getReviews(), reviews1);
        assertNotEquals("Test get reviews of book", book.getReviews(), reviews1);


    }

}
