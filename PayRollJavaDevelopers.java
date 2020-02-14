import java.util.Scanner; // Scanner is in the java.util package

// This class will be used to determine a developer's final paycheck amount.
public class PayRollJavaDevelopers {

	// This method prompts the user for input, then calculates and
	// displays the total paycheck for each pay and skill level
	public static void main(String[] args) {
		// Declaring variables
		String sName = ""; // Developer's name
		double dHoursWorked = 0; // Hours Worked for Skill levels 1-3
		int nSkillLevel = 0; // Developer's skill level
		int nOption = 0; // Selection for yes or no
		double dAmountEarned = 0.0; // Amount earned thru working
		double dOverTime = 0.0; // Overtime hours worked
		double dAmountDeductedTools = 0.0; // Amount deducted from tools purchased
		double dAmountDeductedTaxes = 0.0; // Amount Deducted for taxes
		double dFinalPaycheck = 0.0; // Final paycheck amount
		double dTempAmountEarned = 0.0; // Temporary amount earned

		Scanner input = new Scanner(System.in); // Create a Scanner object
		// Adding constants
		final int MAX_REG_HOURS = 40; // Variable to hold reg working hours
										// entered by user
		final int SKILL_LEVEL_ONE = 18; // Variable to hold Skill Level One pay
										// entered by user
		final int SKILL_LEVEL_TWO = 40; // Variable to hold Skill Level Two pay
										// entered by user
		final int SKILL_LEVEL_THREE = 60; // Variable to hold Skill Level Three
											// pay entered by user
		final int SKILL_LEVEL_FOUR = 80; // Variable to hold Skill Level Four pay
											// entered by user
		final double JAVA101 = 30; // Variable to hold java 101 for Skill
									// levels 2-4 need to buy and included
									// for level 1
		final double JAVA102 = 10; // Variable to hold java 102 for Skill
									// levels 2-4
		final double JAVA103 = 15; // Variable to hold java 103 for Skill
									// levels 2-4
		final double JAVA104 = 25; // Variable to hold java 104 for Skill
									// levels 2-4
		final double FACTOR = 1.5; // Variable to hold the overtime
		final double TAXES = 0.075; // Variable to hold taxes

		// Prompt user for name
		System.out.println("Please enter your name: ");
		sName = input.nextLine();

		// Prompt user for hours worked
		System.out.println("How many hours have you worked? ");
		dHoursWorked = input.nextDouble();

		// Prompt user for their paid level
		System.out.println("What is your paid level? (1-4)");
		nSkillLevel = input.nextInt();

		// Skill Level 1 - Intern
		if (nSkillLevel == 1) {
			if (dHoursWorked <= MAX_REG_HOURS) {
				// Calculating pay for hours worked
				dAmountEarned = dHoursWorked * SKILL_LEVEL_ONE;

			} // end validation for less than 40 hours worked
			else if (dHoursWorked > MAX_REG_HOURS) {
				// Calculation of 40 hours worked
				dAmountEarned = MAX_REG_HOURS * SKILL_LEVEL_ONE;
				// Calculation to find the extra hours worked
				dOverTime = (dHoursWorked - MAX_REG_HOURS) * SKILL_LEVEL_ONE * FACTOR;
				// Calculation of pay including overtime
				dAmountEarned = dAmountEarned + dOverTime;
			} // end validation for overtime
			dAmountDeductedTaxes = dAmountEarned * TAXES;
			dFinalPaycheck = dAmountEarned - dAmountDeductedTaxes;

			System.out.println();
			System.out.println("Developer's Information");
			// Read name to user
			System.out.println("Developer's name: " + sName);
			// Read Skill Level to user
			System.out.println("Skill Level: " + nSkillLevel);
			// Read total hours worked to user
			System.out.println("Total hours worked: " + (int) dHoursWorked);
			// Read amount earned to user
			System.out.println("Amount Earned: $" + dAmountEarned);
			// Read amount that was deducted for tools purchased
			System.out.println("Amount Deducted from Tools: $" + dAmountDeductedTools);
			// Read amount that was deducted for taxes
			System.out.println("Amount Deducted from Taxes: $" + dAmountDeductedTaxes);
			// Read the final paycheck amount that the developer will receive
			System.out.println("Final Paycheck Amount: $" + dFinalPaycheck);

		} //

		if (nSkillLevel == 2) {

			dAmountDeductedTools = dAmountDeductedTools + JAVA101;

			if (dHoursWorked <= MAX_REG_HOURS) {
				// Calculating pay for hours worked
				dAmountEarned = dHoursWorked * SKILL_LEVEL_TWO;
			} // end validation for less than 40 hours worked
			else if (dHoursWorked > MAX_REG_HOURS) {
				// Calculation of 40 hours worked
				dAmountEarned = MAX_REG_HOURS * SKILL_LEVEL_TWO;
				// Calculation to find the extra hours worked
				dOverTime = (dHoursWorked - MAX_REG_HOURS) * SKILL_LEVEL_TWO * FACTOR;
				// Calculation of pay including overtime
				dAmountEarned = dAmountEarned + dOverTime;
			} // end validation for overtime

			// Prompt user to purchase software tools
			System.out.println("Would you like to purchase software tools (1 = Yes, 2 = No)? ");
			nOption = input.nextInt();

			if (nOption == 1) {

				System.out.println("Would you like to purchase Java 102 - Android (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA102;
				}

				System.out.println("Would you like to purchase Java 103 - Web (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA103;
				}

				System.out.println("Would you like to purchase Java 104 - Enterprise (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA104;
				}

			}

			dTempAmountEarned = dAmountEarned;
			dTempAmountEarned = dAmountEarned - dAmountDeductedTools;
			dAmountDeductedTaxes = dTempAmountEarned * TAXES;
			dFinalPaycheck = dTempAmountEarned - dAmountDeductedTaxes;

			System.out.println();
			System.out.println("Developer's Information");
			// Read name to user
			System.out.println("Developer's name: " + sName);
			// Read Skill Level to user
			System.out.println("Skill Level: " + nSkillLevel);
			// Read total hours worked to user
			System.out.println("Total hours worked: " + (int) dHoursWorked);
			// Read amount earned to user
			System.out.println("Amount Earned: $" + dAmountEarned);
			// Read amount that was deducted for tools purchased
			System.out.println("Amount Deducted from Tools: $" + dAmountDeductedTools);
			// Read amount that was deducted for taxes
			System.out.println("Amount Deducted from Taxes: $" + dAmountDeductedTaxes);
			// Read the final paycheck amount that the developer will receive
			System.out.println("Final Paycheck Amount: $" + dFinalPaycheck);
		}

		if (nSkillLevel == 3) {

			dAmountDeductedTools = dAmountDeductedTools + JAVA101;

			if (dHoursWorked <= MAX_REG_HOURS) {
				// Calculating pay for hours worked
				dAmountEarned = dHoursWorked * SKILL_LEVEL_THREE;
			} // end validation for less than 40 hours worked
			else {
				// Calculation of 40 hours worked
				dAmountEarned = MAX_REG_HOURS * SKILL_LEVEL_THREE;
				// Calculation to find the extra hours worked
				dOverTime = (dHoursWorked - MAX_REG_HOURS) * SKILL_LEVEL_THREE * FACTOR;
				// Calculation of pay including overtime
				dAmountEarned = dAmountEarned + dOverTime;
			} // end validation for overtime

			// Prompt user to purchase software tools
			System.out.println("Would you like to purchase software tools (1 = Yes, 2 = No)? ");
			nOption = input.nextInt();

			if (nOption == 1) {

				System.out.println("Would you like to purchase Java 102 - Android (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA102;
				}

				System.out.println("Would you like to purchase Java 103 - Web (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA103;
				}

				System.out.println("Would you like to purchase Java 104 - Enterprise (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA104;
				}
			}

			dTempAmountEarned = dAmountEarned;
			dTempAmountEarned = dAmountEarned - dAmountDeductedTools;
			dAmountDeductedTaxes = dTempAmountEarned * TAXES;
			dFinalPaycheck = dTempAmountEarned - dAmountDeductedTaxes;

			System.out.println();
			System.out.println("Developer's Information");
			// Read name to user
			System.out.println("Developer's name: " + sName);
			// Read Skill Level to user
			System.out.println("Skill Level: " + nSkillLevel);
			// Read total hours worked to user
			System.out.println("Total hours worked: " + (int) dHoursWorked);
			// Read amount earned to user
			System.out.println("Amount Earned: $" + dAmountEarned);
			// Read amount that was deducted for tools purchased
			System.out.println("Amount Deducted from Tools: $" + dAmountDeductedTools);
			// Read amount that was deducted for taxes
			System.out.println("Amount Deducted from Taxes: $" + dAmountDeductedTaxes);
			// Read the final paycheck amount that the developer will receive
			System.out.println("Final Paycheck Amount: $" + dFinalPaycheck);
		}

		if (nSkillLevel == 4) {

			dAmountDeductedTools = dAmountDeductedTools + JAVA101;

			if (dHoursWorked <= MAX_REG_HOURS) {
				// Calculating pay for hours worked
				dAmountEarned = dHoursWorked * SKILL_LEVEL_FOUR;
			} // end validation for less than 40 hours worked
			else {
				// Calculation of 40 hours worked
				dAmountEarned = MAX_REG_HOURS * SKILL_LEVEL_FOUR;
				// Calculation to find the extra hours worked
				dOverTime = (dHoursWorked - MAX_REG_HOURS) * SKILL_LEVEL_FOUR * FACTOR;
				// Calculation of pay including overtime
				dAmountEarned = dAmountEarned + dOverTime;
			} // end validation for overtime

			// Prompt user to purchase software tools
			System.out.println("Would you like to purchase software tools (1 = Yes, 2 = No)? ");
			nOption = input.nextInt();

			if (nOption == 1) {

				System.out.println("Would you like to purchase Java 102 - Android (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA102;
				}

				System.out.println("Would you like to purchase Java 103 - Web (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA103;
				}

				System.out.println("Would you like to purchase Java 104 - Enterprise (1 = Yes, 2 = No)? ");
				nOption = input.nextInt();
				if (nOption == 1) {
					dAmountDeductedTools = dAmountDeductedTools + JAVA104;
				}
			}

			dTempAmountEarned = dAmountEarned;
			dTempAmountEarned = dAmountEarned - dAmountDeductedTools;
			dAmountDeductedTaxes = dTempAmountEarned * TAXES;
			dFinalPaycheck = dTempAmountEarned - dAmountDeductedTaxes;

			System.out.println();
			System.out.println("Developer's Information");
			// Read name to user
			System.out.println("Developer's name: " + sName);
			// Read Skill Level to user
			System.out.println("Skill Level: " + nSkillLevel);
			// Read total hours worked to user
			System.out.println("Total hours worked: " + dHoursWorked);
			// Read amount earned to user
			System.out.println("Amount Earned: $" + dAmountEarned);
			// Read amount that was deducted for tools purchased
			System.out.println("Amount Deducted from Tools: $" + dAmountDeductedTools);
			// Read amount that was deducted for taxes
			System.out.println("Amount Deducted from Taxes: $" + dAmountDeductedTaxes);
			// Read the final paycheck amount that the developer will receive
			System.out.println("Final Paycheck Amount: $" + dFinalPaycheck);
		}

		input.close();
	}// end main method
}// end PayRollJavaDevelopers class
