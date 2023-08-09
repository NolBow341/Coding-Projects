package foodManagement;

public class Entree implements Listable {

	private String name;
	private SortedListOfImmutables foodList;  // This list will contain Food objects
	// immutable constructor 

	public Entree(String nameIn, SortedListOfImmutables foodListIn) {
		name = nameIn;
		foodList = new SortedListOfImmutables(foodListIn);
	}
	// getter for name of food
	@Override
	public String getName() {
		return name; // returns name 
	}
	// getter for Foodlist
	public SortedListOfImmutables getFoodList() {
		SortedListOfImmutables copy = new SortedListOfImmutables(foodList);
		return copy;
	}

// Getter for WholesaleCost
	@Override
	public int getWholesaleCost() {
		return foodList.getWholesaleCost(); // retuns cost (Wholesale)
	}

// Getter for RetailValue
	@Override
	public int getRetailValue() {
		return foodList.getRetailValue(); // returns food value
	}

	/**
	 * Compares the current object to the parameter and returns true if they
	 * have the same name.
	 * 
	 * @param other Entree to be compared to the current object
	 * @return true if the current object and the parameter have the same name, 
	 * false otherwise
	 */
	public boolean equals(Entree other) {
		boolean sameName = false;
		if(other.name.equals(this.name)) {
			sameName = true;
		}
		return sameName;
	}

	/* We'll give you this one for free.  Do not modify this method or you will
	 * fail our tests!
	 */
	@Override
	public String toString() {
		String retValue = "< ";
		for (int i = 0; i < foodList.getSize(); i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += foodList.get(i);
		}
		retValue += " >";
		return retValue;
	}
}
