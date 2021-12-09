package Admin;

public class PassiveMember extends Admin{

    // instance variable
    private String membershipType;

    /**
     * constructor using all variables
     */
    public PassiveMember(int id, String fullName, int phoneNumber, String email, String address, String membershipType) {
        super(id, fullName, phoneNumber, email, address);
        this.membershipType = membershipType;
    }

    /**
     * get the membership type
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * set the membership type
     */
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * format the to string
     */
    @Override
    public String toString() {
        return super.toString() + "," +membershipType;
    }
}