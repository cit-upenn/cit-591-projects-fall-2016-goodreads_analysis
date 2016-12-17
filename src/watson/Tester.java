package watson;

import java.io.IOException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the name of a book: ");
		
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		System.out.println("How many reviews would you like to be taken into consideration?");
		int reviewCount = in.nextInt();
		
		
		Book testBook = new Book(response);
		
		
		try {
			GoodReads gr = new GoodReads(testBook, reviewCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookStats testStats = new BookStats(testBook);
		
		System.out.println("Percent of reviews with anger: " + testStats.getPercentAnger());
		System.out.println("Percent of reviews with disgust: " + testStats.getPercentDisgust());
		System.out.println("Percent of reviews with fear: " + testStats.getPercentFear());
		System.out.println("Percent of reviews with joy: " + testStats.getPercentJoy());
		System.out.println("Percent of reviews with sadness: " + testStats.getPercentSadness());

	}

}
