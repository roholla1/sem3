package project.se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    private Sale sale;

    /**
     * Creates a new instance, representing a receipt.
     *
     * @param sale The information that will be on the receipt.
     */
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Makes the instance into a <code>String</code>
     *
     * @return Tbe instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\n")
                .append("------------------Begin receipt------------------")
                .append("\n")
                .append("Time of sale: ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .append("\n\n")
                .append(sale.toString())
                .append("\n")
                .append("-----------------------END---------------")
                .append("\n")
                .append("The change to give customer: ")
                .append(sale.getCashPayment().getChange())
                .append(" SEK"); 
        return builder.toString();
    }

}
