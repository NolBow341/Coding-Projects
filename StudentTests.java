package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void Pairtest() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(1,1);
		testCard[1] = new Card(2,1);
		testCard[2] = new Card(1,3);
		testCard[3] = new Card(4,2);
		testCard[4] = new Card(5,0);
		
		
		
		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(1,1);
		testCard2[1] = new Card(2,0);
		testCard2[2] = new Card(2,1);
		testCard2[3] = new Card(3,3);
		testCard2[4] = new Card(4,2);
		
		
		assertEquals(true, PokerHandEvaluator.hasPair(testCard));
		assertEquals(true, PokerHandEvaluator.hasPair(testCard2));
   }
	@Test 
	public void hasTwoPair() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(10,3);
		testCard[1] = new Card(10,2);
		testCard[2] = new Card(3,0);
		testCard[3] = new Card(3,2);
		testCard[4] = new Card(6,1);
		assertEquals(true, PokerHandEvaluator.hasTwoPair(testCard));
		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(4,2);
		testCard2[1] = new Card(4,3);
		testCard2[2] = new Card(6,2);
		testCard2[3] = new Card(6,1);
		testCard2[4] = new Card(2,1);
		assertEquals(true, PokerHandEvaluator.hasTwoPair(testCard2));
	} 
	@Test
	public void hasThreeOfAKind() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(2,1);
		testCard[1] = new Card(2,1);
		testCard[2] = new Card(1,1);
		testCard[3] = new Card(2,1);
		testCard[4] = new Card(3,0);
		assertEquals(true, PokerHandEvaluator.hasThreeOfAKind(testCard));
	}
	@Test
	public void hasStraight() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(5,1);
		testCard[1] = new Card(6,0);
		testCard[2] = new Card(7,2);
		testCard[3] = new Card(8,3);
		testCard[4] = new Card(9,1);		

		assertEquals(true, PokerHandEvaluator.hasStraight(testCard));
		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(2,2);
		testCard2[1] = new Card(3,1);
		testCard2[2] = new Card(4,0);
		testCard2[3] = new Card(5,3);
		testCard2[4] = new Card(6,0);		

		assertEquals(true, PokerHandEvaluator.hasStraight(testCard2));
		
		Card[] testCard3 = new Card[5];
		testCard3[0] = new Card(6,3);
		testCard3[1] = new Card(7,2);
		testCard3[2] = new Card(8,1);
		testCard3[3] = new Card(9,0);
		testCard3[4] = new Card(10,1);		


		assertEquals(true, PokerHandEvaluator.hasStraight(testCard3));
		
	}
	@Test
	public void hasFourOfAKind() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(1,1);		
		testCard[1] = new Card(1,2);		
		testCard[2] = new Card(1,1);		
		testCard[3] = new Card(1,3);		
		testCard[4] = new Card(2,0);	
		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(3,0);		
		testCard2[1] = new Card(3,0);		
		testCard2[2] = new Card(3,0);		
		testCard2[3] = new Card(3,0);		
		testCard2[4] = new Card(5,2);		
assertEquals(true, PokerHandEvaluator.hasFourOfAKind(testCard));
assertEquals(true, PokerHandEvaluator.hasFourOfAKind(testCard2));

	}
	@Test
	public void hasFlush() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(1,0);		
		testCard[1] = new Card(3,0);		
		testCard[2] = new Card(4,0);		
		testCard[3] = new Card(11,0);		
		testCard[4] = new Card(9,0);		
		assertFalse(!PokerHandEvaluator.hasFlush(testCard));
	}
	@Test
	public void hasStraightFlush() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(1,0);		
		testCard[1] = new Card(2,0);		
		testCard[2] = new Card(3,0);		
		testCard[3] = new Card(4,0);		
		testCard[4] = new Card(5,0);		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(6,0);		
		testCard2[1] = new Card(7,0);		
		testCard2[2] = new Card(8,0);		
		testCard2[3] = new Card(9,0);		
		testCard2[4] = new Card(10,0);		
		assertEquals(true, PokerHandEvaluator.hasStraightFlush(testCard2));
		assertEquals(true, PokerHandEvaluator.hasStraightFlush(testCard));

	}
	@Test
	public void hasFullHouse() {
		Card[] testCard = new Card[5];
		testCard[0] = new Card(9,1);		
		testCard[1] = new Card(2,3);		
		testCard[2] = new Card(9,0);		
		testCard[3] = new Card(9,1);		
		testCard[4] = new Card(2,2);		
		
		Card[] testCard2 = new Card[5];
		testCard2[0] = new Card(3,0);		
		testCard2[1] = new Card(3,0);		
		testCard2[2] = new Card(3,2);		
		testCard2[3] = new Card(5,3);		
		testCard2[4] = new Card(5,1);		


	}
}








