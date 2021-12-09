package Admin;

public class Admin {

    /**
     * instance variables
     */
    private int id;
    private String fullName;
    private int phoneNumber;
    private String email;
    private String address;

    /**
     * constructor
     */
    public Admin(int id, String fullName, int phoneNumber, String email, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // get the id
    public int getId() {
        return id;
    }

    // get the full name
    public String getFullName() {
        return fullName;
    }

    // get the phone number
    public int getPhoneNumber() {
        return phoneNumber;
    }

    // get the email
    public String getEmail() {
        return email;
    }

    // get the address
    public String getAddress() {
        return address;
    }



    /**
     * format the to string
     */
    @Override
    public String toString() {
        return id + "," + fullName +  "," + phoneNumber +  "," + email +  "," + address;
    }
} // class ends here