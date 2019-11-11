package OOP_Project;

/**
 * Enum ItemType declares the 4 types of products we will be storing to our database.
 * Declares a local variable called code to use in the constructor called ItemType.
 * Creates a method called getType which returns our local variable code which we use to get what type of product the
 * user is choosing.
 */
public enum ItemType {
    AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

    /**
     * declares a local variable String code.
     * constructor ItemType accepts code as a parameter and sets this.code = to the parameter code that was passed in.
     */
    private String code;

    ItemType(String code) {
        this.code = code;
    }

    /**
     * Method getType returns variable code and is used to get the type that the user chooses from our GUI.
     *
     * @return the variable code.
     */
    public String getCode() {

        return code;
    }
}
