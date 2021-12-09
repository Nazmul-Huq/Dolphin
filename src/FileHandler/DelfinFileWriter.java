package FileHandler;

import Admin.ActiveMember;
import Admin.Event;
import Admin.Trainer;
import Admin.TrainingResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DelfinFileWriter {


    /**
     * Nazmul
     * method to save training result to the training_result.txt file
     */
    public void saveTrainingResult(TrainingResult newTrainingResult){
        try {
            File file = new File("Files/training_result.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(newTrainingResult + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }


    // written by Mohammad
    public void eventList(int[] swimmerEvent){
        try {
            File file = new File("Files/event.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(swimmerEvent + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    // written by Mohammad
    public void swimmerTeam(int[] swimmerEvent){
        try {
            File file = new File("Files/teams.txt");
            FileWriter fr = new FileWriter(file, true);

            fr.write(swimmerEvent[0]);
            fr.write(",");

            fr.write(swimmerEvent[1]);
            fr.write(",");

            fr.write(swimmerEvent[2]);
            fr.write(",");

            fr.write(swimmerEvent[3]);
            fr.write(",");

            fr.write(swimmerEvent[4]);
            fr.write(",");




            fr.write("\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    // written by Mohammad
    public void disciplines(int[] swimmerDisciplines){
        try {
            File file = new File("Files/disciplineTraining.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(swimmerDisciplines + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    /**
     * Nazmul
     * method to save top swimmer (after statistical calculations) as pdf in folder files >> top_swimmer_pdf_files
     */
    public void saveTopSwimmerAsPdf(HashMap<Integer, Integer> swimmerInformation, String fileName){

        try {

            // create pdf document and a blank page
            PDDocument document = new PDDocument();
            PDPage blankPage = new PDPage();

            // add blank page to current document
            document.addPage(blankPage);

            // will need to print players position
            int position  = 1;

            // write in the document
            PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
            // select font type and size
            contentStream.setFont( new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12 );
            //start writing txt
            contentStream.beginText();
            // select position to start writing
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);

            // write the information
            contentStream.showText("Top 5 swimmers");
            contentStream.newLine();
            contentStream.showText("Position" + "    " + "Swimmer Id " + "    " + "Timing");
            contentStream.newLine();
            contentStream.showText("---------------------------------------------------------------------");
            contentStream.newLine();
            for (Integer key: swimmerInformation.keySet()) {
                contentStream.showText(position + "                     " + key + "                     " + swimmerInformation.get(key));
                contentStream.newLine();
                position++;
            }
            contentStream.newLine();
            contentStream.showText("---------------------------------------------------------------------");
            contentStream.newLine();
            contentStream.showText("File was created at: " + new Date());
            contentStream.newLine();

            // finish writing and close the document
            contentStream.endText();
            contentStream.close();

            //save as pdf
            document.save("Files/top_swimmer_pdf_files/"+ fileName + ".pdf");
            System.out.println("File successfully saved as pdf. Find file at "+"Files/top_swimmer_pdf_files/"+ fileName + ".pdf");
        } catch (Exception e){
            System.out.println("file failed to add");
        }
    }

    /**
     * SARA'S CODE
     */
    //Save new member info:
    public void addNewMember(ActiveMember memberInfo) {

        try {
            File file = new File("Files/members.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(memberInfo + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    //Save new event info
    public void newEvent(Event newEvent) {
        try {
            File file = new File("Files/event.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(newEvent + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    //Save new employee info
    public void addNewEmployee(Trainer newTrainer) {
        try {
            File file = new File("Files/employee.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(newTrainer + "\n");
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }



    //Delete Member
    public void deleteMember(ArrayList<String> memberInfo) {
        try {
            File file = new File("Files/members.txt");
            FileWriter deleteAllData = new FileWriter(file, false);
            deleteAllData.close();



            FileWriter fr = new FileWriter(file, true);
            for (int i = 0; i < memberInfo.size(); i++) {
                String info = memberInfo.get(i);
                fr.write(info + "\n");
            }
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    //Delete employee
    public void deleteEmployee(ArrayList<String> employeeInfo) {
        try {
            File file = new File("Files/employee.txt");
            FileWriter deleteAllData = new FileWriter(file, false);
            deleteAllData.close();



            FileWriter fr = new FileWriter(file, true);
            for (int i = 0; i < employeeInfo.size(); i++) {
                String info = employeeInfo.get(i);
                fr.write(info + "\n");
            }
            fr.close();
            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Failed to add file"); }
    }

    /**
     * SARA'S CODE END
     */

} // class ends here