package watson;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BookTest {
    Book book = new Book("Moby Dick"); 
    Book book2 = new Book("");
    Book book3 = new Book("12345");
    Review review = new Review("");
    Review review2 = new Review("the book is bad");
    Review review3 = new Review("the book is good");
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
        book.addReview(review2);
        
        reviews.add(review);
        reviews.add(review2);
        
        
        reviews.add(review3);
        
        reviews1.add(review);
        reviews1.add(review2);
        
        assertEquals("", book.getReviews(), reviews1);
        assertNotEquals("", book.getReviews(), reviews);
        
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
        fail("Not yet implemented"); // TODO
    }

}
