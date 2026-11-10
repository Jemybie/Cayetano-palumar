
/**
 * Main application for the Campus Cafe Ordering System.
 *
 * @author Jemybie H. Cayetano
 * @version 1.0
 */
public class CafeApp {

    /**
     * Starts the campus cafe ordering system.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create customers using different constructors.
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        // Demonstrate the default Customer constructor.
        Customer customer3 = new Customer();

        // Create a default Beverage and use setters.
        Beverage hotChocolate = new Beverage();

        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");

        // Demonstrate invalid and valid base prices.
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        // Create a parameterized Beverage.
        Beverage latte = new Beverage(
            "Iced Latte", 95, "B-01", "L"
        );

        // Create a default Pastry and set its values.
        Pastry defaultPastry = new Pastry();
        defaultPastry.setName("Cookie");
        defaultPastry.setBasePrice(35);
        defaultPastry.setItemCode("P-02");

        // Create a parameterized Pastry.
        Pastry ensaymada = new Pastry(
            "Ensaymada", 45, "P-01", true
        );

        // Create a default Meal and set its values.
        Meal defaultMeal = new Meal();
        defaultMeal.setName("Sample Meal");
        defaultMeal.setBasePrice(100);
        defaultMeal.setItemCode("M-03");
        defaultMeal.setExtraSides(0);

        // Create a parameterized Meal.
        Meal chickenAdobo = new Meal(
            "Chicken Adobo", 110, "M-01", true, 1
        );

        Meal beefTapa = new Meal(
            "Beef Tapa", 130, "M-02", false, 0
        );

        // Create first order.
        Order order1 = new Order("1001", customer1);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        // Try adding a fourth item.
        order1.addItem(defaultPastry);

        // Print first receipt.
        order1.printReceipt();

        // Create second order.
        Order order2 = new Order("1002", customer2);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        // Print second receipt with a 20-peso voucher.
        order2.printReceipt(20);
    }
}
