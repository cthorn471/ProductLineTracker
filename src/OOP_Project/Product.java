package OOP_Project;

/**
 * Product class is declared abstract and is used to declare all the generic attributes of a product(Id, type, name,
 * manufacturer).
 *
 * @author Christopher Thorn
 */
public abstract class Product implements Item {
    private int id;
    private ItemType type;
    private String manufacturer;
    private String name;

    /**
     * Product Constructor that accepts 3 parameters and sets their values.
     *
     * @param name         The name of the product.
     * @param manufacturer The company who makes the product.
     * @param type         The type of product that it is.
     */
    Product(int id, String name, String manufacturer, ItemType type) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    /**
     * The toString method displays the values of name, manufacturer and the type.
     *
     * @return the values of name, manufacturer and type.
     */
    public String toString() {
        return "\nName: " + name + "\nManufacturer: " + manufacturer + "\ntype: "
                + type;
    }

    Product(String name, String manufacturer, ItemType type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }
}
