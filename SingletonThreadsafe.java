public class SingletonThreadsafe {
    private static volatile SingletonThreadsafe instance;

    // Private constructor to prevent instantiation from outside
    private SingletonThreadsafe() {}

    // Static method to return the singleton instance with locking
    public static SingletonThreadsafe getInstance() {
            synchronized (SingletonThreadsafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadsafe();
                }
            }
        return instance;
    }
}