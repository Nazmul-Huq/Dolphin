package Admin;

import Controller.AddInformation;
import FileHandler.DelfinFileWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer extends Admin{//Mo wrote this//

    AddInformation information = new AddInformation();
    //Attributes
    private String username;
    private int password;


    //FileWriter
    static DelfinFileWriter fileWriter = new DelfinFileWriter();

    //Arraylist to store the names of the swimmers
    static ArrayList<String> swimmers = new ArrayList<String>() ;

    //Scanner
    static Scanner scanner = new Scanner(System.in);

    //Event
    static Event event = new Event("22/02/2021",1400,"DGI byen",1);



    /**
     * constructor
     *
     * @param id
     * @param fullName
     * @param phoneNumber
     * @param email
     * @param address
     */
    public Trainer(int id, String fullName, int phoneNumber, String email, String address) {
        super(id, fullName, phoneNumber, email, address);
    }


    //Methods:

    // Adds a new Swimmer to train
    public static void addSwimmer() {
        System.out.println("input SwimmerInfo Below: Swimmer id number, Age, Name");
        int swimmerId = scanner.nextInt();
        int age = scanner.nextInt();
        String name = scanner.nextLine() + scanner.nextLine();


        System.out.println("Swimmer id number:\t" + swimmerId +
                "\nAge:\t\t\t\t" + age +
                "\nName:\t\t\t\t" + name);

        String info = "Swimmer id number:\t" + swimmerId +
                "\nAge:\t\t\t\t" + age +
                "\nName:\t\t\t\t" + name;

        swimmers.add(info);

        System.out.println();
        System.out.println("the Swimmer is added\n");

        //inserted into the swimmer ArrayList
    }


    //Shows information list of swimmers
    public void showSwimmerInfo() {
        for (String e:swimmers) {
            System.out.println(e);
            System.out.println("---------------------------");
        }
    }

    //adds the Selected Swimmer to a team
    public void addSwimmerToATeam() {
        //keeps going 5 times
        System.out.println();
        System.out.println("choose who you want to add to a team\n");

        fileWriter.swimmerTeam(counter());

        System.out.println("team added");

    }

    //chooses which Discipline to train
    public void addSwimmerDiscipline() {
        System.out.println("what discipline would you like to add a swimmer to?");

        System.out.println(" press 1: FreeStyle\n press 2: Butterfly\n press 3: Backstroke\n press 4: BreastStroke\n");
        int choiceOfDiscipline = scanner.nextInt();


        if (choiceOfDiscipline == 1) {
            System.out.println("FreeStyle is chosen");
            System.out.println("swimmers to be added:");

            fileWriter.disciplines(counter());

            System.out.println("swimmers added");

        } else if (choiceOfDiscipline == 2) {
            System.out.println("Butterfly is chosen");
            System.out.println("swimmers to be added:");

            fileWriter.disciplines(counter());

            System.out.println("swimmers added");

        } else if (choiceOfDiscipline == 3) {
            System.out.println("Backstroke is chosen");
            System.out.println("swimmers to be added:");

            fileWriter.disciplines(counter());

            System.out.println("swimmers added");

        } else if (choiceOfDiscipline == 4) {
            System.out.println("Breaststroke is chosen");
            System.out.println("swimmers to be added:");

            fileWriter.disciplines(counter());

            System.out.println("swimmers added");

        } else if (choiceOfDiscipline > 4) {
            System.out.println("you haven't set other disciplines");
        }
    }

    //can add or remove swimmer from the list of Top 5 best swimmers in the disciplines
    public void editTop5SwimmersList() {
        System.out.println("press 1: to remove swimmer from the list\npress 2: to add a swimmer \npress 3: to go back ");
        int choice = scanner.nextInt();


        if (choice == 1) {
            if (swimmers.size() > 0) {
                System.out.println("who do you want to remove");
                swimmers.remove(scanner.nextInt() -1);

                System.out.println("swimmer removed");
            } else if (swimmers.size() <= 0) {

                System.out.println("theres no one to remove\n\n");
            }

        } else if (choice == 2) {
            //if you want to add a new swimmer instead of deleting one
            addSwimmer();

        } else if (choice == 3) {
            System.out.println("returning to menu...");

        }
    }

    //adds chosen swimmers to an event
    public void addSwimmersToEvent() {
        System.out.println("press 1 to add swimmers to event\npress 2 to go back");

        int userChoice = scanner.nextInt();

        if (userChoice == 1) {

            System.out.println(event);

            System.out.println("who is going to this event?");

            fileWriter.eventList(counter());

            System.out.println("swimmers added to event");

            System.out.println("find the Event and List of participants in files");

        } else if (userChoice == 2){
            System.out.println("returning to menu...");
            System.out.println();

        }
    }

    //adds the discipline training result
    public void addTrainingResult() {
        information.addTrainingResult();
    }

    //Counter Method
    public int[] counter() {
        int[] choices = new int[5];

        int count = 0;

        while (count != 5) {
            int choice = scanner.nextInt();
            choices[count] = choice;
            count++;

        }
        return choices;
    }


    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}