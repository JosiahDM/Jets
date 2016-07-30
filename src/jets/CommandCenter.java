package jets;

import java.util.Scanner;

public class CommandCenter {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		Jet[] jets = { new Jet("7471", 1200, 3000, 200000000f), 
				new Jet("7472", 1200, 1000, 200000000f),
				new Jet("7473", 1200, 1000, 200000000f), 
				new Jet("7474", 1400, 1000, 200000000f),
				new Jet("7475", 1200, 1000, 200000000f) };
		Fleet theFleet = new Fleet("Furious Finnigan's Fleet", jets);
		
		Pilot[] pilots = { 
				new Pilot("Cap'n Pablo Sharkchum", 50, "Cap'n"),
				new Pilot("Barnacle Brain Ian", 30, "First Matey"),
				new Pilot("Jim Beam", 28, "Cabin Boy"), 
				new Pilot("Ron John", 28, "Cabin Boy"),  
				new Pilot("Ron John", 28, "Cabin Boy")  
				};
	
		theFleet.setPilots(pilots);
		theFleet.assignRandomPilots();

		String choice = "0";
		do {
			showMenu();
			choice = getChoice(keyboard);
			doChoice(choice, theFleet, keyboard);
		} while (!choice.equals("8"));
	}

	public static void showMenu() {
		System.out.println("Choose your option (Press key 1-8): ");
		System.out.println("1) List entire fleet");
		System.out.println("2) View fastest jet");
		System.out.println("3) View jet with longest range.");
		System.out.println("4) Add a jet to fleet");
		System.out.println("5) Hire a pilot");
		System.out.println("6) Assign a pilot");
		System.out.println("7) List pilots");
		System.out.println("8) Quit");
	}

	public static String getChoice(Scanner sc) {
		String choice = "0";
		while ("12345678".indexOf(choice.charAt(0)) < 0) {
			try {
				System.out.print("> ");
				choice = sc.next();
				if ("12345678".indexOf(choice.charAt(0)) < 0) {
					System.out.println("Please enter a choice between 1 and 8.");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Try again...");
			}
		}
		return choice;
	}

	public static void doChoice(String choice, Fleet fleet, Scanner sc) {
		switch (choice) {
		case "1":
			fleet.listFleet();
			waitForKey(sc, 1);
			break;
		case "2":
			fleet.viewFastest();
			waitForKey(sc, 1);
			break;
		case "3":
			fleet.viewLongestRange();
			waitForKey(sc, 1);
			break;
		case "4":
			Jet newJet = createJetFromUserInput(sc);
			fleet.addJet(newJet);
			System.out.println("*** Successfully added " + newJet.getModel() + " ***");
			waitForKey(sc, 1);
			break;
		case "5":
			System.out.println("Option 5");
			Pilot newPilot = createPilotFromUserInput(sc);
			fleet.addPilot(newPilot);
			System.out.println("*** Successfully added " + newPilot + " ***");
			waitForKey(sc, 0);
			break;
		case "6":
			assignPilot(sc, fleet);
			waitForKey(sc, 1);
			break;
		case "7":
			System.out.println("***********        All Pilots         *********");
			fleet.listPilots();
			waitForKey(sc, 1);
			break;
		case "8":
			System.out.println("*** Exited ***");
			break;
		default:
			System.out.println("***Error***");
			waitForKey(sc, 1);
			break;
		}
	}

	public static Jet createJetFromUserInput(Scanner sc) {
		System.out.print("Enter the model of the new jet: ");
		sc.nextLine();
		String model = sc.nextLine();
		float speed = promptForNumber(sc, "Enter the top speed of the jet: ");
		int range = (int)promptForNumber(sc, "Enter the maximum range of the jet: ");
		float price = promptForNumber(sc, "Enter the price of the jet: ");
		Jet jet = new Jet(model, speed, range, price);
		return jet;
	}
	
	public static Pilot createPilotFromUserInput(Scanner sc) {
		System.out.println("Enter the name of pilot: ");
		sc.nextLine();
		String name = sc.nextLine();
		int age = 0;
		while (age <= 0) {
			age = (int)promptForNumber(sc, "Enter the age of the pilot: ");
			sc.nextLine();
			if (age <= 0) {
				System.out.println("Age cannot be 0 or less. Try again...");
			}
		}
		System.out.println("Enter the paygrade of pilot: ");
		String payGrade = sc.nextLine();
		Pilot pilot = new Pilot(name, age, payGrade);
		return pilot;
	}

	public static float promptForNumber(Scanner sc, String msg) {
		float outValue = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(msg);
			String userInput = sc.next();
			try {
				outValue = Float.parseFloat(userInput);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Input requires a number. Try again. ***");
			}
		}
		return outValue;
	}
	
	public static Pilot checkForPilot(String pilotName, Fleet fleet) {
		Pilot[] pilots = fleet.getPilots();
		Pilot pilotOut = null;
		for (int i = 0; i < pilots.length; i++) {
			String nameInArray = pilots[i].getName().toLowerCase();
			pilotName = pilotName.toLowerCase();
			if (nameInArray.equals(pilotName)) {
				pilotOut = pilots[i];
			}
		}
		if (pilotOut == null) {
			System.out.println("No pilot by that name");
		}
		return pilotOut;
	}
	
	public static Jet checkForJet(int jetID, Fleet fleet) {
		Jet[] jets = fleet.getJetsArray();
		Jet jetOut = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i].getJetId() == jetID) {
				jetOut = jets[i];
			}
		}
		if (jetOut == null) {
			System.out.println("No jet by that ID");
		}
		return jetOut;
	}

	public static void assignPilot(Scanner sc, Fleet fleet) {
		System.out.println("Enter name of pilot: ");
		sc.nextLine();
		String pilotName = sc.nextLine();
		int id = (int)promptForNumber(sc, "Enter the Jet ID to assign pilot to: ");
		Jet jet = checkForJet(id, fleet);
		Pilot pilot = checkForPilot(pilotName, fleet);
		if (jet != null && pilot != null) {
			jet.setPilot(pilot);
			System.out.println(	"*** Successfully assigned " + pilot + " to " +
							   	"jet of ID: " + jet.getJetId() + " ***");
		}
	}
	
	public static void waitForKey(Scanner sc, int flag) {
		System.out.println("Press ENTER key to continue. 'Q' to quit...");
		if (flag > 0) { // Turn flag on if the last item read requires nextLine() to clear it
			sc.nextLine();
		}
		String choice = sc.nextLine();
		if (choice.toLowerCase().equals("q")) {
			System.out.println("*** Exited ***");
			System.exit(0);
		}
	}
}
