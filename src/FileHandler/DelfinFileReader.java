package FileHandler;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DelfinFileReader {

    DelfinFileWriter fileWriter = new DelfinFileWriter();

    /**
     *
     * Written by Søs
     */
    public ArrayList<String> getLoginInformation() {
        ArrayList<String> loginInformation = new ArrayList<>();

        try{
            //
            Scanner scanFile = new Scanner(new File("Files/logins.txt"));
            scanFile.useDelimiter("[,\n]");

            while (scanFile.hasNext()) {
                String employeeLogin = scanFile.nextLine();

                loginInformation.add(employeeLogin);
            }
        }
        catch(Exception e) {

            System.out.println("File not found");
        }
        return loginInformation;
    }

    /**
     * Nazmul
     * read the training data
     */
    public ArrayList<String> getTrainingResult(){
        ArrayList<String > trainingResults = new ArrayList<String>();
        try{
            Scanner scanner = new Scanner(new File("Files/training_result.txt"));

            String individualRecord;
            while (scanner.hasNext()){
                individualRecord = scanner.nextLine();
                trainingResults.add(individualRecord);
            }

        } catch (Exception e){

            System.out.println("File reading failed");
        }
        return trainingResults;
    }

    /**
     * Søs
     * read the member file
     */
    //Method to read the member.txt file
    public ArrayList<String> getMemberInformation() {
        //Creating a new ArrayList
        ArrayList<String> memberInformation = new ArrayList();
        //Try - catch start
        try {
            //Scan the file
            Scanner scanFile = new Scanner(new File("Files/members.txt"));

            //While loop to go through the file
            while (scanFile.hasNextLine()) {
                String memberDetails = scanFile.nextLine();
                //Adding the file to the ArrayList
                memberInformation.add(memberDetails);
            }
            //Try - catch ends
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        //Returning the ArrayList memberInformation
        return memberInformation;
    }

    /**
     * SARA'S CODE
     */
    //Delete member from system
    public void deleteMember(int id) {

        ArrayList<String> memberInformation = new ArrayList();

        try {
            Scanner scanFile = new Scanner(new File("Files/members.txt"));

            while (scanFile.hasNextLine()) {
                String memberDetails = scanFile.nextLine();
                String[] memberInfo = memberDetails.split(",");
                int memberId = Integer.parseInt(memberInfo[0]);
                if (memberId != id) {
                    memberInformation.add(memberDetails);
                }
            }
            fileWriter.deleteMember(memberInformation);
            System.out.println("Deleted successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }

    }

    public void deleteEmployee(int id) {

        ArrayList<String> employeeInformation = new ArrayList();

        try {
            Scanner scanFile = new Scanner(new File("Files/employee.txt"));

            while (scanFile.hasNextLine()) {
                String employeeDetails = scanFile.nextLine();
                String[] employeeInfo = employeeDetails.split(",");
                int employeeId = Integer.parseInt(employeeInfo[0]);
                if (employeeId != id) {
                    employeeInformation.add(employeeDetails);
                }
            }
            fileWriter.deleteEmployee(employeeInformation);
            System.out.println("Deleted successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }

    }

    /**
     * SARA'S CODE END
     */

}
