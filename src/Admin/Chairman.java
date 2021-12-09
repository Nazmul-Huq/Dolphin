package Admin;
import FileHandler.DelfinFileReader;
import FileHandler.DelfinFileWriter;

import java.util.Scanner;

public class Chairman extends Admin {

    /**
     * SARA'S CODE
     */
    //Chairman tasks

    String username;
    private int password;


    //Scanner
    static Scanner scanner = new Scanner(System.in);

    //File to save in
    static DelfinFileWriter fileWriter = new DelfinFileWriter();

    static DelfinFileReader fileReader = new DelfinFileReader();

    // make an empty constructor
    public Chairman() {
    }

    //The constructor
    public Chairman(int id, String fullName, int phoneNumber, String email, String address) {
        super(id, fullName, phoneNumber, email, address);

    }

    //Enter member info and save
    public void addNewMember() {

        //Add new member
        System.out.println("Please enter new members info! ");

        System.out.println("Enter memberID: ");
        int memberID = scanner.nextInt();

        System.out.println("Enter members full name: ");
        String fullName = scanner.nextLine() + scanner.nextLine();

        System.out.println("Enter members phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.println("Enter members email: ");
        String email = scanner.nextLine() + scanner.nextLine();

        System.out.println("Enter members address: ");
        String address = scanner.nextLine();

        System.out.println("Enter members age: ");
        int age = scanner.nextInt();

        System.out.println("Enter members membership type: ");
        String membership = scanner.next();


        ActiveMember newMember = new ActiveMember(memberID, fullName, phoneNumber, email, address, age, membership);

        //Save new member
        System.out.println("New member is now saved in 'members.txt' file");
        fileWriter.addNewMember(newMember);

    }

    //Add new employee and save
    public void addNewEmployee() {

        //Add new employee
        System.out.println("Please enter new employee info! ");

        System.out.println("Enter employeeID: ");
        int employeeID = scanner.nextInt();

        System.out.println("Enter employees full name: ");
        String fullName = scanner.nextLine() + scanner.nextLine();

        System.out.println("Enter employees phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.println("Enter employees email: ");
        String email = scanner.next();

        System.out.println("Enter employees address: ");
        String address = scanner.next();

        System.out.println("Enter  username: ");
        String username = scanner.nextLine() + scanner.nextLine();

        System.out.println("Enter password: ");
        int password = scanner.nextInt();


        Trainer trainer = new Trainer(employeeID, fullName, phoneNumber, email, address, username, password);

        //Save new employee in file
        System.out.println("New employee has now been saved in 'employee.txt' file ");
        fileWriter.addNewEmployee(trainer);

    }

    //Add new event and save in file
    public void addEvent() {

        //Add new event
        System.out.println("Add new event and write the information's below! ");

        System.out.println("Enter the date of event: ");
        String date = scanner.next();

        System.out.println("Enter time of event (Military time only): ");
        int time = scanner.nextInt();

        System.out.println("Enter the location of event: ");
        String location = scanner.nextLine() + scanner.nextLine();

        System.out.println("Enter eventID number: ");
        int ID = scanner.nextInt();

        Event event = new Event(date, time, location, ID);


        //Save event in file
        System.out.println("Event has been saved in 'event.txt' file");
        fileWriter.newEvent(event);

    }

    //Delete member from system
    public void deleteMember() {

        System.out.println("Please, choose which member you want to delete... ");
        int id = scanner.nextInt();

        //Delete member from file it has been saved in
        fileReader.deleteMember(id);

    }

    //Delete member from system
    public void deleteEmployee() {

        System.out.println("Please choose employee you want to delete... ");
        int id = scanner.nextInt();

        //Delete employee from file it has been saved in
        fileReader.deleteEmployee(id);

    }

}