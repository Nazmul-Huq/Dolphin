package Admin;

import FileHandler.DelfinFileReader;
import FileHandler.DelfinFileWriter;

import java.util.Scanner;

public class Chairman extends Admin {

    //Sara's code
    //Chairman tasks

    String username;
    private int password;


    //Scanner
    static Scanner scanner = new Scanner(System.in);

    static DelfinFileWriter fileWriter = new DelfinFileWriter();

    static DelfinFileReader fileReader = new DelfinFileReader();



    /**
     * the constructor
     */

    public Chairman(int id, String fullName, int phoneNumber, String email, String address) {
        super(id, fullName, phoneNumber, email, address);
    }


    //Enter member info and save
    public static void addNewMember() {

        System.out.println("Please enter new member's info: ");
        int memberID = scanner.nextInt();

        ActiveMember newMember = new ActiveMember(memberID, "Hans Hansen", 23222421, "hansh@live.dk", "Amager hovedvej 20B", 19, "Active");

        //Save new member
        fileWriter.addNewMember(newMember);

        /*
        System.out.println("Member's ID:");
        int id = scanner.nextInt();
        System.out.println("Member's full name: ");
        String fullName = scanner.next();
        System.out.println("Member's phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Member's email: ");
        String email = scanner.next();
        System.out.println("Member's address: ");
        String address = scanner.next();
         */


    }



    public static void addNewEmployee() {

        Trainer trainer = new Trainer(1, "Birgit Karlson", 12131415, "birkarl@hotmail.com", "Langsigparken 12");

        fileWriter.addNewEmployee(trainer);

    }

    public static void addEvent() {

        Event event = new Event("22/2-2022", 1045, "Esbjerg svømmehal", 1);

        fileWriter.newEvent(event);

    }

    public static void deleteMember() {

        System.out.println("Please, choose which member you want to delete... ");
        int id = scanner.nextInt();

        fileReader.deleteMember(id);

    }

    public static void deleteEmployee() {



    }

}