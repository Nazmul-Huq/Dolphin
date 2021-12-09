package InputOutput;

import java.util.HashMap;

public class OutputHandler {

    /**
     * Written by Nazmul
     *  print the given information with nice format
     * @param swimmerInformation
     */
    public void printFiveBestSwimmerInformation( HashMap<Integer, Integer> swimmerInformation){
        System.out.println("Player Id\t" + "Average Timing" );
        for (Integer key: swimmerInformation.keySet()) {
            System.out.print(key);
            System.out.print("\t\t\t");
            System.out.println(swimmerInformation.get(key));
        }
    }



} // class ends here