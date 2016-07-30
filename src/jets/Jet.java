package jets;

// Jets must have a model, speed, range, and price associated with them. 
// The speed should be taken in MPH but displayed to the user in Mach.

public class Jet {
	private String model;
	private float speed;
	private int range;
	private float price;
	static int jetsTotal = 0;
	private int jetId = 0;
	private Pilot pilot;
	
	public Jet(String model, float speed, int range, float price) {
		this.model = model;
		setSpeed(speed);
		this.range = range;
		this.price = price;
		this.jetId = ++jetsTotal;
	}

	// Methods
	public void display() {
		String myPilot = "";
		if (this.pilot == null) {
			myPilot = "N/A";
		} else {
			myPilot = this.pilot.getName();
		}
		System.out.printf("%-5d %-30s %-20s Mach %-10.1f %-10d %-,15.2f\n", jetId, myPilot, model, speed, range, price);
	}
	
	
	
	// Setters and Getters
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	
	public Pilot getPilot() {
		return this.pilot;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if (model.equals("")) {
			this.model = "*Model Not Entered*";
		} else {
			this.model = model;			
		}
	}

	public float getSpeed() {
		return speed;
	}

	// speed should be taken in MPH but displayed to the user in Mach.
	public void setSpeed(float speed) {
		speed *= .00130332F;
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getJetId() {
		return this.jetId;
	}
	
	
}
