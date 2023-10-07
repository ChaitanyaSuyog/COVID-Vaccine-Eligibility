import java.util.InputMismatchException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class EligibilityTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Please give your name: ");
		String userName;

		// Creating the variable inside the while loop to simplify the code.
		while ((userName = scan.nextLine()).isEmpty()) {
			System.out.println("Please enter a valid username: ");
		}
		checkEligibility(userName);
    }

    public static void checkEligibility(String userName) throws InterruptedException {

		System.out.println("Dear " + userName + ", welcome to the COVID Vaccine Eligibility Check (CVEC).");
		System.out.println("Press the 'T' key to check your temperature. ");
		String tempMeasure = String.format("%.1f", ThreadLocalRandom.current().nextDouble(96, 98.9));

		// Thread.sleep() ceases the execution of the thread for a specified time.
		if (scan.nextLine().equals("T")) {
			System.out.print("Measuring your temperature");
			for (int i = 0; i < 4; i++) {
				Thread.sleep(1000);
				System.out.print(".");
			}
			System.out.println("");
			System.out.print(userName + ", your temperature " +
					"is at " + tempMeasure + " degrees.");
			Thread.sleep(1000);
		}

		else {
			System.out.print("Skipping the temperature check");
			for (int i = 0; i < 4; i++) {
				Thread.sleep(1000);
				System.out.print(".");
			}
		}
		System.out.println();

		// Checking if the checkAge() method returns false and then stopping the program if it is.
		if(!checkAge()) {
			System.out.println("Age check failed. Exiting the program. Please try again.");
		}
	}

	public static boolean checkAge()  {
		System.out.println("Please specify your age:");

		int patientAge;

		// Check for a valid integer entry from the user.
		try {
			patientAge = scan.nextInt();
		}
		catch(InputMismatchException | IllegalStateException ex) {
			System.out.println("Invalid age.");
			return false;
		}

		// Check for valid age.
		if(patientAge < 0 || patientAge > 150) {
			System.out.println("Invalid age.");
			return false;
		}

		// Check for vaccine eligible age.
		if (patientAge >= 45) {
			System.out.println("Since you are " + patientAge + ", you are eligible for vaccination!");
		}
		else {
			System.out.println("Unfortunately, we do not have vaccines ready for your age group (" + patientAge + " years old). " +
					"Hopefully you will get them soon :)");
		}
		// All good and so return success.
		return true;
	}
}
