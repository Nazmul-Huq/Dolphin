package InputOutput;

import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);

    public int getId() {
        System.out.println("Enter Id");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public String getFullName(){
        System.out.println("Enter full name");
        String fullName = scanner.nextLine();
        return fullName;
    }

    public int getPhoneNumber() {
        System.out.println("Enter phone number");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        return phoneNumber;
    }

    public String getEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        return email;
    }

    public String  getAddress() {
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return address;
    }

    public int getAge() {
        System.out.println("Enter age");
        int age = Integer.parseInt(scanner.nextLine());
        return age;
    }

    public String  getMembershipType() {
        System.out.println("Enter membership type");
        String membershipType = scanner.nextLine();
        return membershipType;
    }

    public int getTrainerId() {
        System.out.println("Enter Trainer id");
        int trainerId = Integer.parseInt(scanner.nextLine());
        return trainerId;
    }

    public int getTrainingResults() {
        System.out.println("Enter Training Result.");
        int trainingResult = Integer.parseInt(scanner.nextLine());
        return trainingResult;
    }

    public int getTrainingDisciplineId(){
        System.out.println("Enter Training Discipline Id");
        int trainingDisciplineId = Integer.parseInt(scanner.nextLine());
        return trainingDisciplineId;

    }

    public int getSwimmerId() {
        System.out.println("Enter Admin.Swimmer Id");
        int swimmerId = Integer.parseInt(scanner.nextLine());
        return swimmerId;
    }

    public String getFileName(){
        System.out.println("Enter file name. Follow words by underscore");
        String fileName = scanner.nextLine();
        return fileName;
    }
}
