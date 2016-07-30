package jets;


public class Pilot {
	private String name;
	private int age;
	private String payGrade;
	private boolean assignedToJet;
	
	public Pilot(String name, int age, String payGrade) {
		this.name = name;
		setAge(age);
		this.payGrade = payGrade;
	}

	
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException("Age can't be 0 or less.");
		}
		this.age = age;
	}

	public String getPayGrade() {
		return payGrade;
	}

	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	
	public void setAssignedToJet(boolean assigned) {
		assignedToJet = assigned;
	}
	
	public boolean getAssignedToJet() {
		return assignedToJet;
	}
	
	public String toString() {
		return this.name;
	}
	
}
