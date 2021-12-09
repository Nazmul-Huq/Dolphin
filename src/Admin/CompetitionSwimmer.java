package Admin;


public class CompetitionSwimmer extends ActiveMember{

    /**
     * instance variables
     */
    private int trainerId;

    /**
     * constructor using all variables
     */
    public CompetitionSwimmer(int id, String fullName, int phoneNumber, String email, String address, int age, String membershipType, int trainerId) {
        super(id, fullName, phoneNumber, email, address, age, membershipType);
        this.trainerId = trainerId;
    }

    /**
     * get the trainer id
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * set the trainer id
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * format the to string
     */
    @Override
    public String toString() {
        return super.toString() + "," +trainerId;
    }
}