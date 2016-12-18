package watson;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import org.junit.Test;

import junit.framework.Assert;

public class ReviewGeneratorTest {
    
    ReviewGenerator rg = new ReviewGenerator();

    @Test
    public final void testReviewLoader() {
        Book book = new Book("This Book");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("This book is good");
        arrayList.add("This book is really good");
        
        Review review1 = new Review("This book is good");
        Review review2 = new Review("This book is really good");
        
        
        book.addReview(review1);
        book.addReview(review2);
        
        Book book2 = new Book("second book");
        
        rg.reviewLoader(arrayList, book2);
        
//       assertTrue(book.getReviews().containsAll(arrayList) && arrayList.containsAll(book.getReviews()));
        
        
//        List<String> list2 = asList("This book is good", "This book is really good");
//        assertTrue(book.getReviews().equals(list2));

        assertEquals(book.getReviews().size(), book2.getReviews().size());
        for (int i = 0; i < book.getReviews().size(); i++) 
            assertEquals(book.getReviews().get(i).toString(), book2.getReviews().get(i).toString());
        
//        assertTrue(book.getReviews().equals(book2.getReviews()));
   
        
    }

}
