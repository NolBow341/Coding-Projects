package foodManagement;

public class SortedListOfImmutables {
	/*
	 * STUDENTS:  You may NOT add any other instance variables or
	 * static variables to this class!
	 */
	private Listable[] items;

	// Constructor that sets list to 0
	public SortedListOfImmutables() {
		items = new Listable[0];
	}
	// Copy constructor for SortedListOfImmutables
	public SortedListOfImmutables(SortedListOfImmutables other) {
		items = new Listable[other.items.length];
		for(int i = 0; i < items.length; i++) {
			items[i] = other.items[i];
		}
	}
	// returns the size of the list 
	public int getSize() {
		return items.length;
	}
	/**
	 * Returns a reference to the item in the ith position in the list.  (Indexing
	 * is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return items[i];
	}
	// Adds an item to the list 
	public void add(Listable itemToAdd) {
		Listable[] newArray = new Listable[items.length + 1];
		int counter = 0;
		for(int i = 0; i < newArray.length; i++) {
			if (counter != items.length && (counter != i ||
					items[counter].getName()
					.compareTo(itemToAdd.getName()) < 0)){
				newArray[i] = items[counter];
				counter++;
			} else {
				newArray[i] = itemToAdd;
			}
		}
		items = newArray;
	}
	// Adds a new list to the list of items 
	public void add(SortedListOfImmutables listToAdd) {
		for( int i = 0; i < listToAdd.getSize(); i++) {
			add(listToAdd.get(i));
		}

	}
	// removes an item from the list of items
	public void remove(Listable itemToRemove) {
		boolean reSize = false;
		for( int i = 0; i < items.length; i++) {
			if(items[i].getName().equals(itemToRemove.getName())) {
				reSize=true;
				break;
			}
		}
		if(reSize == true) {
			Listable[] tempItem = new Listable[items.length - 1];
			int x = 0;
			boolean removed = false;
			for( int i = 0; i < items.length; i++) {
				if(items[i].getName().equals(itemToRemove.getName()) 
						&& removed == false) {
					removed = true;
					continue;
				} else {
					tempItem[x] = items[i];
					x++;
				}
			}
			items = new Listable[tempItem.length];
			for( int j = 0; j < items.length; j++) {
				items[j] = tempItem[j];
			}
		}
	}
	// Removes a whole list of items 
	public void remove(SortedListOfImmutables listToRemove) {
		for(int i = 0; i < listToRemove.items.length; i++) {
			this.remove(listToRemove.items[i]);
		}
	}
	// returns the sum of the Wholesale cost of items in list
	public int getWholesaleCost() {
		int sum = 0;
		for( int i = 0; i < items.length; i++) {
			sum += items[i].getWholesaleCost();
		}
		return sum;
	}
	// returns the sum of the RetailValue of an item in list
	public int getRetailValue() {
		int sum = 0;
		for( int i = 0; i < items.length; i ++) {
			sum += items[i].getRetailValue();
		}
		return sum;
	}
	// checks to see if item is in the list
	public boolean checkAvailability(Listable itemToFind) {
		for ( int i = 0; i < items.length; i++) {
			if(itemToFind.equals(items[i])) {
				return true;
			}
		}
		return false;
	}
	// checks if a list of items is in maintained in the list
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		SortedListOfImmutables copy = new SortedListOfImmutables(this);
		int paramLength = listToCheck.items.length;
		int counter = 0;
		for( int i = 0; i < paramLength; i++) {
			for( int j = 0; j < copy.items.length; j++) {
				if(copy.items[j].equals(listToCheck.items[i])) {
					counter++;
					copy.remove(copy.items[j]);
					if( counter == paramLength) {
						return true;
					}
					break;
				}
			}
		}
		return false;
	}
	/*
	 * We'll give you this one for free.  Do not modify this method or you
	 * will fail our tests!
	 */
	@Override
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}