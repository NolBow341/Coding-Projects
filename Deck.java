package poker;

public class Deck {

	private Card[] cards;

	public Deck() {

		cards = new Card[52];
		int value = 1;
		for( int i = 0; i < 13; i++) {
			cards[i] = new Card(value, 0);
			value++;
		}
		value = 1;
		for( int i = 13; i < 26; i++) {
			cards[i] = new Card(value, 1);
			value++;
		}
		value = 1;
		for( int i = 26; i < 39; i++) {
			cards[i] = new Card(value,2);
			value++;
		}
		value = 1;
		for( int i = 39; i < 52; i++) {
			cards[i] = new Card(value, 3);
			value++;
		}
	}
	// copy constructor for deck
	public Deck(Deck other) {

		this.cards = other.cards;
	}
	// returns position of certain card
	public Card getCardAt(int position) {
		int value = cards[position].getValue();
		int suit = cards[position].getSuit();
		Card i = new Card(value,suit);

		return i;
	}
	public int getNumCards() {

		return cards.length;
	}
	// shuffles the deck 
	// uses Math.round to ensure deck is spilt as a whole number
	public void shuffle() {
		Card[] topHalf = new Card[(int) Math.round((double)this.getNumCards()/2.0)];
		Card[] bottomHalf = new Card[this.getNumCards()/2];

		for(int i = 0; i < this.getNumCards()/2; i++) {
			topHalf[i] = cards[i];
			bottomHalf[i] = cards[i+ topHalf.length];
		}
		if(this.getNumCards() % 2 != 0) 
			topHalf[topHalf.length-1] = cards[topHalf.length-1];
		int j = 0;
		for( int i = 0; i < this.getNumCards();i++) {
			if(i % 2 == 0) {
				cards[i] = topHalf[j];
			} else {
				cards[i] = bottomHalf[j];
				j++;
			}
		}	
	}
	// cuts the deck into two halves
	public void cut(int position) {
		Card[] topHalf = new Card[position]; 
		for(int i = 0; i < topHalf.length; i++) { 
			topHalf[i] = cards[i]; 
		} 

		Card[] bottomHalf = new Card[cards.length - topHalf.length]; 
		int count = position; 
		for (  int i = 0; i < bottomHalf.length; i++) { 
			bottomHalf[i] = cards[count]; 
			count++; 
		} 

		int top = 0; 
		for( int  i = 0; i < cards.length; i++) { 
			if ( i < bottomHalf.length) { 
				cards[i] = bottomHalf[i]; 
			} else { 
				cards[i] = topHalf[top]; 
				top++; 
			}
		}
	}
	// deals the cards to each player when clicked
	public Card[] deal(int numCards) {
		Card[] dealt = new Card[numCards];
		Card[] smaller = new Card[cards.length - numCards];
		for(int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[i + numCards];
		}
		for( int i = 0; i < numCards; i++) {
			dealt[i] = cards[i];
		}
		cards = smaller;
		return dealt;
	}
}
