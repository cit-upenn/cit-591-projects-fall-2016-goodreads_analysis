package watson;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;

public class ReviewTest {
    
    String text = "the book is bad";
    Review review = new Review (text);
    ElementTone tone = EmotionAnalyser.toneGenerator(text);
//    ToneParser tp = new ToneParser(tone);
//    anger = tp.returnAnger();
    double anger;

    @Test
    public final void testReview() {

        tone = EmotionAnalyser.toneGenerator(text);
       
        ToneParser tp = new ToneParser(tone);
        anger = tp.returnAnger();
        disgust = tp.returnDisgust();
        fear = tp.returnFear();
        joy = tp.returnJoy();
        assertEquals("Test review", review.getText(), "the book is bad");

    }

    @Test
    public final void testGetText() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetAnger() {
      ElementTone tone = EmotionAnalyser.toneGenerator(text);
      ToneParser tp = new ToneParser(tone);
      anger = 0.15;
      assertEquals(review.getAnger(), 0.15, 0.00);

    }

    @Test
    public final void testGetDisgust() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetFear() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetJoy() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetSadness() {
        fail("Not yet implemented"); // TODO
    }

}
