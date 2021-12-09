package Controller;


import FileHandler.DelfinFileReader;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class written by Søs
 */

public class LoginController {

    static Scanner scan = new Scanner(System.in);
    DelfinFileReader delfinFileReader = new DelfinFileReader();

    //Method to see if a username and password match
    public void verifyLogin() {
        ArrayList<String> loginInformation = delfinFileReader.getLoginInformation();

        boolean found = false;

        while (!found) {

            System.out.println("Please write your username...");
            String username = scan.next();
            System.out.println("Please write your password...");
            String password = scan.next();

            String findUser = "";
            String findPassword = "";

            for (int i = 0; i < loginInformation.size(); i++) {
                String employeeLogin = loginInformation.get(i);

                String[] loginList = employeeLogin.split(",");

                findUser = loginList[0];
                findPassword = loginList[1];

                if (findUser.equals(username) && findPassword.equals(password)) {

                    found = true;

                    //System.out.println("Login success");
                    break;
                }
            }
            if (found == false) {
                System.out.println("Wrong username or password");

            } else {
                System.out.println("Login success");
            }
        }
    }
}
