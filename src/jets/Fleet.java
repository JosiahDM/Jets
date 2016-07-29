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
		System.out.println("List fleet");
		System.out.printf("%-5s %-20s %-15s %-10s %-15s\n", "ID", "Model", "Speed", "Range", "Price");
	}
	
	// The view fastest jet and longest range options both print out all of
	// the information about their jets.
	public void viewFastest() {
		System.out.println("View fastest.");
	}
	
	public void viewLongestRange() {
		System.out.println("View longest");
	}
	
	// A user can add custom jets to the fleet.
	public void addJet() {
		System.out.println("Add a jet");
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
