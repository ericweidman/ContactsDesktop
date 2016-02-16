package theironyard;

/**
 * Created by ericweidman on 2/16/16.
 */
public class Contact {
    String name;
    String phoneNumber;
    String email;

    @Override
    public String toString() {
        return name + ", " + phoneNumber+ ", " + email;
    }

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;


    }
}
