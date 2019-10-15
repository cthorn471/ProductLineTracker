package OOP_Project;

/**
 * The Item interface declares 5 methods that we implement in our product class.
 */
public interface Item {
    int getId();
    void setName(String name);
    String getName();
    void setManufacturer(String manufacturer);
    String getManufacturer();

}
