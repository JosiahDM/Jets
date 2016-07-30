package jets;

// Fleet contains minimum 5 Jets. 


public class Fleet {
	private Jet[] jetsArray;
	private String name;
	
	public Fleet(String name, Jet[] jetsArray) {
		this.name = name;
		this.jetsArray = jetsArray;
	}
	
	// Methods
	
	// List fleet prints out the model, speed, range, and price of each jet in fleet.
	public void listFleet() {
		printHeader();
		for (Jet jet : jetsArray) {
			jet.display();
		}
	}
	
	// The view fastest jet and longest range options both print out all of
	// the information about their jets.
	public void viewFastest() {
		float fastest = 0.0F;
		Jet fastestJet = null;
		for (Jet jet : jetsArray) {
			if (jet.getSpeed() > fastest) {
				fastest = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println("***         Fastest jet in the fleet          ***");
		System.out.println("*************************************************");
		printHeader();
		fastestJet.display();
		System.out.println();
	}
	
	public void viewLongestRange() {
		int range = 0;
		Jet longestRange = null;
		for (Jet jet : jetsArray) {
			if (jet.getSpeed() > range) {
				range = jet.getRange();
				longestRange = jet;
			}
		}
		System.out.println("***      Longest ranged jet in the fleet      ***");
		System.out.println("*************************************************");
		printHeader();
		longestRange.display();
		System.out.println();
	}
	
	// A user can add custom jets to the fleet.
	public void addJet() {
		System.out.println("Add a jet");
	}
	
	public void printHeader() {
		System.out.printf("%-5s %-20s %-15s %-10s %-15s\n", "ID", "Model", "Speed", "Range", "Price");
	}
	
	// Getters and Setters
	public Jet[] getJetsArray() {
		return jetsArray;
	}

	public void setJetsArray(Jet[] jetsArray) {
		this.jetsArray = jetsArray;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
