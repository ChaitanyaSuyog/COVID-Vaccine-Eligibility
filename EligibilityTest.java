package com.chaitanya;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class EligibilityTest {

    public static void main(String[] args) throws InterruptedException {

		int covidCaseCount =  11_908_910;

    	Scanner scan = new Scanner(System.in);
		System.out.println("Please give your name: ");

		String userName = scan.nextLine();
		System.out.println("Dear " + userName + ", Welcome to the COVID Vaccine Eligibility Check (CVEC), " +
				"the COVID cases in India are currently-" + covidCaseCount + ".");
		System.out.println("Press the 'T' key to check your temperature. ");

		//double tempMeasure = ThreadLocalRandom.current().nextDouble(96, 98.9);
		String tempMeasure = String.format("%.1f",ThreadLocalRandom.current().nextDouble(96, 98.9));

		if(scan.nextLine().equals("T")){
			System.out.println(userName + ", your temperature " +
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
