
/**
 * Represents a general menu item in the campus cafe.
 *
 * @author Jemybie H. Cayetano
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor.
     */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     *
     * @param name item name
     * @param basePrice item base price
     * @param itemCode item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of an item.
     *
     * @return computed price
     */
    public abstract double computePrice();

    /**
     * Returns item description.
     *
     * @return item name and code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return item name */
    public String getName() {
        return name;
    }

    /** @param name new item name */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid item name.");
        }
    }

    /** @return base price */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     *
     * @param basePrice new price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /** @return item code */
    public String getItemCode() {
        return itemCode;
    }

    /** @param itemCode new item code */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Invalid item code.");
        }
    }
}
