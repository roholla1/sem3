package project.se.kth.iv1350.startup;

import project.se.kth.iv1350.controller.Controller;
import project.se.kth.iv1350.view.View;
/**
 * The main class responsible for initiating the program.
 */
public class Main {
    
    /**
     * The main method to start the program.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        view.show();
    }
}

