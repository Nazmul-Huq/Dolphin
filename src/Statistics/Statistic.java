package Statistics;

import FileHandler.DelfinFileReader;
import FileHandler.DelfinFileWriter;
import InputOutput.InputHandler;
import InputOutput.OutputHandler;

import java.util.*;

/**
 * Written by Namul
 */
public class Statistic {

    DelfinFileReader delfinFileReader = new DelfinFileReader();
    DelfinFileWriter delfinFileWriter = new DelfinFileWriter();
    OutputHandler outputHandler = new OutputHandler();
    InputHandler inputHandler = new InputHandler();


    public void seeBestSwimmer(int swimmingDisciplineId){

        // get training data of chosen discipline out of all training data
        ArrayList<String[]> trainingResultsGivenDiscipline = getTrainingDataChosenDiscipline(swimmingDisciplineId );

        // get player records as HashMap, player id as key and value as arraylist of all swim timing
        HashMap<Integer, ArrayList<Integer>> playerRecords = getPlayersRecords(trainingResultsGivenDiscipline);

        // get each player's average timing. ( Note: Make the average from best 3 results of each player).
        HashMap<Integer, Integer> playerAverageTimings = getPlayerAverageTiming(playerRecords);
        // sort the player average timings in descending order
        playerAverageTimings = sortByValues(playerAverageTimings);

        // get the 5 best players out of all player
        HashMap<Integer, Integer> fiveBestSwimmers = getFiveBestSwimmer(playerAverageTimings);
        // sor the 5 best player in descending ordr
        fiveBestSwimmers  = sortByValues(fiveBestSwimmers);

        // print top 5 swimmers detail of the chosen discipline
        System.out.println("Top 5 swimmers with average record");
        outputHandler.printFiveBestSwimmerInformation(fiveBestSwimmers);

        // save top 5 swimmers as pdf
        String fileName = inputHandler.getFileName();
        delfinFileWriter.saveTopSwimmerAsPdf(fiveBestSwimmers, fileName);



/*        // this will print  all swimmers average record of the chosen discipline
        // this is not necessary to show, but can be helpful to see if the calculation working or not
        // just make this block uncomment to see all swimmers average timing
        System.out.println("All swimmers average record");
        for (Integer key: playerAverageTimings.keySet()) {
            System.out.print(key);
            System.out.print(": ");
            System.out.println(playerAverageTimings.get(key));
        }*/

    } // seeBestSwimmer() ends here


    /**
     * Get 5 best swimmers out of all swimmers and return it
     * @param playerAverageTimings
     * @return
     */
    public HashMap<Integer, Integer> getFiveBestSwimmer(HashMap<Integer, Integer> playerAverageTimings){
        HashMap<Integer, Integer> fiveBestSwimmers = new HashMap<>();
        int count = 0;
        for (Integer key: playerAverageTimings.keySet()) {
            fiveBestSwimmers.put(key, playerAverageTimings.get(key));
            count++;
            if (count == 5)
                break;
        }
        return fiveBestSwimmers;
    }

    /**
     * sort a given HashMap
     * idea was taken from https://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
     */
    private static HashMap sortByValues(HashMap map) {

        // make a linked list from given HashMap
        List list = new LinkedList(map.entrySet());

        // Define the Custom Comparator
        Collections.sort(list, new Comparator() {
            public int compare(Object a, Object b) {
                return ((Comparable) ((Map.Entry) (b)).getValue())
                        .compareTo(((Map.Entry) (a)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }


    /**
     *  calculate average time for each player
     *  to calculate average timing, we will take best 3 performance from each player and will make the average
     *  if a player do not have 3 records, we will exclude the player from the calculation
     *  finally all players average timing will be returned as Hashmap<playerId, playerAverageTiming>
     */
    public HashMap<Integer, Integer> getPlayerAverageTiming(HashMap<Integer, ArrayList<Integer>> playerRecords){

        // create hashmap to store player id and average timing
        HashMap<Integer, Integer> playerAverageTimings = new HashMap<>();

        // iterate over each record in the given data set
        for (Integer key: playerRecords.keySet()) {
            // get the individual player's record
            ArrayList<Integer> individualPlayerRecord = playerRecords.get(key);

            // check of player has 3 or more timings recorded or not, if yes then perform calculation.
            if (individualPlayerRecord.size() >= 3) {
                // sort the player records from higher ot lower
                Collections.reverse(individualPlayerRecord);
                // get first 3 highest record, add it and divide by 3 to get the average
                int playerAverageTiming = ( individualPlayerRecord.get(0) + individualPlayerRecord.get(1)+ individualPlayerRecord.get(2) ) / 3;
                // add the player id as key and timing as value in the "playerAverageTimings" HashMap
                playerAverageTimings.put(key, playerAverageTiming);
            }
        }
        return playerAverageTimings;
    }


    /**
     * This method will collect all timings of each player and make an arraylist for each player
     * then put the arraylist in the HashMap as playerId as key and newly made arrayList as value
     * in this way we will get a HashMap as playe'r id as key, player's all timing as arrayList "playerRecords<playerId, ArrayList<PlayerTimings>"
     * @param trainingResultsGivenDiscipline
     * @return
     */
    public HashMap<Integer, ArrayList<Integer>> getPlayersRecords(ArrayList<String[]> trainingResultsGivenDiscipline){

        HashMap<Integer, ArrayList<Integer>> playerRecords = new HashMap<Integer, ArrayList<Integer>>();

        while (trainingResultsGivenDiscipline.size() != 0) {
            ArrayList<String[]> temp = new ArrayList<>();
            ArrayList<Integer> swimTimings = new ArrayList<>();

            // get the first row from the dataset
            String[] dataInIndividualRecord = trainingResultsGivenDiscipline.get(0);
            // get the player's id from the first row of data
            int id = Integer.parseInt(dataInIndividualRecord[0]);

            // iterate over all rows, check any row have the same player id or not
            // if same id found then, copy the timing and add to the arraylist "swimTimings"
            // if a row does not have the same id, then copy the row to arrayList "temp"
            // after finishing of iterating, add swimTimings to the HashMap "playerRecords" with id as Key
            // plus replace the arraylist "trainingResultsGivenDiscipline" with arrayList "temp", so all occurrence of a specific id is removed
            for (int i = 0; i < trainingResultsGivenDiscipline.size(); i++) {

                // get each individual record from given dataset
                dataInIndividualRecord = trainingResultsGivenDiscipline.get(i);

                // get the swimmer's id. 0 = as we know first column of the data is swimmer's id
                int swimmerId = Integer.parseInt(dataInIndividualRecord[0]);

                // check if id in concern is same as the swimmer's id
                if (id == swimmerId) { //if yes
                    // get the result (timing of swimming). 2 = as we know third column of the data is swimmer's timing of each swim
                    int swimTime = Integer.parseInt(dataInIndividualRecord[2]);
                    // add the timing to the ArrayLIst swimTiming
                    swimTimings.add(swimTime);
                } else { // if not
                    temp.add(dataInIndividualRecord);
                }
            }
            // add swim timings to the player records HashMap
            playerRecords.put(id, swimTimings);
            // replace given data set with temp data set
            trainingResultsGivenDiscipline = temp;
        }
        return playerRecords;
    }

    /**
     * extract training results of the given discipline from all training results
     */
    private ArrayList<String[]> getTrainingDataChosenDiscipline( int swimmingDisciplineId){

        // get all training data
        ArrayList<String> allTrainingResults = delfinFileReader.getTrainingResult();

        // store training data of chosen discipline
        ArrayList<String[]> trainingResultsGivenDiscipline = new ArrayList<>();

        for (int i = 0; i < allTrainingResults.size(); i++) {
            String individualRecord = allTrainingResults.get(i);
            String[] dataInIndividualRecord = individualRecord.split(",");
            int swimmingDisciplineIdInRecord = Integer.parseInt(dataInIndividualRecord[1]);
            if ( swimmingDisciplineIdInRecord == swimmingDisciplineId) {
                trainingResultsGivenDiscipline.add(dataInIndividualRecord);
            }
        }
        return trainingResultsGivenDiscipline;
    }
}