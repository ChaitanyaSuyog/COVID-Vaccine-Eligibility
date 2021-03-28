import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class EligibilityTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Please give your name: ");
		String userName;

		// This is an easy way to create the userName variable outside the while loop and simplify your code
		while ((userName = scan.nextLine()).isEmpty()) {
			System.out.println("Please enter a valid username: ");
		}

		checkEligibility(userName);
    }

    public static void checkEligibility(String userName) throws InterruptedException {

		int covidCaseCount =  11_908_910;

		System.out.println("Dear " + userName + ", Welcome to the COVID Vaccine Eligibility Check (CVEC), " +
				"the COVID cases in India are currently-" + covidCaseCount + ".");
		System.out.println("Press the 'T' key to check your temperature. ");
		String tempMeasure = String.format("%.1f",ThreadLocalRandom.current().nextDouble(96, 98.9));

		if(scan.nextLine().equals("T")){
			System.out.print("Measuring your temperature");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(". ");
			Thread.sleep(1000);
			System.out.print(userName + ", your temperature " +
					"is at " + tempMeasure + " degrees.");
		}
		else {
			System.out.print("Skipping the temperature check");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
		}
		System.out.println();

		int patientAge = ThreadLocalRandom.current().nextInt(45, 100);

		if (patientAge >= 45 && patientAge <= 100) {

			System.out.println("Since you are " + patientAge + ", you are eligible for vaccination.");
		}
	}
}
