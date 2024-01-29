public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {}

    // Static method to return the singleton instance
    public static Singleton getInstance() {
        if (instance == null) {// Check if the instance is not created.
            instance = new Singleton();
        }
        return instance;
    }
}