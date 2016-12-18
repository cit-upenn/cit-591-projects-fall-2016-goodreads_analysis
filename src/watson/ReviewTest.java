package watson;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;

public class ReviewTest {

    String text = "the book is bad";
    Review review = new Review(text);
    ElementTone tone = EmotionAnalyser.toneGenerator(text);
    double anger;

    @Test
    public final void testReview() {

        assertEquals("Test review", review.getText(), "the book is bad");

    }

    @Test
    public final void testGetText() {
        assertEquals("Text", review.getText(), "the book is bad");
    }

    @Test
    public final void testGetAnger() {
        review.setAnger(0.15);
        assertEquals(review.getAnger(), 0.15, 0.00);

    }

    @Test
    public final void testGetDisgust() {
        review.setDisgust(0.20);
        assertEquals(review.getDisgust(), 0.20, 0.00);

    }   

    @Test
    public final void testGetFear() {
        review.setFear(1.00);
        assertEquals(review.getFear(), 1.0, 0.00);
    }   
    
    @Test
    public final void testGetJoy() {
        review.setJoy(0.50);
        assertEquals(review.getJoy(), 0.50, 0.00);
    }   
    
    @Test
    public final void testGetSadness() {
        review.setSadness(0.60);
        assertEquals(review.getSadness(), 0.60, 0.00);
    }   

}
