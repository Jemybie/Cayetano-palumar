
/**
 * Represents a cafe order containing up to three menu items.
 *
 * @author Jemybie H. Cayetano
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates a new order.
     *
     * @param orderId order identification
     * @param customer customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot.
     *
     * @param item menu item to add
     * @return true if added successfully
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Invalid menu item.");
            return false;
        } else if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                               + item.getName() + ".");
            return false;
        } else if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    /**
     * Computes subtotal of all items.
     *
     * @return subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Computes total with student discount if applicable.
     *
     * @return final total
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    /**
     * Computes total after applying voucher.
     *
     * @param voucher voucher amount
     * @return final total after voucher
     */
    public double computeTotal(double voucher) {
        if (voucher < 0) {
            voucher = 0;
        }

        double total = computeTotal() - voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /**
     * Prints receipt without voucher.
     */
    public void printReceipt() {
        printReceipt(0);
    }

    /**
     * Prints receipt with an optional voucher.
     *
     * @param voucher voucher amount
     */
    public void printReceipt(double voucher) {

        double subtotal = computeSubtotal();
        double discount = 0;
        double total = computeTotal(voucher);

        System.out.println("\nOrder #" + orderId +
                           " - " + customer.getName());

        if (customer.isStudent()) {
            System.out.println("Customer Type: Student");
            discount = subtotal * 0.10;
        }

        if (item1 != null) {
            System.out.printf("  %-38s %.2f%n",
                    item1.getDescription(),
                    item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("  %-38s %.2f%n",
                    item2.getDescription(),
                    item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("  %-38s %.2f%n",
                    item3.getDescription(),
                    item3.computePrice());
        }

        System.out.printf("  Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("  Student discount (10%%): -%.2f%n",
                              discount);
        }

        if (voucher > 0) {
            System.out.printf("  Voucher: -%.2f%n", voucher);
        }

        System.out.printf("  TOTAL: %.2f%n", total);

        // Add loyalty points based on the amount actually paid.
        customer.addPoints(total);

        System.out.println("  Loyalty points: " +
                           customer.getLoyaltyPoints());
    }
}
