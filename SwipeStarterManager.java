/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ang Geok En
 * Student ID: 20047223
 * Class: E37C
 * Date/Time Last modified: 23/11/2020, 10:47
 */

public class SwipeStarterManager {

	public static void main(String[] args) {
		MightyMouse project1 = new MightyMouse("A111", "Use this as a normal mouse or a touchpad!", "Mac, Windows, Linux", 12800.00);
		
		String[] topFunders = new String[5];
		topFunders[0] = "Jenny - 6000.00";
		topFunders[1] = "Arvin - 8000.00";
		
		String[] generalFunders = new String[200];
		generalFunders[0] = "Arlene - 100.00";
		generalFunders[1] = "Sufian - 500.00";
		generalFunders[2] = "Wei Coing - 150.00";
		generalFunders[3] = "Molly - 1000.00";
		generalFunders[4] = "Aisha - 700.00";
		generalFunders[5] = "Stefan - 50.00";
		generalFunders[6] = "Xueling - 10.00";
		generalFunders[7] = "Sherene - 250.00";
		generalFunders[8] = "Paul - 20.00";
		
//		String[] latestGeneralFunders = new String[5];
		
		int option = -1;
		int count = 1;
		
		while (option != 5) {
			Helper.line(25, "-");
			System.out.println("S W I P E    S T A R T E R ");
			Helper.line(25, "-");
			System.out.println("1. View Project");
			System.out.println("2. Fund Project");
			System.out.println("3. View Top Funders");
			System.out.println("4. View General Funders");
			System.out.println("5. Quit");
			
			option = Helper.readInt("\nEnter choice > ");
			
			if (option == 1) {
				project1.showDetails();
			} else if (option == 2) {
				Helper.line(25, "-");
				System.out.println("F U N D    P R O J E C T");
				Helper.line(25, "-");
				char userfunding = Helper.readChar("Would you like to fund Mighty Mouse project?(y/n) > ");
				
				if (userfunding == 'y') {
					String name = Helper.readString("Please enter your name > ");
					double amount = Helper.readDouble("Amount to fund > ");
					
					if (amount < 5000) {
						System.out.println("Thank you for your donation " + name + "! You will be in our general funder list!");
						for(int i = 0; i < generalFunders.length; i++) {
							if (generalFunders[i] == null) {
								generalFunders[i] = name + " - " + amount;
							}
						}
					} else if (amount >= 5000) {
						if (topFunders.length == 5) {
							System.out.println("Sorry " + name + " our top funder list is full for now :(");
						} else {
							System.out.println("Thank you for your donation " + name + "! You will be in our TOP funders list!");
							int x = 1;
							x += topFunders.length;
							topFunders[x] = name + " - " + amount;
						}
					} else {
						System.out.println("Invalid amount");
					}
					double updatedamt = project1.goalAmount - amount;
					System.out.println("Total amount raised to date: " + updatedamt);
					project1.goalAmount = updatedamt;
					project1.currentAmountRaised += amount;
				} else {
					System.out.println("Back to menu");
				}
			} else if (option == 3) {
				Helper.line(25, "-");
				System.out.println("T O P    F U N D E R S");
				Helper.line(25, "-");
				
				for(int i = 0; i < topFunders.length; i++) {
					System.out.println(topFunders[i]);
				}
			} else if (option == 4) {
				Helper.line(25, "-");
				System.out.println("G E N E R A L    F U N D E R S");
				Helper.line(25, "-");
				
				for(int i = generalFunders.length-1; i > 0; i--) {
					if (generalFunders[i] != null && count < 6) {
						System.out.println(generalFunders[i]);
						count++;
						} 
					}
				}
				
			}
		}
	}

	
