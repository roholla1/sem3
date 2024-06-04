package project.se.kth.iv1350.view;

import project.se.kth.iv1350.controller.Controller;

import project.se.kth.iv1350.model.SaleDTO;
import project.se.kth.iv1350.model.Total;
/**
 * The View class represents the user interface for displaying sale-related information.
 */
public class View {
    private Controller contr;

    /**
     * Constructs a View object with the specified controller.
     *
     * @param contr The Controller object to interact with the sale process.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Displays the sale process, including registering items, ending the sale, and processing payment.
     */
    public void show() {
        System.out.println();
        contr.startSale();
        SaleDTO item = contr.registerItem("abc123");
        System.out.println(item + "\n");
        SaleDTO item2 = contr.registerItem("abc123");
        System.out.println(item2 + "\n");
        SaleDTO item3 = contr.registerItem("def456");
        System.out.println(item3 + "\n");
        System.out.println("End sale:");
        Total totalPrice = contr.endSale();
        System.out.println(totalPrice + "\n");
        System.out.println("Customer pays 100 SEk:");
        System.out.println("Sent sale info to external accounting system.");
        System.out.println("told to update item Registry");
        contr.processPayment(100);
        System.out.println();
    }
}
