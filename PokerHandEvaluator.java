package poker;

import java.util.Arrays;

public class PokerHandEvaluator {
	// 	Shows when a hand has a Pair of cards
	public static boolean hasPair(Card[] cards) {
		for( int i = 0; i < cards.length - 1; i++) {
			for( int j = i+1; j < cards.length; j++) {
				if( cards[j].getValue() == cards[i].getValue()) {
					return true;
				}
			}
		}
		return false;
	}
	// Shows when a hand has Two Pairs of cards
	public static boolean hasTwoPair(Card[] cards) {
		if (! hasFourOfAKind(cards)) {
			int[] cardValue = { cards[0].getValue(),
					cards[1].getValue(),
					cards[2].getValue(),
					cards[3].getValue(),
					cards[4].getValue() };
			Arrays.sort(cardValue); // sorts array values numerically
			if(cardValue[0] == cardValue[1] && cardValue[2] == cardValue[3]
					|| cardValue[0] == cardValue[1] 
								&& cardValue[3] == cardValue[4]
									|| cardValue[1] == cardValue[2] &&
									cardValue[3] == cardValue[4]) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	// Shows when a hand a three of the same cards
	public static boolean hasThreeOfAKind(Card[] cards) {
		int counter = 0;
		for (int i = 0; i < cards.length; i++) {
			for( int j = 0 ; j < cards.length; j++) {
				if( cards[i].getValue() == cards[j].getValue()) {
					counter++;
				}
				if( counter == 3) {
					return true;
				}
			}
			counter = 0;
		}
		return false;
	}
	// Shows when a hand has 5 cards with consecutive values
	public static boolean hasStraight(Card [] cards) {
		int [] cardValue = { cards[0].getValue(), 
				cards[1].getValue(), 
				cards[2].getValue(),
				cards[3].getValue(), 
				cards[4].getValue() };
		Arrays.sort(cardValue); // sorts array values numerically
		if (cardValue[0]==1) {
			if( cardValue[1] == 2 
					&& cardValue[2] ==3 
					&& cardValue[3] ==4
					&& cardValue[4] ==5 
					||cardValue[1]==10
					&& cardValue[2]==11
					&& cardValue[3] ==12 
					&& cardValue[4] ==13){
				return true;
			} else {
				return false;
			}
		} else {
			for ( int i = 1; i < cards.length; i++) {
				if(cardValue[0] + i != cardValue[i]) {
					return false;
				}
			}
			return true;
		}

	}
	// Shows if a hand has 5 cards of the same suit
	public static boolean hasFlush(Card[] cards) {
		int counter = 0;
		for( int i = 0; i < cards.length; i++) {
			if( cards[0].getSuit() == cards[i].getSuit()) {
				counter++;
			}
		}
		if ( counter ==5) { // 5 consecutive card suits
			return true;
		}else {
			return false;
		}
	}
	// Shows when a hand has 5 cards ( a pair) and (three of a kind)
	public static boolean hasFullHouse(Card[] cards) {
		if( hasTwoPair(cards) && hasThreeOfAKind(cards)){
			return true;
		} else {
			return false;	
		}
	}
	// Shows when a Hand has 4 of the same value cards
	public static boolean hasFourOfAKind(Card[] cards) {
		int counter = 0;
		for( int i = 0; i < cards.length; i++) {
			for( int j = 0; j < cards.length; j++) {
				if( cards[i].getValue() == cards[j].getValue()) {
					counter++;
				}
				if ( counter == 4) { // 4 cards of same value
					return true;
				}
			}
			counter = 0;
		}
		return false;
	}
	// Shows when a hand has 5 cards of consecutive values and same suit
	public static boolean hasStraightFlush(Card[] cards) {

		if(hasStraight(cards) && hasFlush(cards)) {
			return true;
		} else {
			return false;
		}
	}
}