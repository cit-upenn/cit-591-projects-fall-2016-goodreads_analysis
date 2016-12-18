package watson;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {
    Book book = new Book("Moby Dick"); 
    

    @Test
    public final void testBook() {
        assertEquals(book.getTitle(), "Moby Dick"); // TODO
    }

    @Test
    public final void testAddReview() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetTitle() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetReviews() {
        fail("Not yet implemented"); // TODO
    }

}
