package sample;

abstract class Product implements Item,{

    private int Id;
    private String Type;
    private String Manufacturer;
    private String Name;

    //product constructor
    Product(String name, String manufacturer, String type){
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;
    }

    public String toString(){
        return "Name: + "+ Name + "\n Manufacturer: + "+ Manufacturer + "\n type: + "
                + Type;
    }
    public int getId(){
        return Id;
    }

    public String getManufacturer(){
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer){
        Manufacturer = manufacturer;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name = name;
    }

    class widget extends Product{
        public widget(String name, String manufacturer, String type){
            super(name,manufacturer,type);
        }
    }
}
