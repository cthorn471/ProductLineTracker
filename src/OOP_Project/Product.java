package OOP_Project;

/**
 * Product class is declared abstract and is used to declare all the generic attributes of a product(Id, type, name,
 * manufacturer).
 * @author Christopher Thorn
 */
abstract class Product implements Item {

    private int Id;
    private ItemType type;
    private String manufacturer;
    private String name;

    /**
     * Product Constructor that accepts 3 parameters and sets their values.
     * @param name The name of the product.
     * @param manufacturer The company who makes the product.
     * @param type The type of product that it is.
     */
    Product(String name, String manufacturer, ItemType type){
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    /**
     * The toString method displays the values of name, manufacturer and the type.
     * @return the values of name, manufacturer and type.
     */
    public String toString(){
        return "\nName: "+ name + "\nManufacturer: "+ manufacturer + "\ntype: "
                + type;
    }

    public int getId(){
        return Id;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
