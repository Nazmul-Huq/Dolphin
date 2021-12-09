package Admin;



public class ActiveMember extends Admin{

    /**
     * instance variables
     */
    private int age;
    private String membershipType;

    /**
     * constructor using all variables
     */
    public ActiveMember(int id, String fullName, int phoneNumber, String email, String address, int age, String membershipType) {
        super(id, fullName, phoneNumber, email, address);
        this.age = age;
        this.membershipType = membershipType;
    }

    /**
     * get the age
     */
    public int getAge() {
        return age;
    }

    /**
     * set the age
     */
    public void setAge(int age) {
        this.age = age;
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
     *
     */
    @Override
    public String toString() {
        return super.toString() + "," + age + "," +membershipType;
    }
}
