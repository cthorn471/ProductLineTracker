package OOP_Project;

import java.util.Date;

/**
 * The production record class declares 5 variables, sets up geters and setters for them all in order to create a record
 * for every product.
 */

public class ProductionRecord {
    private int productNumber;
    private int productID;
    private String serialNumber;
    private Date dateProduced;
    private int countItems;

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    ProductionRecord(int productID) {
        this.productID = productID;
        productNumber = 0;
        serialNumber = "0";
        dateProduced = new Date();
    }

    /**
     * Constructor that accepts 4 variables as arguments in order to be used in displaying the products information.
     * @param productNumber the number in which the product is produced.
     * @param productID The unique ID given to the product.
     * @param serialNumber A unique serial number given to the product.
     * @param dateProduced When the product was produced.
     */
    ProductionRecord(int productNumber, int productID, String serialNumber, Date dateProduced) {
        this.productID = productID;
        this.productNumber = productNumber;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }

    /**
     * Here we overload the Production Record constructor so we can set a unique serial number for every product.
     * @param productObject an object of type Product to be able to get the Type.
     * @param countItems variable used to count how many items.
     */
    ProductionRecord(Product productObject, int countItems) {
        serialNumber = (productObject.getManufacturer().substring(0, 3) + productObject.getType().getCode() +
                String.format("%05d", countItems));
        dateProduced = new Date();
    }

    /**
     * Display the info to the user.
     * @return returns the printed out statement to the screen.
     */
    public String toString() {
        return "Prod. Num: " + productNumber + "\tProduct ID: " + productID + "\tSerial Num: " + serialNumber +
                "\tDate: " + dateProduced;
    }
}
