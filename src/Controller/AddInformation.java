package Controller;

import Admin.TrainingResult;
import FileHandler.DelfinFileWriter;
import InputOutput.InputHandler;


public class AddInformation {

    InputHandler inputHandler = new InputHandler();
    DelfinFileWriter delfinFileWriter = new DelfinFileWriter();



    public void addTrainingResult(){

        // get required information
        int swimmerId = inputHandler.getSwimmerId();
        int swimmingDisciplineId = inputHandler.getTrainingDisciplineId();
        int result = inputHandler.getTrainingResults();

        // make training result
        TrainingResult newTrainingResult = new TrainingResult(swimmerId, swimmingDisciplineId, result);

        // add result to the file training_result.txt
        delfinFileWriter.saveTrainingResult(newTrainingResult);

        //System.out.println(newTrainingResult);
    }

    //
    public void addCompetitionSwimmer(){
        //    public CompetitionSwimmer(int id, String fullName, int phoneNumber, String email, String address,
/*        //    int age, String membershipType, int trainerId, ArrayList<Integer> trainingResults) {
        setId();
        setFullName();
        setPhoneNumber();
        setEmail();
        setAddress();
        setAge();
        setMembershipType();
        setTrainerId();
        setTrainingResults();*/

        //CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer(id, fullName, phoneNumber, email, address, age, membershipType, trainerId, trainingResults);
        //System.out.println(competitionSwimmer);
    }


}