package InputOutput;

import java.util.Scanner;


/**
 * written by Nazmul
 */
public class Menu {

    /**
     * instantiate necessary objects
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * welcome message to show during startup
     * image was copied from https://www.asciiart.eu/animals/dolphins
     */
    public void welcome(){
        System.out.println("Welcome to swimming club \"Dolphin\" " + "\uD83D\uDC2C" + "\uD83D\uDC2C" + "\uD83D\uDC2C");
    }

    /**
     *
     */
    public int getActor(){
        printActorToSelect(); // print the options
        int actor = Integer.parseInt(scanner.nextLine()); // get the choice
        return actor; // return the choice

    }

    /**
     * get what a specific actor want to do
     */
    public int getTaskToDo(int actor){
        System.out.println("Chose a task from below list");
        if (actor == 1) { // chairman
            printChairmanMenuOptions();
        } else if (actor == 2) { // trainer
            printTrainerMenuOptions();
        } else if (actor == 3) { // bookkeeper
            printBookkeeperMenuOptions();
        } else {
            System.out.println("Please provide a valid actor");
        }
        int taskToDo = Integer.parseInt(scanner.nextLine());
        return taskToDo;
    }


    /**
     * print the list of actors to chose from (example chairman, trainer ... )
     */
    private void printActorToSelect(){
        System.out.println("Chose your identity");
        System.out.println("1. Chairman, 2. Trainer, 3. Bookkeeper");
    }

    /**
     * print the options that a chairman can do in the system
     */
    private void printChairmanMenuOptions(){
        System.out.println("1. Add new member, 2. Add new employee, 3. Add event, 4. Delete Member,  5. Delete Employee 9. Exit app");
    }

    /**
     * print the options that a Trainer can do in the system
     */
    private void printTrainerMenuOptions(){
        System.out.println("1. Add swimmer, 2. Show swimmer info, 3. Add swimmer to team, 4. Add Swimming Discipline, 5. Edit List, 6. Add swimmer to event, 7. Add training result, 8. See best swimmer, 9. Exit app");
    }

    /**
     * print the options that a Bookkeeper can do in the system
     */
    private void printBookkeeperMenuOptions(){
        System.out.println("1. Calculate fees, 2, Calculate income, 3. calculate debt, 4. Calculate Future Income, 9. Exit app");
    }

    public int getSwimmingDiscipline(){
        System.out.println("Chose swimming discipline: 1. Backstroke, 2. Freestyle, 3. Butterfly");
        int swimmingDiscipline = Integer.parseInt(scanner.nextLine());
        return swimmingDiscipline;
    }
}