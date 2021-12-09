package Admin;

import FileHandler.DelfinFileReader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class written by Søs
 */

public class BookKeeper {
    //Creating a new scanner
    Scanner scanner = new Scanner(System.in);
    //Creating a new file reader
    DelfinFileReader delfinFileReader = new DelfinFileReader();
    //Calling the getMemberInformation method from delfinFileReader class in an ArrayList called membersInformation
    ArrayList<String> memberInformation = delfinFileReader.getMemberInformation();

    private final int passivePrice = 500;
    private final int activeUnder18Price = 1000;
    private final int activeOver18Price = 1600;
    private final int activeOver60Price = 1200;

    //Method to find a members name
    public String findMemberName() {
        System.out.println("Input members name...");
        //Scanning for members name in ArrayList
        String membersName = scanner.nextLine();
        String membersData = "";

        //For loop to go through the ArrayList membersInformation
        for (int i = 0; i < memberInformation.size(); i++) {
            String lineOfInformation = memberInformation.get(i);
            //Separate the data from the ArrayList with every comma
            String[] membersList = lineOfInformation.split(",");
            //Getting the index number for name in the ArrayList
            String fullName = membersList[1];
            //If statement to see if the name is in the ArrayList
            if (membersName.equalsIgnoreCase(fullName)) {
                membersData = lineOfInformation;
                //Break when the name is found
                break;
            }
        }
        //Return the String with the name
        return membersData;
    }
    //Method to calculate the individual members fee
    public void calculateFees() {
        //Calling findMemberName method, and naming it membersData
        String membersData = findMemberName();
        //Separate the data from the ArrayList with every comma
        String[] membersList = membersData.split(",");

        int id = Integer.parseInt(membersList[0]);
        String fullName = membersList[1];
        int phoneNumber = Integer.parseInt(membersList[2]);
        String email = membersList[3];
        int age = Integer.parseInt(membersList[4]);
        String membershipType = membersList[5];
        String debts = membersList[6];

        //Find out if member is passive, if true membership price is "passive"
        if (membershipType.equalsIgnoreCase("passive")) {
            System.out.println(fullName + " gonna pay " + passivePrice + " kr.");
            //If false, continues to active
        } else if (membershipType.equalsIgnoreCase("active"))
            //New if - else statement
            //If the member is active and under 18, getting the active under 18 price
            if (age < 18) {
                System.out.println(fullName + " gonna pay " + activeUnder18Price + " kr.");
                //if the member is active and over 60, getting the active over 60 price
            } else if (age >= 60) {
                System.out.println(fullName + " gonna pay " + activeOver60Price + " kr.");
                //If the member is active and between 18 anf 59, getting the active over 18 price
            } else {
                System.out.println(fullName + " gonna pay " + activeOver18Price + " kr.");
            }
    }
    //Method to calculate the clubs income
    public int calculateIncome() {

        int clubIncome = 0;
        int passiveIncome = 0;
        int incomeUnder18 = 0;
        int incomeOver60 = 0;
        int incomeOver18 = 0;
        //Try - catch starts
        try {

            //Going through the for loop to get every member information
            for (int i = 0; i < memberInformation.size(); i++) {
                String lineOfInformation = memberInformation.get(i);

                //Separate the data from the ArrayList with every comma
                String[] membersList = lineOfInformation.split(",");

                int age = Integer.parseInt(membersList[4]);
                String membershipType = membersList[5];

                //If statement to see what type of membership the individual members have
                if (membershipType.equalsIgnoreCase("passive")) {
                    //Adding the memberships type price to the clubs income
                    clubIncome = clubIncome + passivePrice;
                } else {
                    //New if else statement
                    if (membershipType.equalsIgnoreCase("active") && age < 18) {
                        clubIncome = clubIncome + activeUnder18Price;
                    } else if (membershipType.equalsIgnoreCase("active") && age >= 60) {
                        clubIncome = clubIncome + activeOver60Price;
                    } else {
                        clubIncome = clubIncome + activeOver18Price;
                    }
                }
            }
            //Try - catch ends
        } catch (Exception e) {

        }
        System.out.println("The current income is: " + clubIncome + " kr.");

        return clubIncome;
    }

    //Method to calculate who of the members is in debt
    public void calculateDebt() {

        //Try - catch starts
        try {
            //Going through the for loop to get every member information
            for (int i = 0; i < memberInformation.size(); i++) {
                String lineOfInformation = memberInformation.get(i);

                //Separate the data from the ArrayList with every comma
                String[] membersList = lineOfInformation.split(",");

                String fullName = membersList[1];
                String debts = membersList[6];

                //If statement to see if members is in debt
                //If there is a "yes" at index number 6
                if (debts.equalsIgnoreCase("yes")) {
                    //Print the statement and the members name
                    System.out.println(debts + ", " + "" + fullName);
                }
            }
            //Try - catch ends
        } catch (Exception e) {

        }
    }

    //Method to calculate how many years in the future you want to see the income
    public void calculateFutureIncome() {

        //Calling the calculateIncome method to get the current income
        int currentIncome = calculateIncome();
        //Setting the expected rate of new members to 10% yearly
        double expectedRateOfNewMembers = 0.10;
        //Setting the decimal format to get a limited digits after the full stop
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        System.out.println("Please enter the period of years");
        //Setting how many years in the future you want to predict
        int year = scanner.nextInt();

        //Calculate the future income
        double futureIncome = currentIncome * Math.pow((1 + expectedRateOfNewMembers), year);
        //Change the future incomes decimal numbers
        String formatIncome = numberFormat.format(futureIncome);

        //Print how many years the person wants to see ahead and the expected income that year
        System.out.println("Expected income in " + year + " years: "  + formatIncome + " kr.");
    }
}