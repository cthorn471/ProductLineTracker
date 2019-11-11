package OOP_Project;

/**
 * The MoviePlayer class inherits Product and implements the methods from MultimediaControl who's body are filled in
 * here. Then it declares two private variables screen and monitorType. Creates a constructor called MoviePlayer that
 * accepts 4 parameters, calls its parents constructor and sets the ItemType to "VISUAL". After that we create a
 * method called toString which returns the parents toString method + our local toString method that will print out
 * our screen and monitor values.
 *
 * @author Christopher Thorn
 */
public class MoviePlayer extends Product implements MultimediaControl {

    @Override
    public void play() {
        System.out.println("Playing movie");
    }

    @Override
    public void stop() {
        System.out.println("Stopping movie");
    }

    @Override
    public void previous() {
        System.out.println("Previous movie");
    }

    @Override
    public void next() {
        System.out.println("Next movie");
    }

    /**
     * private local variable used to hold the values of our screen and monitor type.
     */
    private Screen screen;
    private MonitorType monitorType;

    /**
     * Constructor called MoviePlayer that accept 4 parameters as arguments. calls parents constructor and sets ItemType
     * to "VISUAL".
     *
     * @param name         The name of the product .
     * @param manufacturer The company who makes the product.
     * @param screen       This is used for information about our screen.
     * @param monitorType  holds the type of monitor we are using.
     */
    MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer, ItemType.VISUAL);
        this.monitorType = monitorType;
        this.screen = screen;
    }

    /**
     * This toString method calls the parent constructor in the Product class, sets the ItemType to "VISUAL" and adds
     * this classes toString method to display the product classes constructor + screen and monitorType.
     *
     * @return the products toString method along with screen + monitorType.
     */
    public String toString() {
        return super.toString() + ("\nScreen: " + screen + "\nMonitor: " + monitorType);
    }
}
