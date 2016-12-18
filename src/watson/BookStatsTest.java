package watson;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BookStatsTest {

    // Book book = new Book("");

    double[] emotions3 = { 1, 2, 3, 4, 5 };
    double percentAnger = 1;
    double percentDisgust = 2;
    double percentFear = 3;
    double percentJoy = 4;
    double percentSadness = 5;
    int analyzedReviews = 1;
    boolean analysisComplete = true;

    Book book1 = new Book("");
    double[] emotions1 = { 5, 4, 3, 2, 1 };
    double percentAnger1 = 5;
    double percentDisgust1 = 4;
    double percentFear1 = 3;
    double percentJoy1 = 2;
    double percentSadness1 = 1;
    int analyzedReviews1 = 0;
    boolean analysisComplete1 = true;

    @Test
    public final void testBookStats() {

    }

    @Test
    public final void testGetFullEmotionReport() {
        double[] emotions = new double[5];
        Book book = new Book("");
        Review review1 = new Review("abc");
        book.addReview(review1);

        ArrayList<Review> reviews = book.getReviews();

        double currentAnger = 0.5;
        double currentDisgust = 0.5;
        double currentFear = 0.0;
        double currentJoy = 0.1;
        double currentSadness = 0.1;
        double analyzedReviews = 0;
        double angerHit = 0;
        double disgustHit = 0;
        double fearHit = 0;
        double joyHit = 0;
        double sadnessHit = 0;

        for (Review review : reviews) {
            analyzedReviews++;
            if (currentAnger > .4) {
                angerHit++; }
            if (currentDisgust > .4) {
                disgustHit++; }
            if (currentFear > .4) {
                fearHit++; }
            if (currentJoy > .4) {
                joyHit++; }
            if (currentSadness > .4) {
                sadnessHit++; }
        }

        assertEquals("Book analyzed reviews", analyzedReviews, 1, 0.00);
        assertEquals("Get anger hit", angerHit, 1, 0.00);
        assertEquals("Get disgust hit", disgustHit, 1, 0.00);
        assertEquals("Get disgust hit", fearHit, 0, 0.00);
        assertEquals("Get disgust hit", joyHit, 0, 0.00);
        assertEquals("Get disgust hit", sadnessHit, 0, 0.00);

        percentAnger = ((double) angerHit / analyzedReviews) * 100;
        percentDisgust = ((double) disgustHit / analyzedReviews) * 100;
        percentFear = ((double) fearHit / analyzedReviews) * 100;
        percentJoy = ((double) joyHit / analyzedReviews) * 100;
        percentSadness = ((double) sadnessHit / analyzedReviews) * 100;
        assertEquals("Percent Anger", percentAnger, 100, 0);
        assertEquals("Percent Anger", percentDisgust, 100, 0);
        assertEquals("Percent Anger", percentFear, 0, 0);
        assertEquals("Percent Anger", percentJoy, 0, 0);
        assertEquals("Percent Anger", percentSadness, 0, 0);
        
        emotions[0] = percentAnger;
        emotions[1] = percentDisgust;
        emotions[2] = percentFear;
        emotions[3] = percentJoy;
        emotions[4] = percentSadness;
        
        assertEquals("Emotions", emotions[0], 100, 0.00);
        assertEquals("Emotions", emotions[1], 100, 0.00);
        assertEquals("Emotions", emotions[2], 0, 0.00);
        assertEquals("Emotions", emotions[3], 0, 0.00);
        assertEquals("Emotions", emotions[4], 0, 0.00);

    }

    @Test
    public final void testGetPercentAnger() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        
        double angerHit = 1;
        double analyzedReviews = 2;

        stats.setPercentAnger(((double) angerHit / analyzedReviews) * 100);

        assertEquals("Emotions", stats.getPercentAnger(), 50, 0.00);

    }

    @Test
    public final void testGetPercentDisgust() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        
        double disgustHit = 1;
        double analyzedReviews = 2;

        stats.setPercentDisgust(((double) disgustHit / analyzedReviews) * 100);

        assertEquals("Emotions", stats.getPercentDisgust(), 50, 0.00);

    }

    @Test
    public final void testGetPercentFear() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        
        double fearHit = 1;
        double analyzedReviews = 5;

        stats.setPercentFear(((double) fearHit / analyzedReviews) * 100);

        assertEquals("Emotions", stats.getPercentFear(), 20, 0.00);
        
    }

    @Test
    public final void testGetPercentJoy() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        
        double joyHit = 1;
        double analyzedReviews = 2;

        stats.setPercentJoy(((double) joyHit / analyzedReviews) * 100);

        assertEquals("Emotions", stats.getPercentJoy(), 50, 0.00);
    }

    @Test
    public final void testGetPercentSadness() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        
        double sadnessHit = 1;
        double analyzedReviews = 10;

        stats.setPercentSadness(((double) sadnessHit / analyzedReviews) * 100);

        assertEquals("Emotions", stats.getPercentSadness(), 10, 0.00);
    }

    @Test
    public final void testGetEmotions() {
        Book book = new Book("");
        BookStats stats = new BookStats(book);
        double[] emotions = new double[5];
        stats.setEmotions(emotions);
        emotions[0] = percentAnger;
        emotions[1] = percentDisgust;
        emotions[2] = percentFear;
        emotions[3] = percentJoy;
        emotions[4] = percentSadness;
        
        double[] emotions2 = {1, 2, 3, 4, 5};        
      

        Assert.assertArrayEquals(stats.getEmotions(), emotions2, 0.00);
        
    }

}
