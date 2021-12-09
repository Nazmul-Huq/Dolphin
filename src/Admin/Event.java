package Admin;

/**
 * written by Mohammad
 */
public class Event {

    //Attributes
    private String Date;
    private int time;
    private String location;
    private int id;


    //constructor for Events
    public Event(String date, int time, String location, int id) {
        Date = date;
        this.time = time;
        this.location = location;
        this.id = id;

    }



    //Getters
    public String getDate() {
        return Date;
    }

    public int getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    //toString Method so the result doesn't fuck up.
    @Override
    public String toString() {
        return "Event: " + "Date: " + Date + "," + "time: " + time + "," +
                " location: " + location + "," +  " id: " + id ;
    }
}