package jets;
import java.util.Scanner;

public class CommandCenter {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		Jet[] jets = { 	new Jet("747", 1200, 1000, 200000000f, 1),
						new Jet("747", 1200, 1000, 200000000f, 1),
						new Jet("747", 1200, 1000, 200000000f, 1),
						new Jet("747", 1200, 1000, 200000000f, 1),
						new Jet("747", 1200, 1000, 200000000f, 1)
						};
		
		Fleet theFleet = new Fleet("Furious Finnigan's Fleet", jets);
		
		String choice = "0";
		do {
			showMenu();
			choice = getChoice(keyboard);
			doChoice(choice, theFleet, keyboard);
		} while(!choice.equals("5"));
	}
	
	public static void showMenu() {
		System.out.println("Choose your option (Press key 1-5): ");
		System.out.println("1) List entire fleet");
		System.out.println("2) View fastest jet");
		System.out.println("3) View jet with longest range.");
		System.out.println("4) Add a jet to fleet");
		System.out.println("5) Quit");
	}
	
	public static String getChoice(Scanner sc) {
		String choice = "0"; 
		while ("12345".indexOf(choice.charAt(0)) < 0) {
			try {
				System.out.print("> ");
				choice = sc.next();
				if ("12345".indexOf(choice.charAt(0)) < 0) {
					System.out.println("Please enter a choice between 1 and 5.");
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
			waitForKey(sc);
			break;
		case "2":
			fleet.viewFastest();
			waitForKey(sc);
			break;
		case "3":
			fleet.viewLongestRange();
			waitForKey(sc);
			break;
		case "4":
			fleet.addJet();
			waitForKey(sc);
			break;
		case "5":
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("***Error***");
			waitForKey(sc);
			break;
		}
	}
	
	public static void waitForKey(Scanner sc) {
		System.out.println("Press ENTER key to continue...");
		sc.nextLine();
		sc.nextLine();
	}
}
