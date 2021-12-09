package InputOutput;

import java.util.Scanner;

/**
 * class written by Nazmul
 */
public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    // get id number
    public int getId() {
        System.out.println("Enter Id");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    // get full name
    public String getFullName(){
        System.out.println("Enter full name");
        String fullName = scanner.nextLine();
        return fullName;
    }

    // get phone number
    public int getPhoneNumber() {
        System.out.println("Enter phone number");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        return phoneNumber;
    }

    // get email
    public String getEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        return email;
    }

    // get address
    public String  getAddress() {
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return address;
    }

    // get age
    public int getAge() {
        System.out.println("Enter age");
        int age = Integer.parseInt(scanner.nextLine());
        return age;
    }

    // get membership type
    public String  getMembershipType() {
        System.out.println("Enter membership type");
        String membershipType = scanner.nextLine();
        return membershipType;
    }

    // get trainer id
    public int getTrainerId() {
        System.out.println("Enter Trainer id");
        int trainerId = Integer.parseInt(scanner.nextLine());
        return trainerId;
    }

    // get training results
    public int getTrainingResults() {
        System.out.println("Enter Training Result.");
        int trainingResult = Integer.parseInt(scanner.nextLine());
        return trainingResult;
    }

    // get training discipline
    public int getTrainingDisciplineId(){
        System.out.println("Enter Training Discipline Id");
        int trainingDisciplineId = Integer.parseInt(scanner.nextLine());
        return trainingDisciplineId;

    }

    // get swimmer id
    public int getSwimmerId() {
        System.out.println("Enter Admin.Swimmer Id");
        int swimmerId = Integer.parseInt(scanner.nextLine());
        return swimmerId;
    }

    // get file name
    public String getFileName(){
        System.out.println("Enter file name. Follow words by underscore");
        String fileName = scanner.nextLine();
        return fileName;
    }
}
