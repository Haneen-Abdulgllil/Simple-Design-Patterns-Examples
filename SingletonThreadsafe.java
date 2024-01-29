public class SingletonThreadsafe {
    private static volatile SingletonThreadsafe instance;

    // Private constructor to prevent instantiation from outside
    private SingletonThreadsafe() {}

    // Static method to return the singleton instance with double locking
    public static SingletonThreadsafe getInstance() {
          if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}