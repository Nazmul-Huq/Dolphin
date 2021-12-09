package Controller;

import Admin.TrainingResult;
import FileHandler.DelfinFileWriter;
import InputOutput.InputHandler;

/**
 * written by Nazmul
 */
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


}