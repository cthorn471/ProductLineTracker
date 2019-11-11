package OOP_Project;

/**
 * Class Screen implements ScreenSpec and fills in its method bodies.Then it creates a constructor called Screen which
 * accepts 3 parameters and sets their values. Next it creates a toString method that calls its parents constructor
 * "Product" + resolution, refreshrate and responsetime.
 *
 * @author Christopher Thorn
 */
public class Screen implements ScreenSpec {
    private String resolution;
    private int refreshrate;
    private int responsetime;

    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public int getRefreshRate() {
        return refreshrate;
    }

    @Override
    public int getResponseTime() {
        return responsetime;
    }

    /**
     * Screen constructor accepts 3 parameters and initializes their values within the constructor.
     *
     * @param resolution   holds the value for the screens resolution.
     * @param refreshrate  holds the value for the screens refreshrate.
     * @param responsetime holds the value for the screens responsetime.
     */
    Screen(String resolution, int refreshrate, int responsetime) {
        this.resolution = resolution;
        this.refreshrate = refreshrate;
        this.responsetime = responsetime;
    }

    /**
     * The toString method returns the resolution, refreshrate and responsetime.
     *
     * @return resolution, refreshrate and responsetime
     */
    public String toString() {
        return "\nResolution: " + resolution + "\nRefresh Rate: " + refreshrate + "\nResponse time: "
                + responsetime;
    }
}
