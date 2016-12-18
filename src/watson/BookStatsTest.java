package watson;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookStatsTest {
    
    Book book1 = new Book("");
    double[] emotions = {50, 40, 30, 20, 10};
    double percentAnger = 50;
    double percentDisgust = 40; 
    double percentFear = 30;
    double percentJoy = 20;
    double percentSadness = 10;
    
    Book book2 = new Book("");
    double[] emotions2 = {10, 20, 30, 40, 50};
    double percentAnger2 = 10;
    double percentDisgust2 = 20; 
    double percentFear2 = 30;
    double percentJoy2 = 40;
    double percentSadness2 = 50;

    @Test
    public final void testBookStats() {
        book1 = new Book("");
        
         
    }
    

    @Test
    public final void testGetEmotionReport() {
        assertEquals("Test emotion report", emotions2, [10, 20, 30, 40, 50]);
    }

    @Test
    public final void testGetPercentAnger() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetPercentDisgust() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetPercentFear() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetPercentJoy() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetPercentSadness() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public final void testGetEmotions() {
        fail("Not yet implemented"); // TODO
    }

}
