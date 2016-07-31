package jets;

public class Fleet {
	private Jet[] jetsArray;
	private String name;
	private Pilot[] pilots;
	
	public Fleet(String name, Jet[] jetsArray) {
		this.name = name;
		this.jetsArray = jetsArray;
	}
	
	public Fleet(String name, Jet[] jetsArray, Pilot[] pilots) {
		this.name = name;
		this.jetsArray = jetsArray;
		this.pilots = pilots;
		this.assignRandomPilots();
	}
	// Methods
	
	// List fleet prints out the model, speed, range, and price of each jet in fleet.
	public void listFleet() {
		System.out.println("***********           Display Fleet           ***********");
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
			if (jet.getRange() > range) {
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
	public void addJet(Jet jet) {
		Jet[] newJetsArray = new Jet[this.jetsArray.length + 1];
		for (int i = 0; i < this.jetsArray.length; i++) {
			newJetsArray[i] = this.jetsArray[i];
		}
		newJetsArray[newJetsArray.length-1] = jet;
		this.jetsArray = newJetsArray;
	}
	
	// Loops through the array of jets, adds a random pilot to jets.
	public void assignRandomPilots() {
		int count = 0;
		while (count < this.jetsArray.length && count < this.pilots.length) {
			int randomPilotIndex = (int)(Math.random() * this.pilots.length);
			boolean currentPilotAlreadyAssigned = this.pilots[randomPilotIndex].getAssignedToJet();
			
			// Only assign the randomly chosen pilot if it isn't already assigned to a jet
			if (currentPilotAlreadyAssigned == false) {
				this.jetsArray[count].setPilot(this.pilots[randomPilotIndex]);
				this.pilots[randomPilotIndex].setAssignedToJet(true);
				count++;
			}
		}
	}
	// Add a pilot to Fleet
	public void addPilot(Pilot pilot) {
		Pilot[] newPilotsArray = new Pilot[this.pilots.length + 1];
		for (int i = 0; i < this.pilots.length; i++) {
			newPilotsArray[i] = this.pilots[i];
		}
		newPilotsArray[newPilotsArray.length-1] = pilot;
		this.pilots = newPilotsArray;
	}
	
	public void listPilots() {
		System.out.printf("%-30s %-10s %-20s\n", "Name", "Age", "Pay Grade");
		for (Pilot pilot : this.pilots) {
			System.out.printf("%-30s %-10s %-20s\n", pilot.getName(), pilot.getAge(), pilot.getPayGrade());
		}
	}
	
	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}
	
	public Pilot[] getPilots() {
		return this.pilots;
	}
	
	
	public void printHeader() {
		System.out.printf("%-5s %-30s %-20s %-15s %-10s %-15s\n", "ID", "Pilot", "Model", "Speed", "Range(mi)", "Price");
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
