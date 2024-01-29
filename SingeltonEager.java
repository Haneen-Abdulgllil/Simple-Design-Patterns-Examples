public class SingeltonEager {
    // Here the instance is created upon class creation.
    private static final SingeltonEager INSTANCE = new SingeltonEager();

    // Private constructor to prevent instantiation from outside
    private SingeltonEager() {}

    public static SingeltonEager getInstance() {
        return INSTANCE;
    }
}