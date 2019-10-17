package OOP_Project;

import java.util.Date;

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

    ProductionRecord(int productID){
        this.productID = productID;
        productNumber = 0;
        serialNumber = "0";
        dateProduced = new Date();
    }

    //overloaded constructor
    ProductionRecord(int productNumber, int productID, String serialNumber, Date dateProduced){
        this.productID = productID;
        this.productNumber = productNumber;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }
    //overloaded constructor issue 5
    ProductionRecord(Product productObject, int countItems){
        serialNumber = (productObject.getManufacturer().substring(0, 3) + productObject.getType().getCode() +
                String.format("%05d", countItems));
        dateProduced = new Date();
    }

    public String toString(){
        return "Prod. Num: " + productNumber + "\tProduct ID: " + productID + "\tSerial Num: " + serialNumber +
                "\tDate: " + dateProduced;
    }
}
