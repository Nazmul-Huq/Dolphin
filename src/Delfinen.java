import Controller.LoginController;
import Controller.SystemController;
import InputOutput.Menu;

import java.io.FileNotFoundException;

/**
 * written by Nazmul
 */
public class Delfinen {

    /**
     * create necessary objects
     */
    Menu menu = new Menu();
    SystemController controller = new SystemController();

    public static void main(String[] args) throws FileNotFoundException {

        // create an instance of Delfinen
        Delfinen delfinen = new Delfinen();
        //Login check
        LoginController loginControl = new LoginController();
        loginControl.verifyLogin();


        /**
         * show welcome message
         */
        delfinen.menu.welcome();

        /**
         * identify the actor (Chairman/Bookkeeper/Trainer), who want to perform a task
         */
        int actor = delfinen.menu.getActor();


        /**
         * this true loop to make sure a specific user can do multiple tasks
         * one after another without closing and restarting the app
         * if user enter 9 then the loop will break and app will be closed
         */
        while (true){

            //get a task to perform based on specific chosen actor
            int taskToDo = delfinen.menu.getTaskToDo(actor);

            if (taskToDo == 9) {
                break; // if user chose 9 at any point, the app will close
            } else {
                // start the chosen task
                delfinen.controller.startTask(actor, taskToDo);
            }
        }

    } // main() ends here
} // class ends here
